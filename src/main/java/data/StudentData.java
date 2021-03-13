package data;

import java.time.LocalDate;

import static data.CurriculumList.AQE;
import static data.CurriculumList.JAVA_DEVELOPER;

public enum  StudentData {
    IVANOV_I("Ivanov Ivan", "Java Developer", LocalDate.of(2020,06,01), JAVA_DEVELOPER),
    SIDOROV_I("Sidorov Ivan", "J2EE Developer", LocalDate.of(2020,06,01), AQE);

    private final String name;
    private final String specialization;
    private final LocalDate startDate;
    private final CurriculumList curriculumName;
    
    StudentData(String name, String specialization, LocalDate startDate, CurriculumList curriculumName) {
        this.name = name;
        this.specialization = specialization;
        this.startDate = startDate;
        this.curriculumName = curriculumName;
    }
}
