package hu.indicium.eventmanager.event;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import hu.indicium.eventmanager.response.*;
import hu.indicium.eventmanager.event.request.*;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getAllEvents();
        return events;
    }

    @PostMapping("/events")
    public Response createEvent(@RequestBody EventRequest eventRequest) {
        Event event = eventService.addEvent(eventRequest);
        return new Response(event, null);
    }

    @PutMapping("/events/{id}")
    public Response updateEvent(@RequestBody EventRequest eventRequest, @PathVariable long id) {
        Event updatedEvent = eventService.updateEventById(id, eventRequest);
        return new Response(updatedEvent, null);
    }

    @DeleteMapping("/events/{id}")
    public Response deleteEvent(@PathVariable long id) {
        eventService.deleteEventById(id);
        return new Response(true, null);
    }
}
