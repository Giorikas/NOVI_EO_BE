package nl.jhx.vapp.services;

import nl.jhx.vapp.dto.CrossSectionDto;
import nl.jhx.vapp.exception.xNotFoundException;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.repository.CrossSectionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrossSectionService {

    private final CrossSectionRepository crossSectionRepository;

    public CrossSectionService(CrossSectionRepository crossSectionRepository) {
        this.crossSectionRepository = crossSectionRepository;
    }

    public CrossSectionDto getCrossSectionById(Long id) {
        System.out.println("get CrossSection by id: " + id);
        Optional<CrossSection> crossSection = crossSectionRepository.findById(id);
        if (crossSection.isPresent()) {
            return toCrossSectionDto(crossSection.get());
        } else {
            throw new xNotFoundException("Requested crossSection could not be found.", "Item goes here, but I have to work this part out..");
        }
    }

    public CrossSectionDto createCrossSection(CrossSectionDto crossSectionDto) {
        CrossSection crossSection = toCrossSection(crossSectionDto);
        crossSectionRepository.save(crossSection);
        return toCrossSectionDto(crossSection);
    }

    public CrossSection toCrossSection(CrossSectionDto crossSectionDto) {
        CrossSection crossSection = new CrossSection();
        crossSection.setName(crossSectionDto.getName());
        crossSection.setStatus(crossSectionDto.getStatus());
        crossSection.setLeftBorder(crossSectionDto.getLeftBorder());
        crossSection.setRightBorder(crossSectionDto.getRightBorder());
        crossSection.setWidth(crossSectionDto.getWidth());

        return crossSection;
    }

    public CrossSectionDto toCrossSectionDto(CrossSection crossSection) {
        try {
            return new CrossSectionDto(crossSection.getId(), crossSection.getName(), crossSection.getStatus(), crossSection.getLeftBorder(), crossSection.getRightBorder(), crossSection.getWidth());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
