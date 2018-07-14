package by.itacademy.finalproject.menuable.operable.edition.edit.perform;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.domain.schedule.OverlapClassTimeComparator;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.domain.schedule.TimeOrderException;
import by.itacademy.finalproject.domain.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.inputable.LocalTimeInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.edition.create.ScheduleConsoleCreator;
import by.itacademy.finalproject.menuable.operable.edition.edit.Edit;
import by.itacademy.finalproject.menuable.operable.edition.edit.EntityType;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@EntityType(type = "scheduled")
public class ScheduleEditPerform implements EditPerform<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(ScheduleConsoleCreator.class.getName());
    private IntegerInput integerInput = new IntegerInput();
    private StringInput stringInput = new StringInput();
    private LocalTimeInput localTimeInput = new LocalTimeInput(DateTimeFormat.H_M_COLON.getFormat());

    @Edit(typo = "Add time period to scheduled", name = "add")
    public boolean addTime(Schedule schedule) {
        TimePeriod timePeriod;
        try {
            timePeriod = getTime();
            schedule.addTime(timePeriod);
            return true;
        } catch (TimeOrderException | TimeOverlapException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            System.out.println("New time overlap existing timetable");
        }
        return false;
    }

    @Edit(typo = "Remove time period from scheduled", name = "remove")
    public boolean removeTime(Schedule schedule) {
        Set<TimePeriod> temp = getRemovable(schedule);
        if (!temp.isEmpty()) {
            schedule.getTimetable().removeAll(temp);
            return true;
        }
        return false;
    }

    private Set<TimePeriod> getRemovable(Schedule schedule) {
        Set<TimePeriod> temp = new TreeSet<>(new OverlapClassTimeComparator());
        for (TimePeriod period : schedule.getTimetable()) {
            System.out.println(period);
            if ("Y".equalsIgnoreCase(stringInput.getValue("Do you wan't to remove this time? (Y/N)"))) {
                temp.add(period);
            }
        }
        return temp;
    }

    private TimePeriod getTime() throws TimeOrderException {
        DayOfWeek day = DayOfWeek.of(integerInput.getValue("Enter day of week number"));
        LocalTime begin = localTimeInput.getValue("Enter begin time (" + DateTimeFormat.H_M_COLON + ")");
        LocalTime end = localTimeInput.getValue("Enter end time");
        return new TimePeriod(day, begin, end);
    }
}
