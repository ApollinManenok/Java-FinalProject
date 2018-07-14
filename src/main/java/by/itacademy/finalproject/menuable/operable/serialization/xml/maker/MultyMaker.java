package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import org.w3c.dom.NodeList;

public interface MultyMaker<T> {
    T make(NodeList items);
}
