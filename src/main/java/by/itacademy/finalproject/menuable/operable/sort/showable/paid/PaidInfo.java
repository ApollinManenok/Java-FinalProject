package by.itacademy.finalproject.menuable.operable.sort.showable.paid;

public class PaidInfo {
    private String name;
    private boolean previous;
    private boolean current;

    public PaidInfo(String name, boolean previous, boolean current) {
        this.name = name;
        this.previous = previous;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public boolean isPrevious() {
        return previous;
    }

    public boolean isCurrent() {
        return current;
    }
}
