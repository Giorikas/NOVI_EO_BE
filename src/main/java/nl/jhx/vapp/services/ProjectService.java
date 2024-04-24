package nl.jhx.vapp.services;

import nl.jhx.vapp.dto.ProjectDto;
import nl.jhx.vapp.exception.ProjectNotFoundException;
import nl.jhx.vapp.model.Project;
import nl.jhx.vapp.repository.ProjectRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

  public ProjectService(ProjectRepository projectRepository)
  {
      this.projectRepository = projectRepository;
  }

    public ProjectDto getProjectById(Long id) {
        System.out.println("getProjectById");
      Optional<Project> project = projectRepository.findById(id);
      if (project.isPresent()) {
          return toProjectDto(project.get());
      } else {
          throw new ProjectNotFoundException("The requested project coudn't be found.");
      }
    }

    public ProjectDto createProject(ProjectDto projectDto)
    {
        System.out.println("ProjectService.createProject" + projectDto);
        Project project = toProject(projectDto);
        projectRepository.save(project);
        return toProjectDto(project);
    }

    public Project toProject(ProjectDto projectDto)
    {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStatus(projectDto.getStatus());
        return project;
    }

    public ProjectDto toProjectDto(Project project)
    {
      try {
          return new ProjectDto(project.getId(), project.getName(), project.getStatus());
      } catch (Exception e){
          return null;
      }
    }

}
