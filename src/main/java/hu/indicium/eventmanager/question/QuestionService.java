package hu.indicium.eventmanager.question;

import java.util.*;
import org.springframework.stereotype.*;
import hu.indicium.eventmanager.question.request.QuestionRequest;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question addQuestion(QuestionRequest questionRequest) {
        Question question = this.questionReqToQuestion(questionRequest, null);
        return questionRepository.save(question);
    }

    public Question updateQuestionById(long eventId, QuestionRequest eventRequest) {
        return null;
    }

    public void deleteQuestionById(long eventId) {

    }

    public Question findQuestionById(Long eventId) {
        return null;

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
