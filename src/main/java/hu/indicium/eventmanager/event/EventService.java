package hu.indicium.eventmanager.event;

import java.util.Date;
import java.util.List;

public class EventService implements EventServiceInterface {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getComingEvents() {
        return eventRepository.findAllByEndDateAfter(new Date());
    }

    @Override
    public Event getEvent(Long eventId) {
        return eventRepository.findById(eventId)
                .orElse(null);
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event editEvent(Event event) {
        Event event1 = eventRepository.findById(event.getId()).orElseThrow(() -> new RuntimeException("rip"));
        event1.setDescription(event.getDescription());
        event1.setEndDate(event.getEndDate());
        event1.setStartDate(event.getStartDate());
        event1.setName(event.getName());
        return eventRepository.save(event1);
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }
}
