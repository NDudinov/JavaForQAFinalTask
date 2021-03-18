import constructors.Student;
import lists.CurriculumList;
import lists.StudentList;
import lombok.SneakyThrows;
import tools.ReportGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.StudentData.IVANOV_I;
import static data.StudentData.SIDOROV_I;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("Please input date of the report in format DD.MM.YYYY.");
        Scanner scanner = new Scanner(System.in);
        String dateOfReportAsString = scanner.nextLine();
        readDate(dateOfReportAsString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfReport = LocalDate.parse(dateOfReportAsString, formatter);
        System.out.println("Please input type of report you wish to see: 1 - short report, 2 - full report. " +
                "If you input anything else full report will be printed");
        
        String typeOfReport = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        students.add(StudentList.studentIvanovI.toBuilder()
                .curriculum(CurriculumList.javaDeveloperCurriculum.toBuilder().startDate(IVANOV_I.startDate).build())
                .build());
        students.add(StudentList.studentSidorovI.toBuilder()
                .curriculum(CurriculumList.javaDeveloperCurriculum.toBuilder().startDate(SIDOROV_I.startDate).build())
                .build());
        
        for (Student student:students) {
            generateReport(typeOfReport, student, LocalDateTime.of(dateOfReport,LocalTime.now()));
        }
    }

    private static void generateReport(String param, Student student, LocalDateTime reportDate){
        ReportGenerator reportGenerator = new ReportGenerator();
        if (param.equals("1")) {
            reportGenerator.generateShortReport(student, reportDate);
        } else reportGenerator.generateFullReport(student, reportDate);
    }
    
    private static LocalDateTime readDate(String dateOfReportAsString) throws IllegalArgumentException{
        String[] date = dateOfReportAsString.split("\\.");

        int day,month,year;

        day = Integer.parseInt(date[0]);
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Illegal day format. day should be in range [1; 31]");
        }

        month = Integer.parseInt(date[1]);
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Illegal month format. Month should be in range [1; 12]");
        }

        year = Integer.parseInt(date[2]);
        if (year < 1900 || year > 2100) {
            throw new IllegalArgumentException("Illegal year format. Year should be in range [1900; 2100]");
        }

        if (month == 2 && day > 28 && year % 4 != 0) {
            throw new IllegalArgumentException("This month have only 28 days");
        }
        else if (month == 2 && year % 4 == 0 && day > 29) {
            throw new IllegalArgumentException("This month have only 29 days");
        }

        if (month < 8) {
            if (month % 2 == 0 && day > 30 ) {
                throw new IllegalArgumentException("This month have only 30 days");
            }
        }
        else if (month % 2 == 1 && day > 30 ) {
            throw new IllegalArgumentException("This month have only 30 days");
        }
        return LocalDateTime.of(LocalDate.of(year, month, day),
                LocalTime.now());
    }
}

