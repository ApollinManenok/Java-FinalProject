package by.itacademy.finalproject.menus.serializing.serialization.xml;


import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.menus.serializing.serialization.ReadGroups;
import by.itacademy.finalproject.menus.serializing.serialization.xml.maker.GroupMaker;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadLocalXML extends ReadGroups {
    private static final Logger LOGGER = Logger.getLogger(ReadLocalXML.class.getName());
    private GroupMaker maker = new GroupMaker();

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
            fill(groups);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private void fill(NodeList nodeList) {
        for (int i = 1; i < nodeList.getLength(); i += 2) {
            Group temp = maker.make(nodeList.item(i));
            if (getSchool().containsGroup(temp)) {
                getSchool().getGroup(temp).addAllSupplementStudents(temp.getStudents());
            }
            getSchool().addGroup(temp);
        }
    }

    @Override
    public String typo() {
        return "Read groups info from local XML file";
    }
}
