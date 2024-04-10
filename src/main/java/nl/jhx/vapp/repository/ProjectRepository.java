package nl.jhx.vapp.repository;
import nl.jhx.vapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findByName(String name);
}
