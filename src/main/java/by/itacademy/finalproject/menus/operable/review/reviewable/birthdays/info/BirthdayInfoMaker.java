package by.itacademy.finalproject.menus.operable.review.reviewable.birthdays.info;

import by.itacademy.finalproject.menus.operable.review.reviewable.InfoMaker;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BirthdayInfoMaker<T> implements InfoMaker<BirthdayInfo, T> {
    private static final Logger LOGGER = Logger.getLogger(BirthdayInfo.class.getName());

    @Override
    public BirthdayInfo getInfo(T object) {
        try {
            LocalDate date = (LocalDate) object.getClass().getMethod("getbDay").invoke(object);
            String name = (String) object.getClass().getMethod("getName").invoke(object);
            String type = object.getClass().getSimpleName();
            return new BirthdayInfo(date, name, type);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return null;
    }
}
