package hu.indicium.eventmanager.question;

import javax.persistence.*;

@Entity
public class Question {

    @Id
    @SequenceGenerator(name = "question_id_generator", sequenceName = "question_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id_generator")
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
