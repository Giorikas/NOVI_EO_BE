package nl.jhx.vapp.controller;

import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.model.Project;
import nl.jhx.vapp.repository.ProjectRepository;
import nl.jhx.vapp.services.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        return ResponseEntity.ok(projectRepository.findAll());
    }
}
