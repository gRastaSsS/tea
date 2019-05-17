package edu.fluffytiger.tea.init;

import edu.fluffytiger.tea.payload.CreateEventRequest;
import edu.fluffytiger.tea.repositories.EventRepository;
import edu.fluffytiger.tea.service.EmailService;
import edu.fluffytiger.tea.service.EventService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
public class Runner implements ApplicationRunner {
    private final EmailService email;
    private final EventService events;
    private final EventRepository repository;

    public Runner(EmailService email, EventService events, EventRepository repository) {
        this.email = email;
        this.events = events;
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        events.create(new CreateEventRequest(
                "name0",
                "desc", "place",
                LocalDate.MAX, false,
                Arrays.asList(LocalDate.MAX, LocalDate.MIN)
        ));

        events.create(new CreateEventRequest(
                "name1",
                "desc", "place",
                LocalDate.now(), false,
                Arrays.asList(LocalDate.now(), LocalDate.MIN)
        ));

        events.create(new CreateEventRequest(
                "name2",
                "desc", "place",
                LocalDate.MAX, false,
                Arrays.asList(LocalDate.MAX, LocalDate.MIN)
        ));

        System.out.println(repository.findAllPostgresNative(LocalDate.now()));
    }
}
