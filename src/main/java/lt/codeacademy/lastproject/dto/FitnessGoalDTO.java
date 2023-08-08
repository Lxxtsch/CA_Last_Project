package lt.codeacademy.lastproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FitnessGoalDTO {

    private Long id;
    private String goalDescription;
    private String startDate;
    private String endDate;
    private int progress;
    private boolean completed;
    private Long userId;

}