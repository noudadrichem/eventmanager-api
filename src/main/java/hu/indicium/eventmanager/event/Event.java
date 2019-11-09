package hu.indicium.eventmanager.event;

import java.util.*;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @SequenceGenerator(name = "event_id_generator", sequenceName = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_generator")
    private Long id;
    private Date startDate;
    private Date endDate;
    private String slug;
    private String status;
    private String title;
    private String description;
    private ArrayList<String> location;
    private String url;
    private ArrayList<String> categories;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
            + " id " +  id
            + " startDate " +  startDate
            + " endDate " +  endDate
            + " slug " +  slug
            + " status " +  status
            + " title " +  title
            + " description " +  description
            + " location " +  location
            + " url " +  url
            + " categories " + categories;
    }
}
