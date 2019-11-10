package hu.indicium.eventmanager.inschrijving;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InschrijvingRepository extends JpaRepository<Inschrijving, Long> {
    List<Inschrijving> findAll();
    List<Inschrijving> findAllByEventId(Long id);
}
