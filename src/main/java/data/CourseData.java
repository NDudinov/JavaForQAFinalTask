package data;

public enum CourseData {
    JAVA("Java", 16),
    JDBC("JDBC", 24),
    SPRING("Spring", 16),
    TEST_DESIGN("Test design", 10),
    PAGE_OBJECT("Page object", 16),
    SELENIUM("Selenium", 16);

    public final String name;
    public final int durationInHours;

    CourseData(String name, int durationInHours) {
        this.name = name;
        this.durationInHours = durationInHours;
    }
}
