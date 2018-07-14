package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import org.w3c.dom.Element;

public interface ElementCreator<T> {
    Element create(T element);
}
