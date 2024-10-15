package nl.jhx.vapp.controller;

import jakarta.validation.Valid;
import nl.jhx.vapp.dtos.CrossSectionDto;
import nl.jhx.vapp.dtos.CrossSectionInputDto;
import nl.jhx.vapp.mappers.CrossSectionMapper;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.repository.CrossSectionPartRepository;
import nl.jhx.vapp.repository.CrossSectionRepository;
import nl.jhx.vapp.services.CrossSectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("projects/{idProject}/crossSections") // /{id}/crossSections
public class CrossSectionController {

    private final CrossSectionMapper crossSectionMapper;
    private final CrossSectionRepository crossSectionRepository;
    private final CrossSectionService crossSectionService;

    public CrossSectionController(CrossSectionMapper crossSectionMapper, CrossSectionService crossSectionService, CrossSectionRepository crossSectionRepository) {
        this.crossSectionMapper = crossSectionMapper;
        this.crossSectionService = crossSectionService;
        this.crossSectionRepository = crossSectionRepository;
    }
/*      Da OLDE

    @GetMapping
    public ResponseEntity<List<CrossSection>> getCrossSections(Long idCrossSection) {
        return ResponseEntity.ok(crossSectionRepository.findAll());
    }

    @GetMapping("/{idCrossSection}")
    public ResponseEntity<CrossSectionInputDto> getCrossSection(@PathVariable Long idCrossSection) {
        System.out.println("GET CrossSection with id: " + idCrossSection);
        CrossSectionInputDto crossSectionInputDto = crossSectionService.getCrossSectionById(idCrossSection);
        return ResponseEntity.ok().body(crossSectionInputDto);
    }*/


    @GetMapping
    public ResponseEntity<List<CrossSection>> getCrossSections(Long idCrossSection) {
        return ResponseEntity.ok(crossSectionRepository.findAll());
    }

    @GetMapping("/{idCrossSection}")
    public ResponseEntity<CrossSectionDto> getCrossSection(@PathVariable Long idCrossSection) {
        System.out.println("GET CrossSection with id: " + idCrossSection);
        return ResponseEntity.ok(crossSectionService.getCrossSectionById(idCrossSection));
    }


/*
    @GetMapping
    public ResponseEntity<List<CarSalesDto>> getAllCars() {
        List<CarSalesDto> cars = carService.getAllCars();

        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarSalesDto> getCar(@PathVariable Long id){
        return ResponseEntity.ok(carService.getCarById(id));

    }
    */



    /*@PostMapping
    public ResponseEntity<Object> createCrossSection(@RequestBody CrossSectionInputDto dtos) {
        System.out.println("CrossSection Controller: " + dtos.toString());
        CrossSectionInputDto crossSectionInputDto = crossSectionService.createCrossSection(dtos);
        return ResponseEntity.status(HttpStatus.CREATED).body(crossSectionInputDto);
    }*/

    @PostMapping
    public ResponseEntity<CrossSectionDto> createCrossSection(@Valid @RequestBody CrossSectionInputDto dto, @PathVariable Long idProject) {
        CrossSectionDto savedCs = crossSectionService.saveCrossSection(dto, idProject);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentRequest().path("/"+ savedCs.getId()).toString());
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", uri.toString()).build();
            }

}