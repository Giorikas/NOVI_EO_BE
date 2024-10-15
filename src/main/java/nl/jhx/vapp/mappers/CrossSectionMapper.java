package nl.jhx.vapp.mappers;

import nl.jhx.vapp.dtos.CrossSectionDto;
import nl.jhx.vapp.dtos.CrossSectionInputDto;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.model.Project;
import org.springframework.stereotype.Component;

@Component
public class CrossSectionMapper {

    public CrossSection crossSectionInputDtoToCrossSection(CrossSectionInputDto dto, Project project) {
        CrossSection cs = new CrossSection();
        cs.setName(dto.getName());
        cs.setStatus(dto.getStatus());
        cs.setLeftBorder(dto.getLeftBorder());
        cs.setRightBorder(dto.getRightBorder());
        cs.setWidth(dto.getWidth());
        cs.setProject(project);
        return cs;
    }

    public CrossSectionDto crossSectionToCrossSectionDto(CrossSection cs) {
        System.out.println("--- MAPPER ---");
        CrossSectionDto dto = new CrossSectionDto();
        dto.setId(cs.getId());
        dto.setName(cs.getName());
        dto.setStatus(cs.getStatus());
        dto.setLeftBorder(cs.getLeftBorder());
        dto.setRightBorder(cs.getRightBorder());
        dto.setWidth(cs.getWidth());

        System.out.println(dto.toString());

        return dto;
    }

}
