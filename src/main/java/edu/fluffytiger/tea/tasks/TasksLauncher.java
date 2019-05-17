package edu.fluffytiger.tea.tasks;

import edu.fluffytiger.tea.repositories.EventRepository;
import edu.fluffytiger.tea.service.EmailService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class TasksLauncher implements ApplicationRunner {
    private final ThreadPoolTaskScheduler scheduler;
    private final EmailService emailService;
    private final EventRepository events;

    public TasksLauncher(ThreadPoolTaskScheduler scheduler, EmailService emailService, EventRepository events) {
        this.scheduler = scheduler;
        this.emailService = emailService;
        this.events = events;
    }

    @Override
    public void run(ApplicationArguments args) {
        this.scheduler.schedule(
                new SendNotifications(emailService, events),
                new CronTrigger("0 0 5 * * ?")
        );
    }
}
