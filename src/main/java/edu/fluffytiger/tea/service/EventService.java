package edu.fluffytiger.tea.service;

import edu.fluffytiger.tea.model.Event;
import edu.fluffytiger.tea.payload.CreateEventRequest;
import edu.fluffytiger.tea.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    private final EventRepository events;

    public EventService(EventRepository events) {
        this.events = events;
    }

    public Iterable<Event> list() {
        return this.events.findAll();
    }

    public Event get(long id) {
        Optional<Event> o = this.events.findById(id);
        return o.orElse(null);
    }

    public Event create(CreateEventRequest request) {
        Event event = new Event();
        System.out.println(request);
        event.setName(request.getName());
        event.setDescription(request.getDescription());
        event.setPlace(request.getPlace());
        this.events.save(event);
        return event;
    }

    public void delete(long id) {
        this.events.deleteById(id);
    }

    public void bindEmail(long id, String email) {
    }
}
