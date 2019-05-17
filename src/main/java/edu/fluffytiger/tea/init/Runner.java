package edu.fluffytiger.tea.init;

import edu.fluffytiger.tea.service.EmailService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {
    private final EmailService email;

    public Runner(EmailService email) {
        this.email = email;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
