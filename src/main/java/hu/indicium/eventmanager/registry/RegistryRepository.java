package hu.indicium.eventmanager.registry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Long> {
    List<Registry> findAll();
    List<Registry> findAllByEventId(Long id);
}
