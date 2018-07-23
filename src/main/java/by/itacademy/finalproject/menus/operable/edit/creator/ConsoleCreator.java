package by.itacademy.finalproject.menus.operable.edit.creator;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;

public interface ConsoleCreator<T> {
    T createInstance() throws FutureDateTimeException;
}
