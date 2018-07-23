package by.itacademy.finalproject.menus.operable.edit.editing;

import by.itacademy.finalproject.inputable.StringInput;
import by.itacademy.finalproject.menus.operable.edit.creator.ScheduleConsoleCreator;
import by.itacademy.finalproject.menus.operable.edit.editing.perform.EditPerform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReflectiveEditor<T> implements Editor<T> {
    private static final Logger LOGGER = Logger.getLogger(ScheduleConsoleCreator.class.getName());
    private StringInput stringInput = new StringInput();
    private EditPerform<T> operator;
    private Map<String, Method> methods = new LinkedHashMap<>();
    private String entityT;

    public ReflectiveEditor(EditPerform<T> operator) {
        this.entityT = operator.getClass().getAnnotation(EntityType.class).type();
        this.operator = operator;
        Method[] tempMethods = operator.getClass().getDeclaredMethods();
        for (Method method : tempMethods) {
            if (method.isAnnotationPresent(Edit.class))
                methods.put(method.getAnnotation(Edit.class).name(), method);
        }
    }

    @Override
    public T edit(T object) {
        boolean term = false;
        boolean cancel;
        do {
            printMenu(object);
            String operationType = stringInput.getValue("\nEnter cases type").toLowerCase();
            cancel = edit(operationType, object);
            if (cancel) term = "Y".equalsIgnoreCase(stringInput.getValue("Continue editing " + entityT + " (Y/N)"));
        } while (cancel && term);
        if (!cancel) return null;
        return object;
    }

    private void printMenu(T object) {
        System.out.println(object + "\nTo cancel edition enter \"Cancel\"\nOperation types:");
        for (String name : methods.keySet()) {
            String str = methods.get(name).getAnnotation(Edit.class).typo();
            System.out.println(str + " (" + name + ")");
        }
    }

    private boolean edit(String name, T object) {
        if (name.equalsIgnoreCase("CANCEL")) return false;
        try {
            if ((boolean) methods.get(name).invoke(operator, object))
                System.out.println("Edition success\n");
            else System.out.println("Edition failure\n");
        } catch (IllegalAccessException | InvocationTargetException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
            System.out.println("There is no such cases");
        }
        return true;
    }
}
