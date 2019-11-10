package hu.indicium.eventmanager.inschrijving.reqeust;

public class InschrijfRequest {
    private Long id;
    private Long eventId;
    private String name;
    private String lidNumber;
    private String commisson;

    public InschrijfRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLidNumber() {
        return lidNumber;
    }

    public void setLidNumber(String lidNumber) {
        this.lidNumber = lidNumber;
    }

    public String getCommisson() {
        return commisson;
    }

    public void setCommisson(String commisson) {
        this.commisson = commisson;
    }

    public Long getEventId() {
        return eventId;
    }

    public void seteventId(Long eventId) {
        this.eventId = eventId;
    }
}
