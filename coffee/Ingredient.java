package coffee;

public class Ingredient {
    private final String name;
    private final String unit;
    private final int capacity;
    private int amount;

    public Ingredient(String name, String unit, int capacity) {
        this.name = name;
        this.unit = unit;
        this.capacity = capacity;
        this.amount = capacity;
    }

    public String getName() {
        return name;
    }

    public boolean hasAtLeast(int required) {
        return amount >= required;
    }

    public void use(int required) {
        if (!hasAtLeast(required)) {
            throw new IllegalStateException("Not enough " + name + ".");
        }
        amount -= required;
    }

    @Override
    public String toString() {
        String warning = amount * 5 <= capacity ? " (LOW)" : "";
        return name + ": " + amount + "/" + capacity + " " + unit + warning;
    }
}