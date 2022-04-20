package br.edu.ifrs.restinga.adriano.eventapp.repository;

import br.edu.ifrs.restinga.adriano.eventapp.models.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, String> {
    List<Guest> findByEventId(Long id);
}
