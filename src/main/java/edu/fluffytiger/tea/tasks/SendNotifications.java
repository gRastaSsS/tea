package edu.fluffytiger.tea.tasks;

import edu.fluffytiger.tea.model.Event;
import edu.fluffytiger.tea.repositories.EventRepository;
import edu.fluffytiger.tea.service.EmailService;

import java.time.LocalDate;
import java.util.Collection;

public class SendNotifications implements Runnable {
    private final EmailService emailService;
    private final EventRepository events;

    public SendNotifications(EmailService emailService, EventRepository events) {
        this.emailService = emailService;
        this.events = events;
    }

    @Override
    public void run() {
        Collection<Event> events = this.events.findAllPostgresNative(LocalDate.now());

        for (Event event : events) {
            this.emailService.sendEvent(event);
        }
    }
}
