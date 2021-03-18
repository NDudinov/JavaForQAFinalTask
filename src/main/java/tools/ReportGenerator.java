package tools;

import constructors.Student;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

import static data.GeneralConstants.*;
import static java.lang.Math.abs;

public class ReportGenerator {

    private String covertHoursIntoDaysHoursForReport(long hours, long duration) {
        String daysForReport = String.valueOf((int) (abs(hours) / DAY_LENGTH));
        String leftHoursForReport = String.valueOf((int) (abs(hours) % DAY_LENGTH));
        String timeForReport = "%s d %s hours are left %s the end.";
        if (hours<duration) {
            timeForReport = String.format("%s d %s hours are left until the end.", daysForReport, leftHoursForReport);
        } else {
            timeForReport = String.format("%s d %s hours have passed since the end.", daysForReport, leftHoursForReport);
        }
        return timeForReport;
    }
    
    
    public void generateShortReport(Student student, LocalDateTime reportDate) {
        LocalDateTime startDate = student.getCurriculum().getStartDate();
        LocalDateTime endDate = student.getCurriculum().endDate();

        if (startDate != null && endDate != null){
            TimeCalculator timeCalculator = new TimeCalculator();
            if (reportDate.isBefore(ChronoLocalDateTime.from(LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), END_DAY_TIME,0)))){
                if (reportDate.isAfter(ChronoLocalDateTime.from(LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), START_DAY_TIME, 0)))) {
                    long time = timeCalculator.countWorkHoursBetween(startDate, reportDate);
                    System.out.printf("%s (%s %s) - Training is not finished.%n", student.getName(), student.getCurriculum().getCurriculumName(), covertHoursIntoDaysHoursForReport(time, student.getCurriculum().curriculumLength()));
                }
                else {
                    System.out.printf("%s (%s) - Course wasn't started yet.%n", student.getName(),student.getCurriculum().getCurriculumName());
                }
            }
            else {
                long time = timeCalculator.countWorkHoursBetween(startDate, reportDate);
                System.out.printf("%s (%s %s) - Training completed.%n", student.getName(), student.getCurriculum().getCurriculumName(), covertHoursIntoDaysHoursForReport(time, student.getCurriculum().curriculumLength()));
            }
        }
        else {
            System.out.printf("%s (%s) - Not started any course.%n", student.getName(), student.getCurriculum().getCurriculumName());
        }
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE, kk:mm");
    
    public void generateFullReport(Student student, LocalDateTime reportDate){
        System.out.printf("%nStudent name: %s %n", student.getName());
        System.out.printf("Working time: from %d to %d %n", START_DAY_TIME, END_DAY_TIME);
        System.out.printf("Program name: %s %n", student.getCurriculum().getCurriculumName());
        System.out.printf("Program duration: From ( %s ) To ( %s ) %n", student.getCurriculum().getStartDate().format(formatter),
                student.getCurriculum().endDate().format(formatter));
        System.out.printf("Hours: %d %n", student.getCurriculum().curriculumLength());
        generateShortReport(student,reportDate);
    }
}

