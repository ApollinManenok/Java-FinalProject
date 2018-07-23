package by.itacademy.finalproject.menus.serializing.serialization.xml.maker;

import by.itacademy.finalproject.domain.group.FutureDateTimeException;
import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.PaymentDateComparator;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaymentsMaker implements MultyMaker<Set<Payment>> {
    private static final Logger LOGGER = Logger.getLogger(PaymentsMaker.class.getName());

    @Override
    public Set<Payment> make(NodeList item) {
        Set<Payment> payments = new TreeSet<>(new PaymentDateComparator());
        for (int i = 1; i < item.getLength(); i += 2) {
            NodeList params = item.item(i).getChildNodes();
            LocalDate date = LocalDate.parse(params.item(1).getTextContent(), DateTimeFormat.D_M_YYYY_DASH.getFormat());
            int amount = Integer.valueOf(params.item(3).getTextContent());
            addPayment(payments, date, amount);
        }
        return payments;
    }

    private void addPayment(Set<Payment> payments, LocalDate date, int amount) {
        try {
            payments.add(new Payment(date, amount));
        } catch (FutureDateTimeException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
