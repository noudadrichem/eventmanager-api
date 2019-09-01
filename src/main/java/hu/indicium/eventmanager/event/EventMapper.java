package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.util.Mapper;
import org.springframework.stereotype.Component;

@Component
public class EventMapper implements Mapper<Event, EventDTO> {

    @Override
    public Event toEntity(EventDTO dto) {
        Event event = new Event();
        event.setId(dto.getId());
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setStartDate(dto.getStartDate());
        event.setEndDate(dto.getEndDate());
        event.setLocation(dto.getLocation());
        return event;
    }

    @Override
    public EventDTO toDTO(Event entity) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(entity.getId());
        eventDTO.setName(entity.getName());
        eventDTO.setDescription(entity.getDescription());
        eventDTO.setStartDate(entity.getStartDate());
        eventDTO.setEndDate(entity.getEndDate());
        eventDTO.setLocation(entity.getLocation());
        return eventDTO;
    }
}
