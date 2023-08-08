package lt.codeacademy.lastproject.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "health_data")
@Data
public class HealthDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private double weight;

    @Column(name = "body_fat_percentage")
    private double bodyFatPercentage;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "water_intake")
    private double waterIntake;

    @Column(name = "date_recorded")
    private LocalDate dateRecorded;


}