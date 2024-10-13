package nl.jhx.vapp.controller;

import nl.jhx.vapp.dto.CrossSectionPartDto;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.model.CrossSectionPart;
import nl.jhx.vapp.repository.CrossSectionPartRepository;
import nl.jhx.vapp.repository.CrossSectionRepository;
import nl.jhx.vapp.services.CrossSectionPartService;
import nl.jhx.vapp.services.CrossSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
//@RequestMapping("/crossSections/{idCrossSection}/crossSectionParts")
@RequestMapping("projects/{idProject}")
public class CrossSectionPartsController {

    private final CrossSectionPartRepository crossSectionPartRepository;
    private final CrossSectionPartService crossSectionPartService;

    public CrossSectionPartsController(CrossSectionPartRepository crossSectionPartRepository, CrossSectionPartService crossSectionPartService) {
        this.crossSectionPartRepository = crossSectionPartRepository;
        this.crossSectionPartService = crossSectionPartService;
    }

    @GetMapping("/{idCrossSectionParts}")
    public ResponseEntity<List<CrossSectionPart>> getCrossSectionParts(@PathVariable("idProject") String idProject) {
        System.out.println("Till Here: GetRequest CrossSectionParts");
        return ResponseEntity.ok(crossSectionPartRepository.findAll());
    }

    @PostMapping("/crossSectionParts")
    public ResponseEntity<Object> createCrossSectionPart(@RequestBody CrossSectionPartDto dto) {
        System.out.println("CrossSectionPartsCtrl: " + dto.toString());
        CrossSectionPartDto crossSectionPartDto;
        crossSectionPartDto = crossSectionPartService.createCrossSectionPart(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(crossSectionPartDto);
    }

    @PostMapping("/crossSectionPartsArray")
    public ResponseEntity<Object> createCrossSectionPart(@RequestBody List<CrossSectionPartDto> crossSectionPartDtos) {
        System.out.println("CrossSectionPartsCtrl: " + crossSectionPartDtos.toString());
        List<CrossSectionPartDto> cspDtos = crossSectionPartService.arrayToObjects(crossSectionPartDtos);
        // Service loop --> Array --> Objecten
        return ResponseEntity.ok().body(cspDtos);
    }
}