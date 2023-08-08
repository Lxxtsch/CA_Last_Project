package lt.codeacademy.lastproject.services;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.lastproject.converters.HealthDataConverter;
import lt.codeacademy.lastproject.dto.HealthDataDTO;
import lt.codeacademy.lastproject.entities.HealthDataEntity;
import lt.codeacademy.lastproject.entities.UserEntity;
import lt.codeacademy.lastproject.repositories.HealthDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HealthDataService {

    private final HealthDataRepository healthDataRepository;
    private final HealthDataConverter healthDataConverter;

    public HealthDataDTO createHealthData(Long userId, HealthDataDTO healthDataDTO) {
        HealthDataEntity healthDataEntity = healthDataConverter.toEntity(healthDataDTO);
        UserEntity user = new UserEntity();
        user.setId(userId);
        healthDataEntity.setUser(user);

        healthDataEntity = healthDataRepository.save(healthDataEntity);
        return healthDataConverter.toDto(healthDataEntity);
    }

    public List<HealthDataDTO> getAllHealthData() {
        List<HealthDataEntity> healthDataList = healthDataRepository.findAll();
        return healthDataList.stream()
                .map(healthDataConverter::toDto)
                .collect(Collectors.toList());
    }

    public HealthDataDTO getHealthDataById(Long healthDataId) {
        HealthDataEntity healthDataEntity = healthDataRepository.findById(healthDataId)
                .orElseThrow(() -> new NoSuchElementException("Health Data with ID " + healthDataId + " not found"));

        return healthDataConverter.toDto(healthDataEntity);
    }

    public HealthDataDTO updateHealthDataById(Long healthDataId, HealthDataDTO healthDataDTO) {
        HealthDataEntity existingHealthData = healthDataRepository.findById(healthDataId)
                .orElseThrow(() -> new NoSuchElementException("Health Data with ID " + healthDataId + " not found"));

        existingHealthData.setWeight(healthDataDTO.getWeight());
        existingHealthData.setBodyFatPercentage(healthDataDTO.getBodyFatPercentage());
        existingHealthData.setBloodPressure(healthDataDTO.getBloodPressure());
        existingHealthData.setWaterIntake(healthDataDTO.getWaterIntake());
        existingHealthData.setDateRecorded(LocalDate.parse(healthDataDTO.getDateRecorded()));

        HealthDataEntity updatedHealthData = healthDataRepository.save(existingHealthData);
        return healthDataConverter.toDto(updatedHealthData);
    }

    public void deleteHealthDataById(Long healthDataId) {
        HealthDataEntity existingHealthData = healthDataRepository.findById(healthDataId)
                .orElseThrow(() -> new NoSuchElementException("Health Data with ID " + healthDataId + " not found"));

        healthDataRepository.delete(existingHealthData);
    }

    public List<HealthDataDTO> getHealthDataByUserId(Long userId) {
        List<HealthDataEntity> healthDataList = healthDataRepository.findByUserId(userId);
        return healthDataConverter.toDtoList(healthDataList);
    }
}