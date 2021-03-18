package constructors;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Student {
    private String name;
    private String specialization;
    private LocalDateTime startDate;
    private Curriculum curriculum;
}
