package nl.jhx.vapp.controller;
import nl.jhx.vapp.dto.CrossSectionPartDto;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.model.CrossSectionPart;
import nl.jhx.vapp.repository.CrossSectionPartRepository;
import nl.jhx.vapp.repository.CrossSectionRepository;
import nl.jhx.vapp.services.CrossSectionPartService;
import nl.jhx.vapp.services.CrossSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/crossSections/{idCrossSection}/crossSectionParts")
public class CrossSectionPartsController {

    private final CrossSectionPartRepository crossSectionPartRepository;
    private final CrossSectionPartService crossSectionPartService;

    public CrossSectionPartsController(CrossSectionPartRepository crossSectionPartRepository,CrossSectionPartService crossSectionPartService) {
        this.crossSectionPartRepository = crossSectionPartRepository;
        this.crossSectionPartService = crossSectionPartService;
    }

    // @GetMapping("/{idCrossSectionParts}")

    @PostMapping
    public void createCrossSection(@RequestBody CrossSectionPartDto dto){
        System.out.println("CrossSectionCtrl: " + dto.toString());
        CrossSectionPartDto crossSectionPartDto
        = CrossSectionPartService.createCrossSectionPart(dto);
    }

}