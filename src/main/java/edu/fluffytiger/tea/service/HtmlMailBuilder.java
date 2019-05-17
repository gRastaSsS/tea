package edu.fluffytiger.tea.service;

import edu.fluffytiger.tea.model.Event;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class HtmlMailBuilder {
    private final TemplateEngine engine;

    public HtmlMailBuilder(TemplateEngine engine) {
        this.engine = engine;
    }

    public String build(Event event) {
        Context context = new Context();
        context.setVariable("event", event);
        return engine.process("mailTemplate", context);
    }

    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return engine.process("mailTemplate", context);
    }
}
