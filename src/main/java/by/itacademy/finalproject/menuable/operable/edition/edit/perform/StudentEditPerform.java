package by.itacademy.finalproject.menuable.operable.edition.edit.perform;

import by.itacademy.finalproject.domain.Payment;
import by.itacademy.finalproject.domain.Student;
import by.itacademy.finalproject.domain.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menuable.operable.edition.edit.Edit;
import by.itacademy.finalproject.menuable.operable.edition.edit.EntityType;
import by.itacademy.finalproject.menuable.operable.edition.edit.ReflectiveEditor;

import java.time.LocalDate;
import java.util.Set;

@EntityType(type = "student")
public class StudentEditPerform implements EditPerform<Student> {
    private StringInput stringInput = new StringInput();
    private LocalDateInput localDateInput = new LocalDateInput(DateTimeFormat.D_M_YYYY_DOT.getFormat());
    private ReflectiveEditor<Set<Payment>> editor = new ReflectiveEditor<>(new PaymentEditPerform());

    @Edit(typo = "Edit student's name", name = "name")
    public boolean editName(Student student) {
        System.out.println("Teacher current name \"" + student.getName() + "\"");
        String newName = stringInput.getValue("Enter new name");
        if (!student.getName().equals(newName)) {
            student.setName(newName);
            return true;
        }
        return false;
    }

    @Edit(typo = "Edit student's birthday", name = "birthday")
    public boolean editBirthday(Student student) {
        System.out.println("Teacher current birthday \"" + student.getbDay() + "\"");
        LocalDate newbDate = localDateInput.getValue("Enter new birth date(" + DateTimeFormat.D_M_YYYY_DOT + ")");
        if (!student.getbDay().equals(newbDate)) {
            student.setbDay(newbDate);
            return true;
        }
        return false;
    }

    @Edit(typo = "Edit student's payment history", name = "payments")
    public boolean editPayments(Student student) {
        Set<Payment> payments = editor.operate(student.getPayments());
        if (payments != null) {
            student.getPayments().clear();
            student.getPayments().addAll(payments);
            return true;
        }
        return false;
    }
}
