package tools;

import dto.Student;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

import static data.GeneralConstants.*;
import static java.lang.Math.abs;

public class ReportGenerator {

    private String covertHoursIntoDaysHoursForReport(long hours) {
        int daysForReport = (int) (abs(hours) / HOURS_IN_DAY);
        int leftHoursForReport = (int) (abs(hours) % HOURS_IN_DAY);
        String timeForReport;
        if (hours > 0) {
            timeForReport = String.format("%d d %d hours are left until the end.", daysForReport, leftHoursForReport);
        } else {
            timeForReport = String.format("%d d %d hours have passed since the end.", daysForReport, leftHoursForReport);
        }
        return timeForReport;
    }

    public void generateShortReport(Student student, LocalDateTime reportDate) {
        LocalDateTime startDate = student.getCurriculum().getStartDate();
        LocalDateTime endDate = student.getCurriculum().getEndDate();
        if (startDate != null && endDate != null) {
            TimeCalculator timeCalculator = new TimeCalculator();
            if (reportDate.isBefore(ChronoLocalDateTime.from(LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), END_DAY_TIME, 0)))) {
                if (reportDate.isAfter(ChronoLocalDateTime.from(LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), START_DAY_TIME, 0)))) {
                    long time = timeCalculator.calculateTimeRelativeToCurriculum(startDate, reportDate, student.getCurriculum().curriculumLength());
                    System.out.printf("%s (%s %s) - Training is not finished.%n", student.getName(), student.getCurriculum().getCurriculumName(), covertHoursIntoDaysHoursForReport(time));
                } else {
                    System.out.printf("%s (%s) - Course wasn't started yet.%n", student.getName(), student.getCurriculum().getCurriculumName());
                }
            } else {
                long time = timeCalculator.calculateTimeRelativeToCurriculum(startDate, reportDate, student.getCurriculum().curriculumLength());
                System.out.printf("%s (%s %s) - Training completed.%n", student.getName(), student.getCurriculum().getCurriculumName(), covertHoursIntoDaysHoursForReport(time));
            }
        } else {
            System.out.printf("%s (%s) - Not started any course.%n", student.getName(), student.getCurriculum().getCurriculumName());
        }
    }

    public void generateFullReport(Student student, LocalDateTime reportDate) {
        System.out.printf("%nStudent name: %s %n", student.getName());
        System.out.printf("Working time: from %d to %d %n", START_DAY_TIME, END_DAY_TIME);
        System.out.printf("Program name: %s %n", student.getCurriculum().getCurriculumName());
        System.out.printf("Program duration: From ( %s ) To ( %s ) %n", student.getCurriculum().getStartDate().format(FULL_TIME_FORMATTER),
                student.getCurriculum().getEndDate().format(FULL_TIME_FORMATTER));
        System.out.printf("Hours: %d %n", student.getCurriculum().curriculumLength());
        generateShortReport(student, reportDate);
    }

    public static void generateReport(String param, Student student, LocalDateTime reportDate) {
        ReportGenerator reportGenerator = new ReportGenerator();
        if (param.equals("1")) {
            reportGenerator.generateShortReport(student, reportDate);
        } else {
            reportGenerator.generateFullReport(student, reportDate);
        }
    }
}

