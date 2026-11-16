package coffee;

public abstract class Coffee implements Brewable {
    private final String name;

    protected Coffee(String name) {
        this.name = name;
    }

    protected abstract int getBaseWater();

    protected abstract int getBaseCoffee();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWaterNeeded(DrinkSize size) {
        return getBaseWater() * size.getMultiplier();
    }

    @Override
    public int getCoffeeNeeded(DrinkSize size) {
        return getBaseCoffee() * size.getMultiplier();
    }
}