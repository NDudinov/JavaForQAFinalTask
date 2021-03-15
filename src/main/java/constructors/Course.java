package constructors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Course {
    private String courseName;
    private int durationInHours;
    
    public Course(String name, int durationInHours) {
        this.courseName = name;
        this.durationInHours = durationInHours;
    }
}
