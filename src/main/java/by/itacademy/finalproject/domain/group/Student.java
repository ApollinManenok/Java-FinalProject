package by.itacademy.finalproject.domain.group;

import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
    private String name;
    private LocalDate bDay;
    private Set<Payment> payments;

    public Student() {
    }

    public Student(String name, LocalDate bDay) throws FutureDateTimeException {
        this.name = name;
        if (bDay.isAfter(LocalDate.now()))
            throw new FutureDateTimeException("Date is in future!");
        this.bDay = bDay;
        this.payments = new HashSet<>();
    }

    public Student(String name, LocalDate bDay, Set<Payment> payments) {
        this.name = name;
        if (bDay.isAfter(LocalDate.now()))
            throw new FutureDateTimeException("Date is in future!");
        this.bDay = bDay;
        this.payments = payments;
    }

    public Student(Student student) {
        this.name = new String(student.name);
        this.bDay = LocalDate.of(student.bDay.getYear(), student.bDay.getMonth(), student.bDay.getDayOfMonth());
        this.payments = new TreeSet<>(new PaymentDateComparator());
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

    public boolean addPayment(Payment payment) {
        return payments.add(payment);
    }

    public boolean addAllPayments(Set<Payment> payments) {
        return payments.addAll(payments);
    }

    public boolean removePayment(Payment payment) {
        return payments.remove(payment);
    }

    public boolean removePaymentsBeforeDate(LocalDate date) {
        Set<Payment> temp = new HashSet<>();
        for (Payment payment : payments) {
            if (payment.getDate().isBefore(date))
                temp.add(payment);
        }
        return payments.removeAll(temp);
    }

    public void setbDay(LocalDate bDay) {
        if (bDay.isAfter(LocalDate.now()))
            throw new FutureDateTimeException("Date is in future!");
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
            buffer.append(payment).append(",  ");
        }
        return payments.isEmpty() ? ("Empty") : (buffer.delete(buffer.length() - 2, buffer.length()).toString());
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer(20);
        if (name.length() < 20) buffer.append(name).append("                    ".substring(0, 20 - name.length()));
        else buffer.append(name);
        return buffer.toString() + " Birthday " + DateTimeFormat.DD_MM_YYYY_DASH.getFormat().format(bDay) + "\tPayments: " + getPaymentsAsString();
    }
}
