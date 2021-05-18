package lists;

import dto.Student;
import tools.TimeCalculator;

import static data.StudentData.IVANOV_I;
import static data.StudentData.SIDOROV_I;

public class StudentList {
    public final static Student studentIvanovI = Student.builder()
            .name(IVANOV_I.name)
            .specialization(IVANOV_I.specialization)
            .startDate(IVANOV_I.startDate)
            .curriculum(CurriculumList.javaDeveloperCurriculum.toBuilder()
                    .startDate(IVANOV_I.startDate)
                    .endDate(new TimeCalculator().calculateEndDate(IVANOV_I.startDate, CurriculumList.javaDeveloperCurriculum.curriculumLength()))
                    .build())
            .build();
    public final static Student studentSidorovI = Student.builder()
            .name(SIDOROV_I.name)
            .specialization(SIDOROV_I.specialization)
            .startDate(SIDOROV_I.startDate)
            .curriculum(CurriculumList.aqeCurriculum.toBuilder()
                    .startDate(SIDOROV_I.startDate)
                    .endDate(new TimeCalculator().calculateEndDate(SIDOROV_I.startDate, CurriculumList.aqeCurriculum.curriculumLength()))
                    .build())
            .build();
}
