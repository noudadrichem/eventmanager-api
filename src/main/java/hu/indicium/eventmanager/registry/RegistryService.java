package hu.indicium.eventmanager.registry;

import java.util.List;

import org.springframework.stereotype.*;

import hu.indicium.eventmanager.event.Event;
import hu.indicium.eventmanager.event.EventService;
import hu.indicium.eventmanager.registry.reqeust.*;

@Service
public class RegistryService {

    private final RegistryRepository registryRepository;
    private final EventService eventService;

    public RegistryService(RegistryRepository registryRepository, EventService eventService) {
        this.registryRepository = registryRepository;
        this.eventService = eventService;
    }

    public List<Registry> getAllRegisters() {
        return registryRepository.findAll();
    }

    public List<Registry> getRegisersByEventId(Long eventId) {
        return registryRepository.findAllByEventId(eventId);
    }

    public Registry addRegistry(RegistryRequest inschrijfRequest) {
        Registry Registry = new Registry();

        Registry.setName(inschrijfRequest.getName());
        Registry.setCommisson(inschrijfRequest.getCommisson());
        Registry.setLidNumber(inschrijfRequest.getLidNumber());

        Event event = eventService.findEventById(inschrijfRequest.getEventId());
        Registry.setEvent(event);

        return this.registryRepository.save(Registry);
    }

}
