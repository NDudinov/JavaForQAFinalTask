package unittest;

import lists.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tools.ReportGenerator;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReportGeneratorTest {
    
    @ParameterizedTest
    @DisplayName("Check short report")
    @CsvSource({
            "2020, 6, 10, 15, 0, Ivanov Ivan (Java Developer 0 d 5 hours have passed since the end.) - Training completed.",
            "2020, 5, 10, 15, 0, Ivanov Ivan (Java Developer) - Course wasn't started yet.",
            "2020, 6, 5, 15, 0, Ivanov Ivan (Java Developer 0 d 19 hours are left until the end.) - Training is not finished."
    })
    public void convertHoursTest(int year, int month, int day, int hour, int minute, String expectedReport) {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        ReportGenerator generator = new ReportGenerator();
        
        System.setOut(new java.io.PrintStream(out));
        generator.generateShortReport(StudentList.studentIvanovI, LocalDateTime.of(year, month, day, hour, minute));
       
        assertThat("Report is correct", out.toString().trim(), equalTo(expectedReport));
    }
}
