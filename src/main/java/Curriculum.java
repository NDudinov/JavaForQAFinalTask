import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Curriculum {
    private List<Course> courseList;
    private boolean isFinished = false;
    private String curriculumName;
    private LocalDate startDate;
    private LocalDate endDate;
    
    
    public Curriculum(List<Course> courseList, String name) {
        this.courseList = courseList;
        this.curriculumName = name;
    }
    
    
    
}
