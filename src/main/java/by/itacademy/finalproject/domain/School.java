package by.itacademy.finalproject.domain;

import java.util.HashSet;
import java.util.Set;

public class School {
    private String name;
    private Set<Group> groups;

    public School() {
        groups = new HashSet<Group>();
    }

    public School(String name) {
        this.name = name;
        this.groups = new HashSet<Group>();
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

    public void addGroup(Group group) {
        groups.add(group);
    }

    public void addAllGroups(Set<Group> groups) {
        this.groups.addAll(groups);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public void removeAllGroups(Set<Group> groups) {
        this.groups.removeAll(groups);
    }

    private String getGroupsAsString() {
        StringBuffer buffer = new StringBuffer();
        for (Group group : groups) {
            buffer.append(group).append("\n");
        }
        return buffer.toString();
    }

    @Override
    public String toString() {
        return "School name " + name + "\nGroups: \n" + getGroupsAsString();
    }
}
