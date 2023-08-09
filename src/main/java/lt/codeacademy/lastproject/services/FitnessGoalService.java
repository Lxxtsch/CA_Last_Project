package lt.codeacademy.lastproject.services;

import lombok.RequiredArgsConstructor;
import lt.codeacademy.lastproject.converters.FitnessGoalConverter;
import lt.codeacademy.lastproject.dto.FitnessGoalDTO;
import lt.codeacademy.lastproject.entities.FitnessGoalEntity;
import lt.codeacademy.lastproject.entities.UserEntity;
import lt.codeacademy.lastproject.repositories.FitnessGoalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FitnessGoalService {

    private final FitnessGoalRepository fitnessGoalRepository;
    private final FitnessGoalConverter fitnessGoalConverter;

    public FitnessGoalDTO createFitnessGoal(Long userId, FitnessGoalDTO fitnessGoalDTO) {
        FitnessGoalEntity fitnessGoalEntity = fitnessGoalConverter.toEntity(fitnessGoalDTO);
        UserEntity user = new UserEntity();
        user.setId(userId);
        fitnessGoalEntity.setUser(user);

        fitnessGoalEntity = fitnessGoalRepository.save(fitnessGoalEntity);
        return fitnessGoalConverter.toDto(fitnessGoalEntity);
    }

    public List<FitnessGoalDTO> getAllFitnessGoals() {
        List<FitnessGoalEntity> fitnessGoalList = fitnessGoalRepository.findAll();
        return fitnessGoalList.stream()
                .map(fitnessGoalConverter::toDto)
                .collect(Collectors.toList());
    }

    public FitnessGoalDTO getFitnessGoalById(Long fitnessGoalId) {
        FitnessGoalEntity fitnessGoalEntity = fitnessGoalRepository.findById(fitnessGoalId)
                .orElseThrow(() -> new NoSuchElementException("Fitness Goal with ID " + fitnessGoalId + " not found"));

        return fitnessGoalConverter.toDto(fitnessGoalEntity);
    }

    public FitnessGoalDTO updateFitnessGoalById(Long fitnessGoalId, FitnessGoalDTO fitnessGoalDTO) {
        FitnessGoalEntity existingFitnessGoal = fitnessGoalRepository.findById(fitnessGoalId)
                .orElseThrow(() -> new NoSuchElementException("Fitness Goal with ID " + fitnessGoalId + " not found"));

        existingFitnessGoal.setGoalDescription(fitnessGoalDTO.getGoalDescription());
        existingFitnessGoal.setStartDate(LocalDate.parse(fitnessGoalDTO.getStartDate()));
        existingFitnessGoal.setEndDate(LocalDate.parse(fitnessGoalDTO.getEndDate()));
        existingFitnessGoal.setProgress(fitnessGoalDTO.getProgress());
        existingFitnessGoal.setCompleted(fitnessGoalDTO.isCompleted());

        FitnessGoalEntity updatedFitnessGoal = fitnessGoalRepository.save(existingFitnessGoal);
        return fitnessGoalConverter.toDto(updatedFitnessGoal);
    }

    public void deleteFitnessGoalById(Long fitnessGoalId) {
        FitnessGoalEntity existingFitnessGoal = fitnessGoalRepository.findById(fitnessGoalId)
                .orElseThrow(() -> new NoSuchElementException("Fitness Goal with ID " + fitnessGoalId + " not found"));

        fitnessGoalRepository.delete(existingFitnessGoal);
    }

    public List<FitnessGoalDTO> getFitnessGoalsByUserId(Long userId) {
        List<FitnessGoalEntity> fitnessGoals = fitnessGoalRepository.findByUserId(userId);
        return fitnessGoalConverter.toDtoList(fitnessGoals);
    }

    public void deleteFitnessGoalsByUserId(Long userId) {
        List<FitnessGoalDTO> fitnessGoals = getFitnessGoalsByUserId(userId);

        for (FitnessGoalDTO fitnessGoal : fitnessGoals) {
            fitnessGoalRepository.deleteById(fitnessGoal.getId());
        }
    }
}