package lists;

import constructors.Curriculum;
import data.CurriculumData;

import static lists.CourseList.aqeCourseList;
import static lists.CourseList.javaDevCourseList;

public class CurriculumList {
    static Curriculum javaDeveloperCurriculum = Curriculum.builder()
            .courseList(javaDevCourseList)
            .curriculum(CurriculumData.JAVA_DEVELOPER.name)
            .build();
    static Curriculum aqeCurriculum = Curriculum.builder()
            .courseList(aqeCourseList)
            .curriculum(CurriculumData.AQE.name)
            .build();
}
