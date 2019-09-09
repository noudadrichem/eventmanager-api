package hu.indicium.eventmanager.event;

import hu.indicium.eventmanager.event.dto.EventDTO;
import hu.indicium.eventmanager.util.Mapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EventServiceImpl.class)
@DisplayName("Event Service")
@Tag("Services")
class EventServiceTest {

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private Mapper<Event, EventDTO> eventMapper;

    @Autowired
    private EventService eventService;

    @Test
    @DisplayName("Create event")
    void createEvent() {
        Event event = new Event("Gastcollege", "HL15-4.092", "Gastcollege", new Date(), new Date());
        EventDTO eventDTO = new EventDTO();
        eventDTO.setName(event.getName());
        eventDTO.setDescription(event.getDescription());
        eventDTO.setStartDate(event.getStartDate());
        eventDTO.setEndDate(event.getEndDate());
        eventDTO.setLocation(event.getLocation());

        when(eventMapper.toEntity(any(EventDTO.class))).thenReturn(event);
        when(eventMapper.toDTO(any(Event.class))).thenReturn(eventDTO);
        when(eventRepository.save(any(Event.class))).thenReturn(event);

        EventDTO returnedEventDTO = eventService.addEvent(eventDTO);

        verify(eventRepository).save(eq(event));

        assertThat(returnedEventDTO.getName()).isEqualTo(eventDTO.getName());
        assertThat(returnedEventDTO.getDescription()).isEqualTo(eventDTO.getDescription());
        assertThat(returnedEventDTO.getLocation()).isEqualTo(eventDTO.getLocation());
        assertThat(returnedEventDTO.getStartDate()).isEqualTo(eventDTO.getStartDate());
        assertThat(returnedEventDTO.getEndDate()).isEqualTo(eventDTO.getEndDate());
    }

    @TestConfiguration
    static class EventServiceTestContextConfiguration {

        @Autowired
        private EventRepository eventRepository;

        @Autowired
        private Mapper<Event, EventDTO> eventDTOMapper;

        @Bean
        public EventService eventService() {
            return new EventServiceImpl(eventRepository, eventDTOMapper);
        }
    }
}