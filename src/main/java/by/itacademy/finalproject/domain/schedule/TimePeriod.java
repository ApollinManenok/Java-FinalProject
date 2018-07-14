package by.itacademy.finalproject.domain.schedule;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimePeriod {
    private DayOfWeek dayOfWeek;
    private LocalTime begin;
    private LocalTime end;

    public TimePeriod(DayOfWeek dayOfWeek, LocalTime begin, LocalTime end) throws TimeOrderException {
        if (begin.isAfter(end))
            throw new TimeOrderException("Begin time is after End time");
        this.dayOfWeek = dayOfWeek;
        this.begin = begin;
        this.end = end;
    }

    public TimePeriod(String period) {
        String[] properties = period.replace(" - ", " ").split(" ");
        this.dayOfWeek = DayOfWeek.valueOf(properties[0].toUpperCase());
        this.begin = LocalTime.parse(properties[1], DateTimeFormat.H_M_COLON.getFormat());
        this.end = LocalTime.parse(properties[2], DateTimeFormat.H_M_COLON.getFormat());
    }

    public TimePeriod(TimePeriod period) {
        this.dayOfWeek = period.dayOfWeek;
        this.begin = LocalTime.of(period.begin.getHour(), period.begin.getMinute());
        this.end = LocalTime.of(period.end.getHour(), period.end.getMinute());
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getBegin() {
        return begin;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + begin + " - " + end;
    }
}
