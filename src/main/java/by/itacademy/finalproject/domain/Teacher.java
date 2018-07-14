package by.itacademy.finalproject.domain;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;

import java.time.LocalDate;

public class Teacher {
    private String name;
    private LocalDate bDay;

    public Teacher() {

    }

    public Teacher(String fullName, LocalDate bDay) {
        this.name = fullName;
        this.bDay = bDay;
    }

    public Teacher(Teacher teacher) {
        this.name = new String(teacher.name);
        this.bDay = LocalDate.of(teacher.bDay.getYear(), teacher.bDay.getMonth(), teacher.bDay.getDayOfMonth());
    }

    public String getName() {
        return name;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (!name.equals(teacher.name)) return false;
        return bDay.equals(teacher.bDay);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (bDay != null ? bDay.hashCode() : 0);
        return result;
    }

    public String getBirthdayAsString() {
        return DateTimeFormat.D_M_YYYY_DASH.getFormat().format(bDay);
    }

    @Override
    public String toString() {
        return name + " birthday " + bDay;
    }
}
