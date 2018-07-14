package by.itacademy.finalproject.menuable;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menuable.operable.serialization.SchoolSerialization;
import by.itacademy.finalproject.menuable.operable.serialization.json.ReadLocalGson;
import by.itacademy.finalproject.menuable.operable.serialization.json.UploadRemoteJackson;
import by.itacademy.finalproject.menuable.operable.serialization.json.WriteLocalGson;
import by.itacademy.finalproject.menuable.operable.serialization.xml.ReadLocalXML;
import by.itacademy.finalproject.menuable.operable.serialization.xml.UploadRemoteXML;
import by.itacademy.finalproject.menuable.operable.serialization.xml.WriteLocalXML;

import java.io.File;
import java.util.ArrayList;

public class SerializationMenu implements Menuable {
    private ArrayList<SchoolSerialization> options = new ArrayList<>();

    public SerializationMenu(School school) {
        options.add(new WriteLocalXML(school, new File("School.xml")));//Xml read,write,upload
        options.add(new ReadLocalXML(school, new File("School.xml")));
        options.add(new UploadRemoteXML(school, "https://raw.githubusercontent.com/PManenok/Java-FinalProject-Text/master/School.xml"));
        options.add(new WriteLocalGson(school, new File("School.json")));
        options.add(new ReadLocalGson(school, new File("School.json")));
        options.add(new UploadRemoteJackson(school, "https://raw.githubusercontent.com/PManenok/Java-FinalProject-Text/master/School.json"));
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
        return "Serialize groups";
    }
}
