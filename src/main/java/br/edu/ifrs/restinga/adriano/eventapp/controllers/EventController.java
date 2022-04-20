package br.edu.ifrs.restinga.adriano.eventapp.controllers;

import br.edu.ifrs.restinga.adriano.eventapp.models.Event;
import br.edu.ifrs.restinga.adriano.eventapp.models.Guest;
import br.edu.ifrs.restinga.adriano.eventapp.services.EventService;
import br.edu.ifrs.restinga.adriano.eventapp.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/event", method = RequestMethod.GET)
    public ModelAndView readEvent() {
        ModelAndView modelAndView = new ModelAndView("index");

        Iterable<Event> events = eventService.getAllEvents();
        modelAndView.addObject("getAllEvents", events);

        Iterable<Guest> guests = guestService.getAllGuestsByEventId();
        modelAndView.addObject("getAllGuestsByEventId", guests);

        return modelAndView;
    }

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public String createEvent(Event event) {
        eventService.save(event);
        return "redirect:/event";
    }

}
