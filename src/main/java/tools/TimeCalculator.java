package tools;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static data.GeneralConstants.DAY_LENGTH;

public class TimeCalculator {

    public long countWorkHoursBetween(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Invalid method argument(s) to countBusinessDaysBetween(" + startDate
                    + "," + endDate + ")");
        }

        Predicate<LocalDateTime> isWeekend = date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY;

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        long businessDays = Stream.iterate(startDate, date -> date.plusDays(1)).limit(daysBetween)
                .filter(isWeekend.negate()).count();
        return businessDays * DAY_LENGTH;
    }
    
    
}
