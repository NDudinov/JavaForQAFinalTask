package data;

public enum CourseList {
    JAVA("Java", 16),
    JDBC("JDBC", 24),
    SPRING("Spring", 16),
    TEST_DESIGN("Test design", 10),
    PAGE_OBJECT("Page object", 16),
    SELENIUM("Selenium", 16);

    private final String name;
    private final int durationInHours;

    CourseList(String name, int durationInHours) {
        this.name = name;
        this.durationInHours = durationInHours;
    }
}
