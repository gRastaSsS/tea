package edu.fluffytiger.tea.repositories;

import edu.fluffytiger.tea.model.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;

public interface EventRepository extends CrudRepository<Event, Long> {
    @Query(value = "SELECT DISTINCT * FROM events_table INNER JOIN (SELECT * FROM NOTIFY_DATES_TABLE WHERE notify_at = SELECT to_date(?1,'YYYY-MM-DD')) ON id = event_id",
            nativeQuery = true)
    Collection<Event> findAllPostgresNative(LocalDate date);


}
