package nl.jhx.vapp.services;

import nl.jhx.vapp.dto.CrossSectionPartDto;
import nl.jhx.vapp.exception.ShitHappensAt;
import nl.jhx.vapp.exception.xNotFoundException;
import nl.jhx.vapp.model.CrossSectionPart;
import nl.jhx.vapp.repository.CrossSectionPartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrossSectionPartService {

    private final CrossSectionPartRepository crossSectionPartRepository;

    public CrossSectionPartService(CrossSectionPartRepository crossSectionPartRepository) {this.crossSectionPartRepository = crossSectionPartRepository;}

    public static CrossSectionPartDto createCrossSectionPart(CrossSectionPartDto dto) {
        System.out.println(dto.toString());
        return dto;
    }

    public CrossSectionPartDto getCrossSectionPartByName(String name) {
        Optional<CrossSectionPart> crossSection = crossSectionPartRepository.findById(name);
        if (crossSection.isPresent()) {
            return toCrossSectionPartDto(crossSection.get());
        } else {
            throw new xNotFoundException("The requested cross section part could not be found.", "getCrossSectionByName");
        }
    }

    public CrossSectionPart toCrossSectionPart(CrossSectionPartDto crossSectionPartDto) {
        CrossSectionPart crossSectionPart = new CrossSectionPart();
        crossSectionPart.setName(crossSectionPartDto.getName());
        crossSectionPart.setCspType(crossSectionPartDto.getCspType());
        crossSectionPart.setTypePavement(crossSectionPartDto.getPavementType());
        crossSectionPart.setPavementWidth(crossSectionPartDto.getPavementWidth());
        crossSectionPart.setDesignVelocity(crossSectionPartDto.getDesignVelocity());
        crossSectionPart.setIntensity(crossSectionPartDto.getIntensity());
        return crossSectionPart;
    }

    public CrossSectionPartDto toCrossSectionPartDto(CrossSectionPart crossSectionPart) {
        try {
            return new CrossSectionPartDto(crossSectionPart.getName(), crossSectionPart.getCspType(), crossSectionPart.getTypePavement(), crossSectionPart.getPavementWidth(), crossSectionPart.getDesignVelocity(), crossSectionPart.getIntensity());
        } catch (Exception e) {
            throw new ShitHappensAt(e.getMessage() + " --- Creating CsPart DTO failed! ---");
        }
    }


}
