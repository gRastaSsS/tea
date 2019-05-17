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
import java.util.HashSet;

@Component
public class Runner implements ApplicationRunner {
    private final EventService events;

    public Runner(EventService events) {
        this.events = events;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        events.create(new CreateEventRequest(
                "name0",
                "desc", "place",
                LocalDate.parse("2019-05-30"), false,
                new HashSet<>(Arrays.asList("dead.gerasim@gmail.com", "st054633@student.spbu.ru")),
                Arrays.asList(LocalDate.parse("2019-05-25"), LocalDate.parse("2019-05-24"))
        ));

        events.create(new CreateEventRequest(
                "name1",
                "desc", "place",
                LocalDate.now(), false,
                new HashSet<>(Arrays.asList("dead.gerasim@gmail.com", "st054633@student.spbu.ru")),
                Arrays.asList(LocalDate.now(), LocalDate.parse("2019-06-24"))
        ));

        events.create(new CreateEventRequest(
                "name2",
                "desc", "place",
                LocalDate.now(), false,
                new HashSet<>(Arrays.asList("dead.gerasim@gmail.com")),
                Arrays.asList(LocalDate.now(), LocalDate.parse("2019-06-24"))
        ));
    }
}
