package nl.jhx.vapp.services;
import nl.jhx.vapp.dto.ProjectMemberDto;
import nl.jhx.vapp.model.ProjectMember;
import nl.jhx.vapp.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectMemberService {
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

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

    public static ProjectMemberDto fromProjectMember(ProjectMember projectMember){
        try {
            return new ProjectMemberDto(projectMember.getName(), projectMember.getEmail(), projectMember.getPassword(), projectMember.getRole());
        } catch (Exception e) {
            return null;
        }
    }

}
