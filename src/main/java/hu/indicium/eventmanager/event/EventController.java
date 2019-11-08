package hu.indicium.eventmanager.event;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import hu.indicium.eventmanager.event.response.*;
import hu.indicium.eventmanager.event.request.*;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

    @PostMapping("/events")
    public Response createEvent(@RequestBody EventRequest eventRequest) {
        Event event = new Event();
        event.setTitle(eventRequest.getTitle());

        return new Response(eventService.addEvent(event), null);
    }
}
