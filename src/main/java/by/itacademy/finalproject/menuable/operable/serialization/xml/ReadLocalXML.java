package by.itacademy.finalproject.menuable.operable.serialization.xml;


import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menuable.operable.serialization.ReadGroups;
import by.itacademy.finalproject.menuable.operable.serialization.xml.maker.GroupMaker;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalXML extends ReadGroups {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalXML.class.getName());

    public ReadLocalXML(School school, String source) {
        super(school, source);
    }

    public ReadLocalXML(School school, File file) {
        super(school, file);
    }

    @Override
    public void serialize() {
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getFile());
            NodeList schoolParams = document.getDocumentElement().getChildNodes();
            getSchool().setName(schoolParams.item(1).getTextContent());
            NodeList groups = schoolParams.item(3).getChildNodes();
            for (int i = 1; i < groups.getLength(); i += 2) {
                getSchool().getGroups().add(new GroupMaker().make(groups.item(i)));
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        } catch (DateTimeParseException | InputMismatchException e) {
            LOGGER.log(Level.SEVERE, "Wrong group info from file " + getFile(), e);
        }
    }

    @Override
    public String typo() {
        return "Read groups info from local XML file";
    }
}
