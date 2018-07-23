package by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator;

import org.w3c.dom.Element;

public interface ElementCreator<T> {
    Element create(T element);
}
