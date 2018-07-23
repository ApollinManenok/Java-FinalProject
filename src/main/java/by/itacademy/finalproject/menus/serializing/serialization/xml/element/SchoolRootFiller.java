package by.itacademy.finalproject.menus.serializing.serialization.xml.element;

import by.itacademy.finalproject.domain.School;
import by.itacademy.finalproject.domain.group.Group;
import by.itacademy.finalproject.menus.serializing.serialization.xml.element.creator.GroupElementCreator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.Set;

public class SchoolRootFiller {
    private GroupElementCreator groupElement;

    public void fillRoot(Document document, Node root, School school) {
        groupElement = new GroupElementCreator(document);
        Element schoolName = document.createElement("schoolName");
        schoolName.setTextContent(school.getName());
        root.appendChild(schoolName);
        Element groups = document.createElement("groups");
        fillGroups(school.getGroups(), groups);
        root.appendChild(groups);
    }

    private void fillGroups(Set<Group> groupsSet, Element groups) {
        for (Group group : groupsSet) {
            groups.appendChild(groupElement.create(group));
        }
    }
}
