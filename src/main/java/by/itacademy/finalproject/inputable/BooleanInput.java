package by.itacademy.finalproject.inputable;

public class BooleanInput implements Inputable<Boolean> {
    @Override
    public Boolean getValue(String message) {
        System.out.print(message + "\n>>> ");
        boolean result = scan.nextBoolean();
        scan.nextLine();
        return result;
    }
}
