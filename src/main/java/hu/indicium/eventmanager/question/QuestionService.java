package hu.indicium.eventmanager.question;

import java.util.*;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.*;
import hu.indicium.eventmanager.question.request.QuestionRequest;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @PreAuthorize("true")
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @PreAuthorize("hasPermission('write:user')")
    public Question addQuestion(QuestionRequest questionRequest) {
        Question question = this.questionReqToQuestion(questionRequest, null);
        return questionRepository.save(question);
    }

    @PreAuthorize("hasPermission('update:user')")
    public Question updateQuestionById(long questionId, QuestionRequest questionRequest) {
        Question question = findQuestionById(questionId);

        if (!question.equals(null)) {
            this.questionReqToQuestion(questionRequest, question);
            return questionRepository.save(question);
        }

        return null;
    }

    @PreAuthorize("hasPermission('delete:user')")
    public void deleteQuestionById(long questionId) {
        questionRepository.deleteById(questionId);
    }

    @PreAuthorize("true")
    public Question findQuestionById(long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    private Question questionReqToQuestion(QuestionRequest questionRequest, Question question) {
        if (question == null) {
            question = new Question();
        }

        question.setType(questionRequest.getType());
        question.setQuestion(questionRequest.getQuestion());

        return question;
    }
}
