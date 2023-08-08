package lt.codeacademy.lastproject.repositories;

import lt.codeacademy.lastproject.entities.FitnessGoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FitnessGoalRepository extends JpaRepository<FitnessGoalEntity, Long> {

    List<FitnessGoalEntity> findByUserId(Long userId);

}