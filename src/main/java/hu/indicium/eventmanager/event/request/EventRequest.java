package hu.indicium.eventmanager.event.request;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class EventRequest {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    @NotEmpty
    private Date startDate;

    @NotEmpty
    private Date endDate;

    @NotEmpty
    private String location;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }
}
