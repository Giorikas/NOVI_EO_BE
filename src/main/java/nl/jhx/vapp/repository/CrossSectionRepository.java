package nl.jhx.vapp.repository;
import nl.jhx.vapp.model.CrossSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CrossSectionRepository extends JpaRepository<CrossSection, Long> {
    @Override
    Optional<CrossSection> findById(Long id);

}
