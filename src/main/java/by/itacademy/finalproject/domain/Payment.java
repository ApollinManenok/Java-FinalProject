package by.itacademy.finalproject.domain;

import by.itacademy.finalproject.domain.formatter.DateTimeFormat;

import java.time.LocalDate;

public class Payment {
    private LocalDate date;
    private int amount;

    public Payment() {
    }

    public Payment(LocalDate date, int amount) {
        this.date = date;
        this.amount = amount;
    }

    public Payment(Payment payment) {
        this.date = LocalDate.of(payment.date.getYear(), payment.date.getMonth(), payment.date.getDayOfMonth());
        this.amount = payment.amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return date.equals(payment.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    public String getDateAsString() {
        return DateTimeFormat.D_M_YYYY_DASH.getFormat().format(date);
    }

    @Override
    public String toString() {
        return DateTimeFormat.D_M_YYYY_DASH.getFormat().format(date) + " amount: " + amount;
    }
}
