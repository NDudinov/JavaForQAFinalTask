package data;

import java.time.format.DateTimeFormatter;

public class GeneralConstants {
    public static final int START_DAY_TIME = 10;
    public static final int END_DAY_TIME = 18;
    public static final int WORK_DAY_LENGTH = 8;
    public static final int MILISECONDS_IN_HOUR = 1000 * 60 * 60;
    public static final int WORK_HOURS_IN_WEEK = WORK_DAY_LENGTH * 5;
    public static final int HOURS_IN_DAY = 24;
    public static final int DAYS_IN_WEEK = 7;
    public static final DateTimeFormatter FULL_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd MMMM yyyy, EEEE, kk:mm");
}
