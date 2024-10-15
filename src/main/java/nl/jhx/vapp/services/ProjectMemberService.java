package nl.jhx.vapp.services;
import nl.jhx.vapp.dtos.ProjectMemberDto;
import nl.jhx.vapp.model.ProjectMember;
import nl.jhx.vapp.repository.ProjectMemberRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;

    public ProjectMemberService(ProjectMemberRepository projectMemberRepository) {
        this.projectMemberRepository = projectMemberRepository;
    }

    public ProjectMember createProjectMember(ProjectMemberDto projectMemberDto){
        ProjectMember projectMember = toProjectmember(projectMemberDto);
        return projectMemberRepository.saveAndFlush(projectMember);
    }

    public ProjectMember toProjectmember(ProjectMemberDto projectMemberDto){

        var projectMember = new ProjectMember();

        projectMember.setName(projectMemberDto.getName());
        projectMember.setEmail(projectMemberDto.getEmail());
        projectMember.setPassword(projectMemberDto.getPassword());
        projectMember.setRole(projectMemberDto.getRole().toString());

        return projectMember;
    }

}
