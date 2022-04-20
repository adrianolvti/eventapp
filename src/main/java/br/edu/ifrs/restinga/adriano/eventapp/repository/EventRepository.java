package br.edu.ifrs.restinga.adriano.eventapp.repository;

import br.edu.ifrs.restinga.adriano.eventapp.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {

}
