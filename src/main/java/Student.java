import lombok.Data;

import java.time.LocalDate;

@Data
public class Student {
    private Curriculum curriculum;
    private String name;
    private LocalDate startDate;
    private String specialization;
    
    public Student(String name, String specialization, Curriculum curriculum, LocalDate date) {
        this.curriculum = curriculum;
        this.name = name;
        this.startDate = date;
        this.specialization = specialization;
    }

    
    
}
