package nl.jhx.vapp.controller;
import nl.jhx.vapp.dto.ProjectMemberDto;
import nl.jhx.vapp.services.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@CrossOrigin
@RestController
@RequestMapping("/register")
public class ProjectMemberController {
    private final ProjectMemberService projectMemberService;

    public ProjectMemberController(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @PostMapping(value = "")
    public ResponseEntity<String> register(@RequestBody String myData)
    {
        System.out.print(myData);

        try
        {
            JSONObject jsonObject = new JSONObject(myData);

            ProjectMemberDto projectMemberDto = new ProjectMemberDto(
                    String.format("%s %s",
                            jsonObject.getString("firstname"),
                            jsonObject.getString("lastname")),
                    jsonObject.getString("email"),
                    jsonObject.getString("password"),
                    jsonObject.getString("role"));

            System.out.println("JSON Object: "+ projectMemberDto);

            projectMemberService.createProjectMember(projectMemberDto);
        }
        catch (Exception e)
        {
            System.out.println("Error "+e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("User Added");
    }

    @GetMapping
    public ResponseEntity<String> getRegisterUser(String r)
    {
        return ResponseEntity.ok("VAPP is responding");
    }

}
