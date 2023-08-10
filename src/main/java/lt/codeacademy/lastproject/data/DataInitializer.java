/*
package lt.codeacademy.lastproject.data;

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


        UserEntity user1 = new UserEntity();
        user1.setUsername("john_doe");
        user1.setEmail("john@example.com");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setAge(30);
        user1.setHeight(175);
        user1.setWeight(70);
        userRepository.save(user1);

        UserEntity user2 = new UserEntity();
        user2.setUsername("jane_smith");
        user2.setEmail("jane@example.com");
        user2.setFirstName("Jane");
        user2.setLastName("Smith");
        user2.setAge(28);
        user2.setHeight(160);
        user2.setWeight(55);
        userRepository.save(user2);

        UserEntity user3 = new UserEntity();
        user3.setUsername("michael_johnson");
        user3.setEmail("michael@example.com");
        user3.setFirstName("Michael");
        user3.setLastName("Johnson");
        user3.setAge(25);
        user3.setHeight(180);
        user3.setWeight(75);
        userRepository.save(user3);

        UserEntity user4 = new UserEntity();
        user4.setUsername("emily_williams");
        user4.setEmail("emily@example.com");
        user4.setFirstName("Emily");
        user4.setLastName("Williams");
        user4.setAge(35);
        user4.setHeight(165);
        user4.setWeight(60);
        userRepository.save(user4);

        UserEntity user5 = new UserEntity();
        user5.setUsername("david_smith");
        user5.setEmail("david@example.com");
        user5.setFirstName("David");
        user5.setLastName("Smith");
        user5.setAge(28);
        user5.setHeight(170);
        user5.setWeight(65);
        userRepository.save(user5);


        // Create and save sample health data
        HealthDataEntity healthData1 = new HealthDataEntity();
        healthData1.setWeight(75.5);
        healthData1.setBodyFatPercentage(18.5);
        healthData1.setBloodPressure("120/80");
        healthData1.setWaterIntake(2500);
        healthData1.setDateRecorded(LocalDate.now().minusDays(7));
        healthData1.setUser(user1);
        healthDataRepository.save(healthData1);

        HealthDataEntity healthData2 = new HealthDataEntity();
        healthData2.setWeight(60.2);
        healthData2.setBodyFatPercentage(22.0);
        healthData2.setBloodPressure("130/85");
        healthData2.setWaterIntake(2200);
        healthData2.setDateRecorded(LocalDate.now().minusDays(5));
        healthData2.setUser(user2);
        healthDataRepository.save(healthData2);

        // Create and save sample fitness goals
        FitnessGoalEntity fitnessGoal1 = new FitnessGoalEntity();
        fitnessGoal1.setGoalDescription("Lose 5 kg in 2 months");
        fitnessGoal1.setStartDate(LocalDate.now().minusDays(10));
        fitnessGoal1.setEndDate(LocalDate.now().plusMonths(2));
        fitnessGoal1.setProgress(20);
        fitnessGoal1.setCompleted(false);
        fitnessGoal1.setUser(user1);
        fitnessGoalRepository.save(fitnessGoal1);

        FitnessGoalEntity fitnessGoal2 = new FitnessGoalEntity();
        fitnessGoal2.setGoalDescription("Run a 10K race");
        fitnessGoal2.setStartDate(LocalDate.now().minusMonths(1));
        fitnessGoal2.setEndDate(LocalDate.now().plusMonths(1));
        fitnessGoal2.setProgress(75);
        fitnessGoal2.setCompleted(true);
        fitnessGoal2.setUser(user2);
        fitnessGoalRepository.save(fitnessGoal2);

        HealthDataEntity healthData3 = new HealthDataEntity();
        healthData3.setWeight(70.0);
        healthData3.setBodyFatPercentage(20.0);
        healthData3.setBloodPressure("125/85");
        healthData3.setWaterIntake(2200);
        healthData3.setDateRecorded(LocalDate.now().minusDays(4));
        healthData3.setUser(user3);
        healthDataRepository.save(healthData3);

        HealthDataEntity healthData4 = new HealthDataEntity();
        healthData4.setWeight(63.5);
        healthData4.setBodyFatPercentage(18.0);
        healthData4.setBloodPressure("118/75");
        healthData4.setWaterIntake(2500);
        healthData4.setDateRecorded(LocalDate.now().minusDays(6));
        healthData4.setUser(user4);
        healthDataRepository.save(healthData4);

        HealthDataEntity healthData5 = new HealthDataEntity();
        healthData5.setWeight(68.7);
        healthData5.setBodyFatPercentage(22.5);
        healthData5.setBloodPressure("130/88");
        healthData5.setWaterIntake(2300);
        healthData5.setDateRecorded(LocalDate.now().minusDays(3));
        healthData5.setUser(user5);
        healthDataRepository.save(healthData5);

        FitnessGoalEntity fitnessGoal3 = new FitnessGoalEntity();
        fitnessGoal3.setGoalDescription("Increase muscle mass");
        fitnessGoal3.setStartDate(LocalDate.now().minusDays(8));
        fitnessGoal3.setEndDate(LocalDate.now().plusMonths(3));
        fitnessGoal3.setProgress(40);
        fitnessGoal3.setCompleted(false);
        fitnessGoal3.setUser(user3);
        fitnessGoalRepository.save(fitnessGoal3);

        FitnessGoalEntity fitnessGoal4 = new FitnessGoalEntity();
        fitnessGoal4.setGoalDescription("Complete a marathon");
        fitnessGoal4.setStartDate(LocalDate.now().minusMonths(2));
        fitnessGoal4.setEndDate(LocalDate.now().plusMonths(4));
        fitnessGoal4.setProgress(60);
        fitnessGoal4.setCompleted(false);
        fitnessGoal4.setUser(user4);
        fitnessGoalRepository.save(fitnessGoal4);

        FitnessGoalEntity fitnessGoal5 = new FitnessGoalEntity();
        fitnessGoal5.setGoalDescription("Improve flexibility");
        fitnessGoal5.setStartDate(LocalDate.now().minusDays(7));
        fitnessGoal5.setEndDate(LocalDate.now().plusMonths(2));
        fitnessGoal5.setProgress(30);
        fitnessGoal5.setCompleted(false);
        fitnessGoal5.setUser(user5);
        fitnessGoalRepository.save(fitnessGoal5);
    }
}


*/