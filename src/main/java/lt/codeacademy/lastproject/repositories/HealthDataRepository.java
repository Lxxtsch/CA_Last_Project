package lt.codeacademy.lastproject.repositories;
import lt.codeacademy.lastproject.entities.HealthDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthDataRepository extends JpaRepository<HealthDataEntity, Long> {

    List<HealthDataEntity> findByUserId(Long userId);
}
