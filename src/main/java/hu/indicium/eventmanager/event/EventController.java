package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.event.requests.NewEventRequest;
import hu.indicium.eventmanager.event.requests.UpdateEventRequest;
import hu.indicium.eventmanager.responses.DeleteSuccessResponse;
import hu.indicium.eventmanager.responses.Response;
import hu.indicium.eventmanager.responses.SuccessResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public Response createEvent(@RequestBody @Valid NewEventRequest eventRequest) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(eventRequest.getName());
        eventDTO.setDescription(eventRequest.getDescription());
        eventDTO.setStartDate(eventRequest.getStartDate());
        eventDTO.setEndDate(eventRequest.getEndDate());
        eventDTO.setLocation(eventRequest.getLocation());
        EventDTO event = eventService.addEvent(eventDTO);
        return new SuccessResponse(event);
    }

    @GetMapping("/events")
    public Response getAllEvents() {
        List<EventDTO> events = eventService.getAllEvents();
        return new SuccessResponse(events);
    }

    @GetMapping("/events/coming")
    public Response getComingEvents() {
        List<EventDTO> events = eventService.getComingEvents();
        return new SuccessResponse(events);
    }

    @GetMapping("/events/{eventId}")
    public Response getEvent(@PathVariable Long eventId) {
        EventDTO event = eventService.getEvent(eventId);
        return new SuccessResponse(event);
    }

    @PutMapping("/events/{eventId}")
    public Response updateEvent(@PathVariable Long eventId, @RequestBody @Valid UpdateEventRequest eventRequest) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(eventId);
        eventDTO.setName(eventRequest.getName());
        eventDTO.setDescription(eventRequest.getDescription());
        eventDTO.setStartDate(eventRequest.getStartDate());
        eventDTO.setEndDate(eventRequest.getEndDate());
        eventDTO.setLocation(eventRequest.getLocation());
        EventDTO updatedEventDTO = eventService.editEvent(eventDTO);
        return new SuccessResponse(updatedEventDTO);
    }

    @DeleteMapping("/events/{eventId}")
    public Response deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return new DeleteSuccessResponse();
    }
}
