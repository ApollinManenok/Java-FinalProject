package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.domain.schedule.TimeOrderException;
import by.itacademy.finalproject.domain.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.inputable.LocalTimeInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.serialization.xml.ReadLocalXML;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleConsoleCreator implements ConsoleCreator<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(ScheduleConsoleCreator.class.getName());
    private LocalTimeInput localTimeInput = new LocalTimeInput(DateTimeFormat.H_M_COLON.getFormat());
    private IntegerInput integerInput = new IntegerInput();
    private StringInput stringInput = new StringInput();

    @Override
    public Schedule createInstance() {
        Schedule schedule = new Schedule();
        boolean term;
        do {
            try {
                schedule.addTime(createClassTime());
            } catch (TimeOverlapException | TimeOrderException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
            term = "Y".equalsIgnoreCase(stringInput.getValue("Do you want to add class time? (true/false)"));
        } while (term);
        return schedule;
    }

    private TimePeriod createClassTime() throws TimeOrderException {
        DayOfWeek day = DayOfWeek.of(integerInput.getValue("Enter day of week number"));
        LocalTime begin = localTimeInput.getValue("Enter begin time (" + DateTimeFormat.H_M_COLON + ")");
        LocalTime end = localTimeInput.getValue("Enter end time (" + DateTimeFormat.H_M_COLON + ")");
        return new TimePeriod(day, begin, end);
    }
}
