package nl.jhx.vapp.repository;

import nl.jhx.vapp.model.CrossSectionPart;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CrossSectionPartRepository extends JpaRepository<CrossSectionPart, String> { @Override
Optional<CrossSectionPart> findById(String id);
}
