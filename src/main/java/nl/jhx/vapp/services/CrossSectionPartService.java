package nl.jhx.vapp.services;

import nl.jhx.vapp.dtos.CrossSectionPartDto;
import nl.jhx.vapp.exception.ShitHappensAt;
import nl.jhx.vapp.exception.xNotFoundException;
import nl.jhx.vapp.model.CrossSectionPart;
import nl.jhx.vapp.repository.CrossSectionPartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrossSectionPartService {

    private final CrossSectionPartRepository crossSectionPartRepository;

    public CrossSectionPartService(CrossSectionPartRepository crossSectionPartRepository) {this.crossSectionPartRepository = crossSectionPartRepository;}



    public CrossSectionPartDto getCrossSectionPartByName(String name) {
        Optional<CrossSectionPart> crossSection = crossSectionPartRepository.findById(name);
        if (crossSection.isPresent()) {
            return toCrossSectionPartDto(crossSection.get());
        } else {
            throw new xNotFoundException("The requested Cross Section Part could not be found.", "getCrossSectionPartByName", crossSection.toString());
        }
    }

    public CrossSectionPartDto createCrossSectionPart(CrossSectionPartDto dto) {
        CrossSectionPart crossSectionPart = toCrossSectionPart(dto);
        crossSectionPartRepository.save(crossSectionPart);
        return toCrossSectionPartDto(crossSectionPart);
    }

    public CrossSectionPart toCrossSectionPart(CrossSectionPartDto crossSectionPartDto) {
        CrossSectionPart crossSectionPart = new CrossSectionPart();
        crossSectionPart.setName(crossSectionPartDto.getName());
        crossSectionPart.setType(crossSectionPartDto.getType());
        crossSectionPart.setPavementType(crossSectionPartDto.getPavementType());
        crossSectionPart.setPavementWidth(crossSectionPartDto.getPavementWidth());
        crossSectionPart.setDesignVelocity(crossSectionPartDto.getDesignVelocity());
        crossSectionPart.setIntensity(crossSectionPartDto.getIntensity());
        return crossSectionPart;
    }

    public CrossSectionPartDto toCrossSectionPartDto(CrossSectionPart crossSectionPart) {
        try {
            return new CrossSectionPartDto(crossSectionPart.getName(), crossSectionPart.getType(), crossSectionPart.getPavementType(), crossSectionPart.getPavementWidth(), crossSectionPart.getDesignVelocity(), crossSectionPart.getIntensity());
        } catch (Exception e) {
            throw new ShitHappensAt(e.getMessage() + " --- Creating CsPart DTO failed! ---");
        }
    }

    public List<CrossSectionPartDto> arrayToObjects(List<CrossSectionPartDto> cspList) {
        List<CrossSectionPartDto> cspDtos = new ArrayList<>();
        for (CrossSectionPartDto crossSectionPartDto : cspList) {
            cspDtos.add(createCrossSectionPart(crossSectionPartDto));
        };
        return cspDtos;
    }


}
