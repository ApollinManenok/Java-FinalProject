package by.itacademy.finalproject.menuable.operable.serialization.xml.element;

import by.itacademy.finalproject.domain.Payment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.Set;

public class PaymentsElement implements ElementCreator<Set<Payment>> {
    private Document doc;

    public PaymentsElement(Document doc) {
        this.doc = doc;
    }

    public Element create(Set<Payment> elements) {
        Element docElement = doc.createElement("payments");
        for (Payment payment : elements) {
            Element paymentElement = doc.createElement("payment");
            paymentElement.appendChild(execute("date", payment.getDateAsString()));
            paymentElement.appendChild(execute("amount", String.valueOf(payment.getAmount())));
            docElement.appendChild(paymentElement);
        }
        return docElement;
    }

    private Element execute(String tag, String value) {
        Element element = doc.createElement(tag);
        element.setTextContent(value);
        return element;
    }
}
