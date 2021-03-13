import data.StudentData;

import java.time.LocalDate;

public class Report {
    public void generateShortReport(Student student, LocalDate dateOfReport) {
        LocalDate studentStartDate = student.getStartDate();
        String daysPast = dateOfReport.until(dateOfReport).toString();
        if (dateOfReport.isAfter(studentStartDate)) {
            student.getCurriculum().setFinished(true);
        }
        String finished;
        if (student.getCurriculum().isFinished()) {
            System.out.println(String.format("%s (%s) - Training completed. %s are left until the end.", student.getName(), student.getSpecialization(), daysPast));
        } else {
            System.out.println(String.format("%s (%s) - Training  is not finished. %s have passed since the end.", student.getName(), student.getSpecialization(), daysPast));
        }

    }

    public static void main(String[] args) {
        Student student1 = new Student(StudentData.IVANOV_I.name(), StudentData.IVANOV_I);
    }
}

