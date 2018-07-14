package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.schedule.Schedule;
import by.itacademy.finalproject.domain.schedule.TimeOverlapException;
import by.itacademy.finalproject.domain.schedule.TimePeriod;
import by.itacademy.finalproject.menuable.operable.edition.create.ScheduleConsoleCreator;
import org.w3c.dom.Node;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SheduleMaker implements Maker<Schedule> {
    private static final Logger LOGGER = Logger.getLogger(SheduleMaker.class.getName());

    public Schedule make(Node item) {
        Schedule schedule = new Schedule();
        String[] periods = item.getTextContent().split(", ");
        for (String period : periods) {
            try {
                schedule.addTime(new TimePeriod(period));
            } catch (TimeOverlapException e) {
                LOGGER.log(Level.WARNING, e.getMessage(), e);
            }
        }
        return schedule;
    }
}
