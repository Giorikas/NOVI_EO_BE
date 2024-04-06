package nl.jhx.vapp.controller;

import nl.jhx.vapp.dto.RegistrationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;
import org.json.JSONException;


@RestController
@RequestMapping("/register")
public class RegistrationController {


    @PostMapping
    public ResponseEntity<String> register(@RequestBody String myData)
    {
        System.out.print(myData);

        try
        {
            JSONObject jsonObject = new JSONObject(myData);

            RegistrationDto registrationDto = new RegistrationDto(
                    jsonObject.getString("name"),
                    jsonObject.getString("email"),
                    jsonObject.getString("password"),
                    jsonObject.getString("role"));

            System.out.println("JSON Object: "+ registrationDto);
        }
        catch (Exception e)
        {
            System.out.println("Error "+e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok("Test Complete");
    }


    // Dit werkt als de gezonden data puur een string is
    /*@PostMapping
    public ResponseEntity<String> register(@RequestBody String mydata) {
        System.out.println("The string: " + mydata + " was received by VAPP");
        return ResponseEntity.ok("test");
    }*/


    // De "String" hier hoort een object te zijn, dit object zit ergens in het programma gedefineerd op zo'n manier dat hij van JSON naar data van dit object kan gaan. De vraag is hoe definieer je dit object.
    // Als dat lukt kun je even een klein simpel object maken met maar 1 member en kijken of de register of welke POST functie dan ook werkt. En als dat werkt kun je het uitbreiden naar wat je nodig hebt.
    /*@PostMapping()
    public ResponseEntity<String> register(@RequestBody String content)
    {
        return ResponseEntity.ok("wer");
    }
    */

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
