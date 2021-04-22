import dto.Student;
import lists.CurriculumList;
import lists.StudentList;
import lombok.SneakyThrows;
import tools.ReportGenerator;
import tools.TimeCalculator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.GeneralConstants.FULL_TIME_FORMATTER;
import static data.StudentData.IVANOV_I;
import static data.StudentData.SIDOROV_I;
import static tools.ReportGenerator.generateReport;
import static tools.TimeCalculator.readDate;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("Please input date of the report in format DD.MM.YYYY. Current time will be used for calculation of hours.");
        Scanner scanner = new Scanner(System.in);
        String dateOfReportAsString = scanner.nextLine();
        readDate(dateOfReportAsString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfReport = LocalDate.parse(dateOfReportAsString, formatter);
        LocalDateTime dateTimeOfReport = LocalDateTime.of(dateOfReport, LocalTime.now());
        System.out.println("Please input type of report you wish to see: 1 - short report, 2 - full report. " +
                "If you input anything else full report will be printed");

        String typeOfReport = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        students.add(StudentList.studentIvanovI.toBuilder()
                .curriculum(CurriculumList.javaDeveloperCurriculum.toBuilder()
                        .startDate(IVANOV_I.startDate)
                        .endDate(new TimeCalculator().calculateEndDate(IVANOV_I.startDate, CurriculumList.javaDeveloperCurriculum.curriculumLength()))
                        .build())
                .build());
        students.add(StudentList.studentSidorovI.toBuilder()
                .curriculum(CurriculumList.aqeCurriculum.toBuilder()
                        .startDate(SIDOROV_I.startDate)
                        .endDate(new TimeCalculator().calculateEndDate(SIDOROV_I.startDate, CurriculumList.aqeCurriculum.curriculumLength()))
                        .build())
                .build());

        if (typeOfReport.equals("1")) {
            System.out.printf("Short Report (Generating report date - %s):%n", dateTimeOfReport.format(FULL_TIME_FORMATTER));
        } else {
            System.out.printf("Full Report (Generating report date - %s):%n", dateTimeOfReport.format(FULL_TIME_FORMATTER));
        }
        for (Student student : students) {
            generateReport(typeOfReport, student, dateTimeOfReport);
        }
    }




}

