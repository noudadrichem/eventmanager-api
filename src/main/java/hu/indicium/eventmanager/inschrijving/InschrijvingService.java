package hu.indicium.eventmanager.inschrijving;

import java.util.List;

import org.springframework.stereotype.*;

import hu.indicium.eventmanager.event.Event;
import hu.indicium.eventmanager.event.EventService;
import hu.indicium.eventmanager.inschrijving.reqeust.InschrijfRequest;

@Service
public class InschrijvingService {

    private final InschrijvingRepository inschrijvingRepository;
    private final EventService eventService;

    public InschrijvingService(InschrijvingRepository inschrijvingRepository, EventService eventService) {
        this.inschrijvingRepository = inschrijvingRepository;
        this.eventService = eventService;
    }

    public List<Inschrijving> getAllInschrijvingen() {
        return inschrijvingRepository.findAll();
    }

    public List<Inschrijving> getInschrijvingenByEventId(Long eventId) {
        return inschrijvingRepository.findAllByEventId(eventId);
    }

    public Inschrijving addInschrijving(InschrijfRequest inschrijfRequest) {
        Inschrijving inschrijving = new Inschrijving();

        inschrijving.setName(inschrijfRequest.getName());
        inschrijving.setCommisson(inschrijfRequest.getCommisson());
        inschrijving.setLidNumber(inschrijfRequest.getLidNumber());

        Event event = eventService.findEventById(inschrijfRequest.getEventId());
        inschrijving.setEvent(event);

        return this.inschrijvingRepository.save(inschrijving);
    }

}
