package lists;

import constructors.Student;

import static data.StudentData.IVANOV_I;
import static data.StudentData.SIDOROV_I;

public class StudentList {
    public final static Student studentIvanovI = Student.builder()
            .name(IVANOV_I.name)
            .specialization(IVANOV_I.specialization)
            .startDate(IVANOV_I.startDate)
            .build();
    public final static Student studentSidorovI = Student.builder()
            .name(SIDOROV_I.name)
            .specialization(SIDOROV_I.specialization)
            .startDate(SIDOROV_I.startDate)
            .build();
    
    
}
