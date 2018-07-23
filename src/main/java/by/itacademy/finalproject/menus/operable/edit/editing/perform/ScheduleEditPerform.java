package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.domain.group.schedule.OverlapClassTimeComparator;
import by.itacademy.finalproject.domain.group.schedule.Schedule;
import by.itacademy.finalproject.domain.group.schedule.TimeOrderException;
import by.itacademy.finalproject.domain.group.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.group.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.inputable.LocalTimeInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.creator.ScheduleConsoleCreator;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@EntityType(type = "schedule")
public class ScheduleEditPerform implements EditPerform<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(ScheduleConsoleCreator.class.getName());
    private IntegerInput integerInput = new IntegerInput();
    private StringInput stringInput = new StringInput();
    private LocalTimeInput localTimeInput = new LocalTimeInput(DateTimeFormat.H_M_COLON.getFormat());

    @Edit(typo = "Add time period to schedule", name = "add")
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

    @Edit(typo = "Remove time period from schedule", name = "remove")
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
