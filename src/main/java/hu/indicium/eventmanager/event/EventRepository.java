package hu.indicium.eventmanager.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
}
