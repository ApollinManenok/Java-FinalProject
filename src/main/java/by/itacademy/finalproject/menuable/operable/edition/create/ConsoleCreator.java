package by.itacademy.finalproject.menuable.operable.edition.create;

import by.itacademy.finalproject.domain.FutureDateTimeException;

public interface ConsoleCreator<T> {
    T createInstance() throws FutureDateTimeException;
}
