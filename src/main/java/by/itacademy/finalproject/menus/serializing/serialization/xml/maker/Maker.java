package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import org.w3c.dom.Node;

public interface Maker<T> {
    T make(Node item);
}
