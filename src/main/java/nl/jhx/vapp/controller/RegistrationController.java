package nl.jhx.vapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    @PostMapping()
    public ResponseEntity<> register(@RequestBody String content)
    {
        return ResponseEntity.ok("VAPP POST is responding" + content);
    }
    // This works
    /*@PostMapping
    public ResponseEntity<String> postRegisterUser(String content){
        return ResponseEntity.ok("VAPP POST is responding" + content);
    }*/

    @GetMapping
    public ResponseEntity<String> getRegisterUser(String r)
    {
        return ResponseEntity.ok("VAPP is responding");
    }


}
