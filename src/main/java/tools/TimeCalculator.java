package tools;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static data.GeneralConstants.*;

public class TimeCalculator {

    public long countWeekendHoursBetweenDates(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Invalid method argument(s) to countBusinessDaysBetween(" + startDate
                    + "," + endDate + ")");
        }

        Predicate<LocalDateTime> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        long weekendDays = Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween)
                .filter(isWeekend).count();
        return weekendDays * HOURS_IN_DAY;
    }

    public long calculateTimeRelativeToCurriculum(LocalDateTime startDate, LocalDateTime reportDate, int curriculumDuration) {

        Duration durationBetween = Duration.between(startDate, reportDate);
        long hoursBetween = durationBetween.toHours();
        long weekendHours = countWeekendHoursBetweenDates(startDate, reportDate);

        int spentHoursLastDay;
        if (reportDate.getHour() < START_DAY_TIME) {
            spentHoursLastDay = 0;
        } else {
            if (reportDate.getHour() > END_DAY_TIME) {
                spentHoursLastDay = WORK_DAY_LENGTH;
            } else {
                spentHoursLastDay = reportDate.getHour() - START_DAY_TIME;
            }
        }
        long passedFullWorkDays = (hoursBetween - weekendHours) / HOURS_IN_DAY * WORK_DAY_LENGTH;
        
        return curriculumDuration - passedFullWorkDays - spentHoursLastDay;
    }

    public LocalDateTime calculateEndDate(LocalDateTime firstDate, int duration) {
        if (duration < 1) {
            return firstDate;
        }
        LocalDateTime result = firstDate;
        int addedHours = 0;
        while (addedHours < duration) {
            result = result.plusHours(1);
            if (result.getHour() > END_DAY_TIME) {
                result = result.plusDays(1);
                result = result.minusHours(WORK_DAY_LENGTH);
            }
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedHours;
            }
        }
        return result;
    }
}
