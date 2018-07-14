package by.itacademy.finalproject.menuable.operable.serialization.xml;


import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.menuable.operable.serialization.WriteGroups;
import by.itacademy.finalproject.menuable.operable.serialization.xml.element.SchoolRootFiller;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteLocalXML extends WriteGroups {
    private static final Logger LOGGER = Logger.getLogger(WriteLocalXML.class.getName());

    private Document document;

    public WriteLocalXML(School school, String source) {
        super(school, source);
    }

    public WriteLocalXML(School school, File file) {
        super(school, file);
    }

    @Override
    public void serialize() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Node root = document.createElement("School");
            document.appendChild(root);
            new SchoolRootFiller().fillRoot(document, root, getSchool());
            writeDoc();
        } catch (ParserConfigurationException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    private void writeDoc() {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileOutputStream(getFile()));
            transformer.transform(source, result);
        } catch (TransformerException | FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    @Override
    public String typo() {
        return "Write groups info into local XML file";
    }
}
