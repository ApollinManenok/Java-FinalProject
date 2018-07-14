package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Group;
import by.itacademy.finalproject.domain.School;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Set;

public class SchoolRootFiller {
    private GroupElement groupElement;

    public void fillRoot(Document document, Node root, School school) {
        groupElement = new GroupElement(document);
        Element schoolName = document.createElement("schoolName");
        schoolName.setTextContent(school.getName());
        root.appendChild(schoolName);
        Element groups = document.createElement("groups");
        fillGroups(school.getGroups(), groups);
        root.appendChild(groups);
    }

    private void fillGroups(Set<Group> groupsSet, Element groups) {
        for (Group element : groupsSet) {
            groups.appendChild(groupElement.create(element));
        }
    }
}
