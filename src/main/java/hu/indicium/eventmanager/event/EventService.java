package hu.indicium.eventmanager.event;

import java.util.*;

import org.springframework.stereotype.*;

import hu.indicium.eventmanager.event.request.EventRequest;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event addEvent(EventRequest eventRequest) {
        Event event = this.eventReqToEvent(eventRequest, null);
        return eventRepository.save(event);
    }

    public Event updateEventById(long eventId, EventRequest eventRequest) {
        Event event = findEventById(eventId);

        if (!event.equals(null)) {
            this.eventReqToEvent(eventRequest, event);
            return eventRepository.save(event);
        }

        return null;
    }

    public void deleteEventById(long eventId) {
        eventRepository.deleteById(eventId);
    }

    public Event findEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    private Event eventReqToEvent(EventRequest eventRequest, Event event) {
        if (event == null) {
            event = new Event();
        }

        event.setTitle(eventRequest.getTitle());
        event.setDescription(eventRequest.getDescription());
        event.setStartDate(eventRequest.getStartDate());
        event.setEndDate(eventRequest.getEndDate());
        event.setStatus(eventRequest.getStatus());
        event.setLocation(eventRequest.getLocation());
        event.setUrl(eventRequest.getUrl());
        event.setCategories(eventRequest.getCategories());
        event.setSlug(eventRequest.getSlug());

        return event;
    }
}
