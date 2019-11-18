package hu.indicium.eventmanager.question;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import hu.indicium.eventmanager.response.*;
import hu.indicium.eventmanager.question.request.*;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return questions;
    }

    @PostMapping("/questions")
    public Response createQuestion(@RequestBody QuestionRequest questionRequest) {
        Question question = questionService.addQuestion(questionRequest);
        return new Response(question, null);
    }

    @PutMapping("/questions/{id}")
    public Response updateQuestion(@RequestBody QuestionRequest questionRequest, @PathVariable long id) {
        Question updatedQuestion = questionService.updateQuestionById(id, questionRequest);
        return new Response(updatedQuestion, null);
    }

    @DeleteMapping("/questions/{id}")
    public Response deleteQuestion(@PathVariable long id) {
        questionService.deleteQuestionById(id);
        return new Response(true, null);
    }
}
