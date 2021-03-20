package lists;

import constructors.Curriculum;
import data.CurriculumData;

import static lists.CourseList.aqeCourseList;
import static lists.CourseList.javaDevCourseList;

public class CurriculumList {
    public static final Curriculum javaDeveloperCurriculum = Curriculum.builder()
            .courseList(javaDevCourseList)
            .curriculumName(CurriculumData.JAVA_DEVELOPER.name)
            .build();
    public static final Curriculum aqeCurriculum = Curriculum.builder()
            .courseList(aqeCourseList)
            .curriculumName(CurriculumData.AQE.name)
            .build();
}
