package edu.fluffytiger.tea.restcontrollers;

import edu.fluffytiger.tea.model.Event;
import edu.fluffytiger.tea.payload.CreateEventRequest;
import edu.fluffytiger.tea.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Event create(@RequestBody CreateEventRequest request) {
        return this.service.create(request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Event> list() {
        return this.service.list();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Event get(@PathVariable long id) {
        return this.service.get(id);
    }
}
