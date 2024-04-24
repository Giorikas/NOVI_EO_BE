package nl.jhx.vapp.repository;
import nl.jhx.vapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    Optional<Project> findById(Long id);
}
