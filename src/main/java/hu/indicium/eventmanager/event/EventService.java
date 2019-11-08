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

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEventById(long eventId, EventRequest eventRequest) {
        Event event = findEventById(eventId);

        if (!event.equals(null)) {
            // if(!eventRequest.getTitle().equals(null)) {
                event.setTitle(eventRequest.getTitle());
            // }
            // if(!eventRequest.getDescription().equals(null)) {
                event.setDescription(eventRequest.getDescription());
            // }
            // if(eventRequest.getStartDate() != null ) {
                event.setStartDate(eventRequest.getStartDate());
            // }
            // if(eventRequest.getEndDate() != null) {
                event.setEndDate(eventRequest.getEndDate());
            // }
            // if(!eventRequest.getStatus().equals(null)) {
                event.setStatus(eventRequest.getStatus());
            // }
            // if(!eventRequest.getLocation().equals(null)) {
                event.setLocation(eventRequest.getLocation());
            // }
            // if(!eventRequest.getUrl().equals(null)) {
                event.setUrl(eventRequest.getUrl());
            // }
            // if(!eventRequest.getCategories().equals(null)) {
                event.setCategories(eventRequest.getCategories());
            // }
        }

        System.out.println(event);

        return eventRepository.save(event);
    }

    public void deleteEventById(long eventId) {
        eventRepository.deleteById(eventId);
    }

    private Event findEventById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }
}
