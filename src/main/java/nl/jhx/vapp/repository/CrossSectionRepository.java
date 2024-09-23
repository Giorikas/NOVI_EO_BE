package nl.jhx.vapp.repository;

import nl.jhx.vapp.model.CrossSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CrossSectionRepository extends JpaRepository<CrossSection, Long> {
    @Override
    Optional<CrossSection> findById(Long id);
}
