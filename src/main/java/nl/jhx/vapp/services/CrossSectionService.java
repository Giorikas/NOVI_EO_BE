package nl.jhx.vapp.services;

import nl.jhx.vapp.dtos.CrossSectionDto;
import nl.jhx.vapp.dtos.CrossSectionInputDto;
import nl.jhx.vapp.exception.xNotFoundException;
import nl.jhx.vapp.mappers.CrossSectionMapper;
import nl.jhx.vapp.model.CrossSection;
import nl.jhx.vapp.model.Project;
import nl.jhx.vapp.repository.CrossSectionRepository;
import nl.jhx.vapp.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CrossSectionService {

    private final CrossSectionRepository crossSectionRepository;
    private final ProjectRepository projectRepository;
    private final CrossSectionMapper crossSectionMapper;


    public CrossSectionService(CrossSectionRepository crossSectionRepository, CrossSectionMapper crossSectionMapper, ProjectRepository projectRepository ) {
        this.crossSectionRepository = crossSectionRepository;
        this.projectRepository = projectRepository;
        this.crossSectionMapper = crossSectionMapper;

    }

    public CrossSectionDto getCrossSectionById(Long id) {
        System.out.println("get CrossSection by id: " + id);
        Optional<CrossSection> csOptional = crossSectionRepository.findById(id);
        if (csOptional.isPresent()) {
            CrossSection crossSection = csOptional.get();
            return crossSectionMapper.crossSectionToCrossSectionDto(crossSection);
        } else {
            throw new xNotFoundException("Requested crossSection could not be found.", csOptional.toString(), "NEEDS IMPROVEMENT" );
        }
    }

    public CrossSectionInputDto createCrossSection(CrossSectionInputDto crossSectionInputDto) {
        CrossSection crossSection = toCrossSection(crossSectionInputDto);
        crossSectionRepository.save(crossSection);
        return toCrossSectionDto(crossSection);
    }

    public CrossSection toCrossSection(CrossSectionInputDto crossSectionInputDto) {
        CrossSection crossSection = new CrossSection();
        crossSection.setName(crossSectionInputDto.getName());
        crossSection.setStatus(crossSectionInputDto.getStatus());
        crossSection.setLeftBorder(crossSectionInputDto.getLeftBorder());
        crossSection.setRightBorder(crossSectionInputDto.getRightBorder());
        crossSection.setWidth(crossSectionInputDto.getWidth());

        return crossSection;
    }

    public CrossSectionInputDto toCrossSectionDto(CrossSection crossSection) {
        try {
            return new CrossSectionInputDto(crossSection.getId(), crossSection.getName(), crossSection.getStatus(), crossSection.getLeftBorder(), crossSection.getRightBorder(), crossSection.getWidth());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CrossSectionDto saveCrossSection(CrossSectionInputDto dto, Long idProject) {

        Optional<Project> pr = projectRepository.findById(idProject);
        System.out.println(pr);
        Project project;
        if (!pr.isPresent()) {
            throw new xNotFoundException("Project not found" + idProject, "CrossSection: " + dto.getId(), dto.toString());
        }
        project = pr.get();
        CrossSection crossSection = crossSectionMapper.crossSectionInputDtoToCrossSection(dto, project);
        return crossSectionMapper.crossSectionToCrossSectionDto(crossSectionRepository.save(crossSection));
    }

}
