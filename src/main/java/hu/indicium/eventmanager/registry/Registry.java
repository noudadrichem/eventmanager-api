package hu.indicium.eventmanager.registry;

import javax.persistence.*;
import hu.indicium.eventmanager.event.Event;

@Entity
public class Registry {

    @Id
    @SequenceGenerator(name = "registry_id_generator", sequenceName = "registry_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registry_id_generator")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL) // TODO: cascade doesnt work
    private Event event;

    private String name;
    private String lidNumber;
    private String commisson;

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

    public Event getEvent() {
        return this.event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
