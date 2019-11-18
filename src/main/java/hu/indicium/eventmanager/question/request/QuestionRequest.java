package hu.indicium.eventmanager.question.request;

public class QuestionRequest {
    private Long id;
    private String type;
    private String question;

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
