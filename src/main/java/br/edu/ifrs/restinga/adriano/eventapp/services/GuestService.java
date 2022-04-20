package br.edu.ifrs.restinga.adriano.eventapp.services;

import br.edu.ifrs.restinga.adriano.eventapp.models.Event;
import br.edu.ifrs.restinga.adriano.eventapp.models.Guest;
import br.edu.ifrs.restinga.adriano.eventapp.repository.EventRepository;
import br.edu.ifrs.restinga.adriano.eventapp.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private EventRepository eventRepository;

    public GuestService() {

    }

    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public List<Guest> getAllGuestsByEventId() {
        List<Event> eventList = (List<Event>) eventRepository.findAll();
        List<Guest> guestsByEventId = null;
        for(int i = 0; i < eventList.size(); i++){
            Event event = eventList.get(i);
            long eventId = event.getId();
            guestsByEventId = guestRepository.findByEventId(eventId);
            return guestsByEventId;
        }
        return guestsByEventId;
    }

    public List<Guest> getAllGuestsWithoutEvent() {
        List<Guest> guestsWithoutEvent = guestRepository.findByEventId(null);
        return guestsWithoutEvent;
    }
}
