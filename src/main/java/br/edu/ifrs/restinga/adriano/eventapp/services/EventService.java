package br.edu.ifrs.restinga.adriano.eventapp.services;

import br.edu.ifrs.restinga.adriano.eventapp.models.Event;
import br.edu.ifrs.restinga.adriano.eventapp.models.Guest;
import br.edu.ifrs.restinga.adriano.eventapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private GuestService guestService;

    public EventService() {

    }

    public void save(Event event){
        eventRepository.save(event);
        List<Event> events = (List<Event>) eventRepository.findAll();
        Event lastEvent = events.get(events.size()-1);

        List<Guest> guestsWithoutEvent = guestService.getAllGuestsWithoutEvent();
        for(int i = 0; i < guestsWithoutEvent.size(); i++){
            Guest guest = guestsWithoutEvent.get(i);
            System.out.println(guest.getGuestName());
            guest.setEvent(lastEvent);
            guestService.save(guest);
        }
    }

    public List<Event> getAllEvents() {
        List<Event> eventList = (List<Event>) eventRepository.findAll();
        return eventList;
    }
}
