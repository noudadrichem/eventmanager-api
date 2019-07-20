package hu.indicium.eventmanager.event;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @SequenceGenerator(name = "event_id_generator", sequenceName = "event_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_generator")
    private Long id;
}
