package constructors;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Student {
    private Curriculum curriculum;
    private String name;
    private LocalDateTime startDate;
    private String specialization;
}
