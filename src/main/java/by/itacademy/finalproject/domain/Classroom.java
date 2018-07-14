package by.itacademy.finalproject.domain;

public class Classroom {
    private String name;

    public Classroom() {
    }

    public Classroom(String name) {
        this.name = name;
    }

    public Classroom(Classroom classroom) {
        this.name = new String(classroom.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Classroom classroom = (Classroom) object;
        return name != null ? name.equals(classroom.name) : classroom.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
