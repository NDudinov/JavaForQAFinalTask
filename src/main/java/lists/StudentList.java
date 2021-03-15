package lists;

import constructors.Student;

import static data.StudentData.IVANOV_I;
import static data.StudentData.SIDOROV_I;
import static lists.CurriculumList.aqeCurriculum;
import static lists.CurriculumList.javaDeveloperCurriculum;

public class StudentList {
    public static Student studentIvanovI = Student.builder()
            .name(IVANOV_I.name)
            .specialization(IVANOV_I.specialization)
            .curriculum(javaDeveloperCurriculum)
            .startDate(IVANOV_I.startDate)
            .build();
    public static Student studentSidorovI = Student.builder()
            .name(SIDOROV_I.name)
            .specialization(SIDOROV_I.specialization)
            .curriculum(aqeCurriculum)
            .startDate(SIDOROV_I.startDate)
            .build();
}
