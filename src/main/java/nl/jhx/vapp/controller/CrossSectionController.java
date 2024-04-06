package nl.jhx.vapp.controller;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.repository.CrossSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.URIParameter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crossSections")
public class CrossSectionController {

    @Autowired
    private CrossSectionRepository crossSectionRepository;
    private ArrayList<CrossSection> crossSections = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<CrossSection>> getAllCrossSections(){
        return ResponseEntity.ok(crossSectionRepository.findAll());
        // return new ResponseEntity<>(this.crossSections, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CrossSection> createCrossSection(@RequestBody CrossSection crossSection){
        crossSectionRepository.save(crossSection);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + crossSection.getId()).toUriString()
        );
        return ResponseEntity.created(uri).body(crossSection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrossSection> updateCrossSection(@PathVariable int id, @RequestBody CrossSection crossSection){
        if (id >=0 && id < this.crossSections.size()) {
            this.crossSections.set(id, crossSection);
            return new ResponseEntity<>(crossSection, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}