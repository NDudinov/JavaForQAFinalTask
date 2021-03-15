package constructors;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class Curriculum {
    private List<Course> courseList;
    private boolean isFinished = false;
    private String curriculum;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    
    public int curriculumLength() {
        int length= 0;
        for(Course course:courseList) {
            length += course.getDurationInHours();
        }
        return length;
    }
}
