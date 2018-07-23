package by.itacademy.finalproject.menus.operable.edit.editing.perform;

import by.itacademy.finalproject.domain.group.Payment;
import by.itacademy.finalproject.domain.group.Student;
import by.itacademy.finalproject.domain.group.formatter.DateTimeFormat;
import by.itacademy.finalproject.inputable.LocalDateInput;
import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.editing.Edit;
import by.itacademy.finalproject.menus.operable.edit.editing.EntityType;
import by.itacademy.finalproject.menus.operable.edit.editing.ReflectiveEditor;

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
        Set<Payment> payments = editor.edit(student.getPayments());
        if (payments != null) {
            student.getPayments().clear();
            student.getPayments().addAll(payments);
            return true;
        }
        return false;
    }
    @Edit(typo = "Clear student's payment history before date", name = "clear")
    public boolean clearPayments(Student student) {
        LocalDate date = localDateInput.getValue("Enter date before which you want to clear payments ("
                + DateTimeFormat.D_M_YYYY_DOT + ")");
        return student.removePaymentsBeforeDate(date);
    }
}
