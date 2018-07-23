package by.itacademy.finalproject.domain;

import by.itacademy.finalproject.domain.group.Group;

import java.util.HashSet;
import java.util.Set;

public class School {
    private String name;
    private Set<Group> groups;

    public School() {
        groups = new HashSet<>();
    }

    public School(String name) {
        this.name = name;
        this.groups = new HashSet<>();
    }

    public School(String name, Set<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public boolean addGroup(Group group) {
        return groups.add(group);
    }

    public boolean addAllGroups(Set<Group> groups) {
        return this.groups.addAll(groups);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    public boolean containsGroupWithName(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return groups.isEmpty();
    }

    public void clear() {
        groups.clear();
    }

    public Group getGroup(Group group) {
        for (Group temp : groups) {
            if (temp.equals(group)) return temp;
        }
        return null;
    }

    public Group getGroupByName(String name) {
        for (Group group : groups) {
            if (group.getName().equals(name)) return group;
        }
        return null;
    }

    public boolean removeGroup(Group group) {
        return groups.remove(group);
    }

    public boolean removeAllGroups(Set<Group> groups) {
        return this.groups.removeAll(groups);
    }

    public String getGroupsAsString() {
        StringBuffer buffer = new StringBuffer();
        for (Group group : groups) {
            buffer.append(group);
        }
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "School name " + name + "\nGroups: \n" + getGroupsAsString();
    }
}
