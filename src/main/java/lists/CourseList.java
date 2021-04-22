package lists;

import dto.Course;

import java.util.Arrays;
import java.util.List;

import static data.CourseData.*;

public class CourseList {
    static final List<Course> javaDevCourseList = Arrays.asList(
            Course.builder()
                    .courseName(JAVA.name)
                    .durationInHours(JAVA.durationInHours)
                    .build(),
            Course.builder()
                    .courseName(JDBC.name)
                    .durationInHours(JDBC.durationInHours)
                    .build(),
            Course.builder()
                    .courseName(SPRING.name)
                    .durationInHours(SPRING.durationInHours)
                    .build()
    );
    static final List<Course> aqeCourseList = Arrays.asList(
            Course.builder()
                    .courseName(TEST_DESIGN.name)
                    .durationInHours(TEST_DESIGN.durationInHours)
                    .build(),
            Course.builder()
                    .courseName(PAGE_OBJECT.name)
                    .durationInHours(PAGE_OBJECT.durationInHours)
                    .build(),
            Course.builder()
                    .courseName(SELENIUM.name)
                    .durationInHours(SELENIUM.durationInHours)
                    .build()
    );
}
