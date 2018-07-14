package by.itacademy.finalproject.menuable.operable.serialization.xml.maker;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import org.w3c.dom.NodeList;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class PaymentsMaker implements MultyMaker<Set<Payment>> {
    public Set<Payment> make(NodeList item) {
        Set<Payment> payments = new HashSet<>();
        for (int i = 1; i < item.getLength(); i += 2) {
            NodeList params = item.item(i).getChildNodes();
            LocalDate date = LocalDate.parse(params.item(1).getTextContent(), DateTimeFormat.D_M_YYYY_DASH.getFormat());
            int amount = Integer.valueOf(params.item(3).getTextContent());
            payments.add(new Payment(date, amount));
        }
        return payments;
    }
}
