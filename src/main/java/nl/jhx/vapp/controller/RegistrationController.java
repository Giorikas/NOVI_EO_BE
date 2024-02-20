package nl.jhx.vapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    // De "String" hier hoort een object te zijn, dit object zit ergens in het programma gedefineerd op zo'n manier dat hij van JSON naar data van dit object kan gaan. De vraag is hoe definieer je dit object.
    // Als dat lukt kun je even een klein simpel object maken met maar 1 member en kijken of de register of welke POST functie dan ook werkt. En als dat werkt kun je het uitbreiden naar wat je nodig hebt.
    @PostMapping()
    public ResponseEntity<String> register(@RequestBody String content)
    {
        return ResponseEntity.ok("wer");
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
