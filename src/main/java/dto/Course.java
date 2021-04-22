package dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Course {
    private String courseName;
    private int durationInHours;
}
