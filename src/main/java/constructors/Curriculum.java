package constructors;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import static data.GeneralConstants.DAY_LENGTH;

@Data
@Builder(toBuilder = true)
public class Curriculum {
    private List<Course> courseList;
    private boolean isFinished = false;
    private String curriculumName;
    private LocalDateTime startDate;
    private LocalDateTime endDate; 
    
    public int curriculumLength() {
        int length= 0;
        for(Course course:courseList) {
            length += course.getDurationInHours();
        }
        return length;
    }
    
    public LocalDateTime endDate() {
        return startDate.plusDays((long) curriculumLength() / DAY_LENGTH);
    }
    
}
