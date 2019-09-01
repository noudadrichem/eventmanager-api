package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;

import java.util.List;

public interface EventService {
    List<EventDTO> getAllEvents();

    List<EventDTO> getComingEvents();

    EventDTO getEvent(Long eventId);

    EventDTO addEvent(EventDTO event);

    EventDTO editEvent(EventDTO event);

    void deleteEvent(Long eventId);
}
