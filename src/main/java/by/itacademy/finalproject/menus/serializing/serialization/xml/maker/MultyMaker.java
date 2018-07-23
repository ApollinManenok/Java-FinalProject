package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;
import org.w3c.dom.NodeList;

public interface MultyMaker<T> {
    T make(NodeList items) throws FutureDateTimeException;
}
