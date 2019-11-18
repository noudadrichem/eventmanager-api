package hu.indicium.eventmanager.registry;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import hu.indicium.eventmanager.registry.reqeust.*;
import hu.indicium.eventmanager.response.Response;

@RestController
public class RegistryController {

    private final RegistryService registryService;

    public RegistryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @GetMapping("/register")
    public Response getRegistrys() {
        List<Registry> Registryen = registryService.getAllRegisters();
        System.out.print(Registryen);

        return new Response(Registryen, null);
    }

    @GetMapping("/register/{eventId}")
    public Response getRegistryenByEventId(@PathVariable Long eventId) {
        List<Registry> Registryen = registryService.getRegisersByEventId(eventId);

        return new Response(Registryen, null);
    }

    @PostMapping("/register")
    public Response addRegistry(@RequestBody RegistryRequest inschrijfRequest) {

        Registry Registry = registryService.addRegistry(inschrijfRequest);

        return new Response(Registry, null);

    }
}
