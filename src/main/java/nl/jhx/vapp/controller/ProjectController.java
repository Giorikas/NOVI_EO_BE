package nl.jhx.vapp.controller;

import nl.jhx.vapp.dto.ProjectDto;
import nl.jhx.vapp.model.Project;
import nl.jhx.vapp.repository.ProjectRepository;
import nl.jhx.vapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;

    public ProjectController(ProjectRepository projectRepository,
                             ProjectService projectService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        return ResponseEntity.ok(projectRepository.findAll());
    }

    @GetMapping("/{idProject}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable Long idProject){
        System.out.println("got request to find project with id " + idProject);
        ProjectDto projectDto = projectService.getProjectById(idProject);
        return ResponseEntity.ok().body(projectDto);
    }

    @PostMapping(value="")
    public ResponseEntity<Object> createProject(@RequestBody ProjectDto dto){
        System.out.println("Controller here!  -  " + dto);
        ProjectDto projectDto = projectService.createProject(dto);
        return ResponseEntity.created(null).body(projectDto);
    }


}


