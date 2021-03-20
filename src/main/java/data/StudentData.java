package data;

import java.time.LocalDateTime;

import static data.CurriculumData.AQE;
import static data.CurriculumData.JAVA_DEVELOPER;

public enum StudentData {
    IVANOV_I("Ivanov Ivan", "Java Developer", LocalDateTime.of(2020, 06, 01, 10, 0), JAVA_DEVELOPER),
    SIDOROV_I("Sidorov Ivan", "J2EE Developer", LocalDateTime.of(2020, 06, 01, 10, 0), AQE);

    public final String name;
    public final String specialization;
    public final LocalDateTime startDate;
    public final CurriculumData curriculumName;
    
    StudentData(String name, String specialization, LocalDateTime startDate, CurriculumData curriculumName) {
        this.name = name;
        this.specialization = specialization;
        this.startDate = startDate;
        this.curriculumName = curriculumName;
    }
}
