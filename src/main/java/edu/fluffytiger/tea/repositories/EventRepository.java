package edu.fluffytiger.tea.repositories;

import edu.fluffytiger.tea.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
