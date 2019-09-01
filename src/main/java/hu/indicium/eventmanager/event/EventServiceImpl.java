package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.util.Mapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    private final Mapper<Event, EventDTO> eventMapper;

    public EventServiceImpl(EventRepository eventRepository, Mapper<Event, EventDTO> eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventDTO> getComingEvents() {
        List<Event> events = eventRepository.findAllByEndDateAfter(new Date());
        return events.stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEvent(Long eventId) {
        Event event = findEventById(eventId);
        return eventMapper.toDTO(event);
    }

    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        event = eventRepository.save(event);
        return eventMapper.toDTO(event);
    }

    @Override
    public EventDTO editEvent(EventDTO eventDTO) {
        Event event = findEventById(eventDTO.getId());
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setStartDate(eventDTO.getStartDate());
        event.setEndDate(eventDTO.getEndDate());
        event.setLocation(eventDTO.getLocation());
        Event updatedEvent = eventRepository.save(event);
        return eventMapper.toDTO(updatedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    private Event findEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("Event with id " + eventId + " not found!"));
    }
}
