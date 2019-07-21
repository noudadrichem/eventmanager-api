package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.event.dto.NewEventDTO;
import hu.indicium.eventmanager.event.dto.UpdateEventDTO;
import hu.indicium.eventmanager.responses.DeleteSuccessResponse;
import hu.indicium.eventmanager.responses.Response;
import hu.indicium.eventmanager.responses.SuccessResponse;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private final EventServiceInterface eventService;

    private final ModelMapper modelMapper;

    public EventController(EventServiceInterface eventService, ModelMapper modelMapper) {
        this.eventService = eventService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/events")
    public Response createEvent(@RequestBody NewEventDTO eventDTO) {
        Event event = toEvent(eventDTO);
        event = eventService.addEvent(event);
        return new SuccessResponse(toEventDTO(event));
    }

    @GetMapping("/events/coming")
    public Response getComingEvents() {
        List<Event> events = eventService.getComingEvents();
        List<EventDTO> eventDTOS = events.stream()
                .map(this::toEventDTO)
                .collect(Collectors.toList());
        return new SuccessResponse(eventDTOS);
    }

    @GetMapping("/events")
    public Response getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventDTO> eventDTOS = events.stream()
                .map(this::toEventDTO)
                .collect(Collectors.toList());
        return new SuccessResponse(eventDTOS);
    }

    @GetMapping("/events/{eventId}")
    public Response getEvent(@PathVariable Long eventId) {
        Event event = eventService.getEvent(eventId);
        return new SuccessResponse(toEventDTO(event));
    }

    @PutMapping("/events/{eventId}")
    public Response updateEvent(@PathVariable Long eventId, @RequestBody UpdateEventDTO eventDTO) {
        Event event = toEvent(eventDTO);
        event.setId(eventId);
        event = eventService.editEvent(event);
        return new SuccessResponse(toEventDTO(event));
    }

    @DeleteMapping("/events/{eventId}")
    public Response deleteEvent(@PathVariable Long eventId) {
        Event event = eventService.getEvent(eventId);
        eventService.deleteEvent(event);
        return new DeleteSuccessResponse();
    }

    private Event toEvent(NewEventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }

    private Event toEvent(UpdateEventDTO eventDTO) {
        return modelMapper.map(eventDTO, Event.class);
    }

    private EventDTO toEventDTO(Event event) {
        return modelMapper.map(event, EventDTO.class);
    }
}
