package hu.indicium.eventmanager.inschrijving;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import hu.indicium.eventmanager.inschrijving.reqeust.InschrijfRequest;
import hu.indicium.eventmanager.response.Response;

@RestController
public class InschrijvingController {

    private final InschrijvingService inschrijvingService;

    public InschrijvingController(InschrijvingService inschrijvingService) {
        this.inschrijvingService = inschrijvingService;
    }

    @GetMapping("/inschrijvingen")
    public Response getInschrijvings() {
        List<Inschrijving> inschrijvingen = inschrijvingService.getAllInschrijvingen();
        System.out.print(inschrijvingen);

        return new Response(inschrijvingen, null);
    }

    @GetMapping("/inschrijvingen/{eventId}")
    public Response getInschrijvingenByEventId(@PathVariable Long eventId) {
        List<Inschrijving> inschrijvingen = inschrijvingService.getInschrijvingenByEventId(eventId);

        return new Response(inschrijvingen, null);
    }

    @PostMapping("/inschrijvingen")
    public Response addInschrijving(@RequestBody InschrijfRequest inschrijfRequest) {

        Inschrijving inschrijving = inschrijvingService.addInschrijving(inschrijfRequest);

        return new Response(inschrijving, null);

    }
}
