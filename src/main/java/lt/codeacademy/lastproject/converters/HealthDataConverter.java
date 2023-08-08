package lt.codeacademy.lastproject.converters;

import lt.codeacademy.lastproject.dto.HealthDataDTO;
import lt.codeacademy.lastproject.entities.HealthDataEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HealthDataConverter {
    public HealthDataEntity toEntity(HealthDataDTO dto) {
        HealthDataEntity entity = new HealthDataEntity();
        entity.setId(dto.getId());
        entity.setWeight(dto.getWeight());
        entity.setBodyFatPercentage(dto.getBodyFatPercentage());
        entity.setBloodPressure(dto.getBloodPressure());
        entity.setWaterIntake(dto.getWaterIntake());
        entity.setDateRecorded(LocalDate.parse(dto.getDateRecorded()));
        entity.setId(dto.getUserId());
        return entity;
    }

    public HealthDataDTO toDto(HealthDataEntity entity) {
        HealthDataDTO dto = new HealthDataDTO();
        dto.setId(entity.getId());
        dto.setWeight(entity.getWeight());
        dto.setBodyFatPercentage(entity.getBodyFatPercentage());
        dto.setBloodPressure(entity.getBloodPressure());
        dto.setWaterIntake(entity.getWaterIntake());
        dto.setDateRecorded(entity.getDateRecorded().toString());
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

    public List<HealthDataDTO> toDtoList(List<HealthDataEntity> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}


