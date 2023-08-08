package lt.codeacademy.lastproject.converters;

import lt.codeacademy.lastproject.dto.FitnessGoalDTO;
import lt.codeacademy.lastproject.entities.FitnessGoalEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FitnessGoalConverter {

    public FitnessGoalEntity toEntity(FitnessGoalDTO dto) {
        FitnessGoalEntity entity = new FitnessGoalEntity();
        entity.setId(dto.getId());
        entity.setGoalDescription(dto.getGoalDescription());
        entity.setStartDate(LocalDate.parse(dto.getStartDate()));
        entity.setEndDate(LocalDate.parse(dto.getEndDate()));
        entity.setProgress(dto.getProgress());
        entity.setCompleted(dto.isCompleted());
        entity.setId(dto.getUserId());
        return entity;
    }

    public FitnessGoalDTO toDto(FitnessGoalEntity entity) {
        FitnessGoalDTO dto = new FitnessGoalDTO();
        dto.setId(entity.getId());
        dto.setGoalDescription(entity.getGoalDescription());
        dto.setStartDate(entity.getStartDate().toString());
        dto.setEndDate(entity.getEndDate().toString());
        dto.setProgress(entity.getProgress());
        dto.setCompleted(entity.isCompleted());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

    public List<FitnessGoalDTO> toDtoList(List<FitnessGoalEntity> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}