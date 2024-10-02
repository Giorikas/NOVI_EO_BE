package nl.jhx.vapp.controller;
import nl.jhx.vapp.dto.CrossSectionDto;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.repository.CrossSectionRepository;
import nl.jhx.vapp.services.CrossSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.URIParameter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("projects/{idProject}/crossSections") // /{id}/crosssections
public class CrossSectionController {

    private final CrossSectionRepository crossSectionRepository;
    private final CrossSectionService crossSectionService;

    public CrossSectionController(CrossSectionRepository crossSectionRepository, CrossSectionService crossSectionService) {
        this.crossSectionRepository = crossSectionRepository;
        this.crossSectionService = crossSectionService;
    }

    @GetMapping("/{idCrossSection}")
    public ResponseEntity<List<CrossSection>> getCrossSections(Long idCrossSection){
        return ResponseEntity.ok(crossSectionRepository.findAll());
    }




    @PostMapping
    public ResponseEntity<Object> createCrossSection(@RequestBody CrossSectionDto dto){
        System.out.println("CrossSection Controller: " + dto.toString());
        CrossSectionDto crossSectionDto = crossSectionService.createCrossSection(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(crossSectionDto);
    }


/*    @PostMapping
    public void saveCrossSection(@RequestBody CrossSection crossSection){
        crossSectionRepository.save(crossSection);

    }*/

//    @PostMapping
//    public ResponseEntity<CrossSection> createCrossSection(@RequestBody CrossSection crossSection){
//        crossSectionRepository.save(crossSection);
//        URI uri = URI.create(
//                ServletUriComponentsBuilder
//                        .fromCurrentRequest()
//                        .path("/" + crossSection.getId()).toUriString()
//        );
//        return ResponseEntity.created(uri).body(crossSection);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CrossSection> updateCrossSection(@PathVariable int id, @RequestBody CrossSection crossSection){
//        if (id >=0 && id < this.crossSections.size()) {
//            this.crossSections.set(id, crossSection);
//            return new ResponseEntity<>(crossSection, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }
//    }
}