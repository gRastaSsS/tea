package edu.fluffytiger.tea.controllers;

import edu.fluffytiger.tea.payload.CreateEventRequest;
import edu.fluffytiger.tea.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {
    private final EventService service;

    public AdminController(EventService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String adminPage(CreateEventRequest data, Model model) {
        model.addAttribute("data", data);
        model.addAttribute("events", this.service.list());
        return "admin_page";
    }

    @RequestMapping(method = RequestMethod.POST, value = "events")
    public String createEvent(CreateEventRequest data) {
        this.service.create(data);
        return "redirect:/admin";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "events/{id}")
    public String deleteEvent(@PathVariable long id) {
        this.service.delete(id);
        return "redirect:/admin";
    }
}
