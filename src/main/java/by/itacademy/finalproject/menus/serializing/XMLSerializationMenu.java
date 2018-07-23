package by.itacademy.finalproject.menus.serializing;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.Menuable;
import by.itacademy.finalproject.menus.RangeException;
import by.itacademy.finalproject.menus.serializing.serialization.SchoolSerialization;
import by.itacademy.finalproject.menus.serializing.serialization.xml.ReadLocalXML;
import by.itacademy.finalproject.menus.serializing.serialization.xml.UploadRemoteXML;
import by.itacademy.finalproject.menus.serializing.serialization.xml.WriteLocalXML;

import java.io.File;
import java.util.ArrayList;

public class XMLSerializationMenu implements Menuable {
    private ArrayList<SchoolSerialization> options = new ArrayList<>();

    public XMLSerializationMenu(School school) {
        options.add(new WriteLocalXML(school, new File("School.xml")));
        options.add(new ReadLocalXML(school, new File("School.xml")));
        options.add(new UploadRemoteXML(school, "https://raw.githubusercontent.com/PManenok/Java-FinalProject-Text/master/School.xml"));
    }

    @Override
    public void list() throws RangeException {
        boolean term = true;
        while (term) {
            System.out.println("Menu list:\n0. Exit");
            for (int i = 0; i < options.size(); i++) {
                System.out.println(i + 1 + ". " + options.get(i).typo());
            }
            int index = new IntegerInput().getValue("Enter menu number");
            term = operate(index);
        }
    }

    private boolean operate(int index) throws RangeException {
        if (index < 0 || index > this.options.size())
            throw new RangeException("Index out of list range");
        else if (index == 0)
            return false;
        index -= 1;
        options.get(index).serialize();
        return true;
    }

    @Override
    public String typo() {
        return "XML groups serialization";
    }
}
