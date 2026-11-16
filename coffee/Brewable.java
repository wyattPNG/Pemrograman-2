package coffee;

public interface Brewable {
    String getName();

    int getWaterNeeded(DrinkSize size);

    int getCoffeeNeeded(DrinkSize size);
}