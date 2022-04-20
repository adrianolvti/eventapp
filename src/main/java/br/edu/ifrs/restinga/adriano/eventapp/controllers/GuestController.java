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
public class GuestController {

    @Autowired
    private GuestService guestService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView readGuest() {
        ModelAndView modelAndView = new ModelAndView("index");

        Iterable<Guest> guestsWithoutEvent = guestService.getAllGuestsWithoutEvent();
        modelAndView.addObject("guestsWithoutEvent", guestsWithoutEvent);

        return modelAndView;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createGuest(Guest guest) {
        guestService.save(guest);
        return "redirect:/";
    }

}
