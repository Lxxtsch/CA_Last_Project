/*package lt.codeacademy.lastproject.data;


import lt.codeacademy.lastproject.entities.FitnessGoalEntity;
import lt.codeacademy.lastproject.entities.HealthDataEntity;
import lt.codeacademy.lastproject.entities.UserEntity;
import lt.codeacademy.lastproject.repositories.FitnessGoalRepository;
import lt.codeacademy.lastproject.repositories.HealthDataRepository;
import lt.codeacademy.lastproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final HealthDataRepository healthDataRepository;
    private final FitnessGoalRepository fitnessGoalRepository;

    @Autowired
    public DataInitializer(UserRepository userRepository, HealthDataRepository healthDataRepository,
                           FitnessGoalRepository fitnessGoalRepository) {
        this.userRepository = userRepository;
        this.healthDataRepository = healthDataRepository;
        this.fitnessGoalRepository = fitnessGoalRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save sample users
        for (int i = 1; i <= 10; i++) {
            UserEntity user = new UserEntity();
            user.setUsername("user" + i);
            user.setEmail("user" + i + "@example.com");
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            user.setAge(25 + i);
            user.setHeight(170 + i);
            user.setWeight(70 + i);
            userRepository.save(user);
        }

        // Get all users from the repository
        List<UserEntity> users = userRepository.findAll();

        // Create and save sample health data for each user
        for (UserEntity user : users) {
            for (int i = 1; i <= 10; i++) {
                HealthDataEntity healthData = new HealthDataEntity();
                healthData.setWeight(70 + i);
                healthData.setBodyFatPercentage(20 + i);
                healthData.setBloodPressure("120/80");
                healthData.setWaterIntake(2000 + i * 100);
                healthData.setDateRecorded(LocalDate.now().minusDays(i));
                healthData.setUser(user); // Set the user for health data
                healthDataRepository.save(healthData);
            }
        }

        // Create and save sample fitness goals for each user
        for (UserEntity user : users) {
            for (int i = 1; i <= 10; i++) {
                FitnessGoalEntity fitnessGoal = new FitnessGoalEntity();
                fitnessGoal.setGoalDescription("Fitness Goal " + i);
                fitnessGoal.setStartDate(LocalDate.now().minusDays(i * 10));
                fitnessGoal.setEndDate(LocalDate.now().plusDays(i * 10));
                fitnessGoal.setProgress(10 * i);
                fitnessGoal.setCompleted(i % 2 == 0); // Alternate between completed and not completed
                fitnessGoal.setUser(user); // Set the user for fitness goal
                fitnessGoalRepository.save(fitnessGoal);
            }
        }
    }
}*/