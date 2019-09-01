package hu.indicium.eventmanager.event.requests;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class NewEventRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotEmpty
    private Date startDate;

    @NotEmpty
    private Date endDate;

    @NotEmpty
    private String location;

    public String getName() {
        return name;
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
