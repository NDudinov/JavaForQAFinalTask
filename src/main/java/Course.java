import lombok.Data;

@Data
public class Course {
    private String courseName;
    private int durationInHours;
    
    public Course(String name, int durationInHours) {
        this.courseName = name;
        this.durationInHours = durationInHours;
    }
    

    
}
