package nl.jhx.vapp.repository;
import nl.jhx.vapp.model.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, String> {
    ProjectMember findByName(String name);
}
