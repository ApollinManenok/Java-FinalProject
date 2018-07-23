package by.itacademy.finalproject.domain.group;

import by.itacademy.finalproject.domain.group.schedule.Schedule;

import java.util.Set;
import java.util.TreeSet;

public class Group {
    private String name;
    private Teacher teacher;
    private Classroom classroom;
    private Schedule schedule;
    private Set<Student> students;

    public Group() {
    }

    public Group(String name, Teacher teacher, Classroom classroom, Schedule schedule, Set<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.classroom = classroom;
        this.schedule = schedule;
        this.students = students;
    }

    public Group(Group group) {
        this.name = new String(group.name);
        this.teacher = new Teacher(group.teacher);
        this.classroom = new Classroom(group.classroom);
        this.schedule = new Schedule(group.schedule);
        this.students = new TreeSet<>(new StudentNameComparator());
        for (Student student : group.students) {
            students.add(new Student(student));
        }
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean addStudent(Student student) {
        return this.students.add(student);
    }

    public boolean addAllStudents(Set<Student> students) {
        return this.students.addAll(students);
    }

    public void addAllSupplementStudents(Set<Student> students) {
        for (Student student : students) {
            if (this.students.contains(student)) {
                getStudent(student).addAllPayments(student.getPayments());
            }
            this.students.add(student);
        }
    }

    public void addSupplementStudent(Student student) {
        if (this.students.contains(student)) {
            getStudent(student).addAllPayments(student.getPayments());
        }
        this.students.add(student);
    }

    public Student getStudent(Student student) {
        for (Student temp : students) {
            if (temp.equals(student))
                return temp;
        }
        return null;
    }

    public Student getStudentByName(String name) {
        for (Student temp : students) {
            if (temp.getName().equals(name))
                return temp;
        }
        return null;
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Group other = (Group) object;

        if (name.equals(other.name)) return true;
        return schedule.equals(other.schedule) && (classroom.equals(other.classroom) || (teacher.equals(other.teacher)));
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getStudentsAsString() {
        StringBuffer buffer = new StringBuffer();
        for (Student student : students) {
            buffer.append("\n\t").append(student);
        }
        buffer.append("\n");
        return students.isEmpty() ? ("Empty") : (buffer.toString());
    }

    @Override
    public String toString() {
        return "Group name " + name +
                "\nTeacher: " + teacher +
                "\nClassroom: " + classroom +
                "\nSchedule: " + schedule.getTimetableAsString() +
                "\nStudents: " + getStudentsAsString() + "\n";
    }
}
