package hu.indicium.eventmanager.event;

import java.util.*;
import javax.persistence.*;
import hu.indicium.eventmanager.question.Question;

@Entity
public class Event {
    public Event() {}

    enum Status {
        DRAFT,
        PUBLISHED,
        PRIVATE
    }

    @Id
    @SequenceGenerator(name = "event_id_generator", sequenceName = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_generator")
    private Long id;
    private Date startDate;
    private Date endDate;
    private String slug;
    private Status status;
    private String title;

    @Column(length = 500)
    private String description;

    private ArrayList<String> location;
    private ArrayList<String> categories;

    @OneToMany()
    private List<Question> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        switch (status) {
            case "draft":
                this.status = Status.DRAFT;
            case "published":
                this.status = Status.PUBLISHED;
            case "private":
                this.status = Status.PRIVATE;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Question> getQuestion() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<String> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public ArrayList<String> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public void addCategory(String category) {
        if(!this.categories.contains(category)) {
            this.categories.add(category);
        }
    }

    @Override
    public String toString() {
        return "Event: "
            + " \nid= " +  id
            + " \nstartDate= " +  startDate
            + " \nendDate= " +  endDate
            + " \nslug= " +  slug
            + " \nstatus= " +  status
            + " \ntitle= " +  title
            + " \ndescription= " +  description
            + " \nlocation= " +  location
            + " \ncategories= " + categories;
            // + " \nquestions= " + questions;
    }
}
