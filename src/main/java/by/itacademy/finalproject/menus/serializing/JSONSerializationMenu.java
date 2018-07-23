package by.itacademy.finalproject.menus.serializing;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.inputable.IntegerInput;
import by.itacademy.finalproject.menus.Menuable;
import by.itacademy.finalproject.menus.RangeException;
import by.itacademy.finalproject.menus.serializing.serialization.SchoolSerialization;
import by.itacademy.finalproject.menus.serializing.serialization.json.ReadLocalGson;
import by.itacademy.finalproject.menus.serializing.serialization.json.UploadRemoteJackson;
import by.itacademy.finalproject.menus.serializing.serialization.json.WriteLocalGson;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSONSerializationMenu implements Menuable {
    private static final Logger LOGGER = Logger.getLogger(JSONSerializationMenu.class.getName());
    private ArrayList<SchoolSerialization> options = new ArrayList<>();

    public JSONSerializationMenu(School school) {
        options.add(new WriteLocalGson(school, new File("School.json")));
        options.add(new ReadLocalGson(school, new File("School.json")));
        try {
            options.add(new UploadRemoteJackson(school, new URL("https://raw.githubusercontent.com/PManenok/Java-FinalProject-Text/master/School.json")));
        } catch (MalformedURLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
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
        return "JSON groups serialization";
    }
}
