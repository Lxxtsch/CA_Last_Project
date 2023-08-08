package lt.codeacademy.lastproject.dto;

import lombok.Data;

@Data
public class HealthDataDTO {

    private Long id;
    private double weight;
    private double bodyFatPercentage;
    private String bloodPressure;
    private double waterIntake;
    private String dateRecorded;
    private Long userId;
}