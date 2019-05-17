package edu.fluffytiger.tea.tasks;

import edu.fluffytiger.tea.model.Event;
import edu.fluffytiger.tea.repositories.EventRepository;
import edu.fluffytiger.tea.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Collection;

public class SendNotifications implements Runnable {
    private final EmailService emailService;
    private final EventRepository events;
    private final Logger logger;

    public SendNotifications(EmailService emailService, EventRepository events) {
        this.emailService = emailService;
        this.events = events;
        this.logger = LoggerFactory.getLogger(SendNotifications.class);
    }

    @Override
    public void run() {
        Collection<Event> events = this.events.findAllH2Native(LocalDate.now());

        for (Event event : events) {
            this.emailService.sendEvent(event);
        }

        logger.info("Emails sent");
    }
}
