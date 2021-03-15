package tools;

import constructors.Student;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import static data.GeneralConstants.*;
import static java.lang.Math.abs;

public class ReportGenerator {

    private String covertHoursIntoDaysHoursForReport(long hours) {
        String daysForReport = String.valueOf((int) (abs(hours) / DAY_LENGTH));
        String leftHoursForReport = String.valueOf((int) (abs(hours) % DAY_LENGTH));
        String timeForReport = "%s d %s hours are left %s the end.";
        if (hours>0) {
            timeForReport = String.format(timeForReport, daysForReport, leftHoursForReport, "until");
        } else {
            timeForReport = String.format(timeForReport, daysForReport, leftHoursForReport, "since");
        }
        return timeForReport;
    }
    
    
    public void generateShortReport(Student student, LocalDateTime reportDate) {
        LocalDateTime startDate = student.getCurriculum().getStartDate();
        LocalDateTime endDate = student.getCurriculum().getEndDate();

        if (startDate != null && endDate != null){
            TimeCalculator timeCalculator = new TimeCalculator();
            if (reportDate.isBefore(endDate)){
                if (reportDate.isAfter(startDate)){
                    long time = timeCalculator.countWorkHoursBetween(startDate, reportDate);
                    System.out.printf("%s (%s) - Training is not finished. ", student.getName(), student.getCurriculum() + covertHoursIntoDaysHoursForReport(time));
                }
                else {
                    System.out.printf("%s (%s) - Course wasn't started yet.%n", student.getName(),student.getCurriculum());
                }
            }
            else {
                long time = timeCalculator.countWorkHoursBetween(startDate, reportDate);
                System.out.printf("%s (%s) - Training completed. ", student.getName(), student.getCurriculum() + covertHoursIntoDaysHoursForReport(time));
            }
        }
        else {
            System.out.printf("%s (%s) - Not started any course.%n", student.getName(), student.getCurriculum());
        }
    }

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy, EEEE, kk:mm");
    
    private void generateFullReport(Student student, LocalDateTime reportDate){
        System.out.printf("%nStudent name: %s%n", student.getName());
        System.out.printf("Working time: from %d to %d%n", START_DAY_TIME, END_DAY_TIME);
        System.out.printf("Program name: %s%n", student.getCurriculum());
        System.out.printf("Program duration: From ( %s ) To ( %s )%n", formatter.format(student.getCurriculum().getStartDate()),
                formatter.format(student.getCurriculum().getEndDate()));
        System.out.printf("Hours: %d%n", student.getCurriculum().curriculumLength());
        generateShortReport(student,reportDate);
    }
}

