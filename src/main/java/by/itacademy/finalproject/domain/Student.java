package by.itacademy.finalproject.domain;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private LocalDate bDay;
    private Set<Payment> payments;

    public Student() {
    }

    public Student(String name, LocalDate bDay) {
        this.name = name;
        this.bDay = bDay;
        this.payments = new HashSet<>();
    }

    public Student(String name, LocalDate bDay, Set<Payment> payments) {
        this.name = name;
        this.bDay = bDay;
        this.payments = payments;
    }

    public Student(Student student) {
        this.name = new String(student.name);
        this.bDay = LocalDate.of(student.bDay.getYear(), student.bDay.getMonth(), student.bDay.getDayOfMonth());
        this.payments = new HashSet<>();
        for (Payment payment : student.payments) {
            payments.add(new Payment(payment));
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getbDay() {
        return bDay;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    public void removePaymentsBeforeDate(LocalDate date) {
        for (Payment payment : payments) {
            if (payment.getDate().isBefore(date))
                payments.remove(payment);
        }
    }

    public void setbDay(LocalDate bDay) {
        this.bDay = bDay;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Student student = (Student) object;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        return bDay != null ? bDay.equals(student.bDay) : student.bDay == null;
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

    public String getPaymentsAsString() {
        StringBuffer buffer = new StringBuffer();
        for (Payment payment : payments) {
            buffer.append(payment).append(", ");
        }
        return payments.isEmpty() ? ("Empty") : (buffer.delete(buffer.length() - 2, buffer.length()).toString());
    }

    @Override
    public String toString() {
        return name + " birthday " + bDay + " Payments: " + getPaymentsAsString();
    }
}
