package hu.indicium.eventmanager.event.request;

import java.util.*;

public class EventRequest {
    private Date startDate;
    private Date endDate;
    private String slug;
    private String status;
    private String title;
    private String description;
    private ArrayList<String> location;
    private ArrayList<String> categories;
    private ArrayList<Long> questions;

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

    public String getStatus() {
        return status;
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

    public ArrayList<Long> getQuestions() {
        return this.questions;
    }

    public void setQuestions(ArrayList<Long> questions) {
        this.questions = questions;
    }
}
