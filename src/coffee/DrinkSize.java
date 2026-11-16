package coffee;

public enum DrinkSize {
    SMALL("Small", 1),
    MEDIUM("Medium", 2),
    LARGE("Large", 3);

    private final String label;
    private final int multiplier;

    DrinkSize(String label, int multiplier) {
        this.label = label;
        this.multiplier = multiplier;
    }

    public String getLabel() {
        return label;
    }

    public int getMultiplier() {
        return multiplier;
    }
}