package hu.indicium.eventmanager.event;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventServiceInterface {
    List<Event> getAllEvents();

    List<Event> getComingEvents();

    Event getEvent(Long eventId);

    Event addEvent(Event event);

    Event editEvent(Event event);

    void deleteEvent(Event event);
}
