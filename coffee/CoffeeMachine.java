package coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private static final int GRAMS_PER_SPOON = 5;

    private final List<Brewable> menu = List.of(new Espresso(), new Lungo(), new Americano());
    private final Ingredient water = new Ingredient("Water", "ml", 2000);
    private final Ingredient beans = new Ingredient("Coffee beans", "g", 200);
    private final Ingredient sugar = new Ingredient("Sugar", "g", 100);

    public List<Brewable> getMenu() {
        return menu;
    }

    public List<Ingredient> getStock() {
        return List.of(water, beans, sugar);
    }

    public int getSugarNeeded(int spoons) {
        return spoons * GRAMS_PER_SPOON;
    }

    public List<String> getShortages(Brewable drink, DrinkSize size, int spoons) {
        List<String> shortages = new ArrayList<>();
        if (!water.hasAtLeast(drink.getWaterNeeded(size))) {
            shortages.add(water.getName());
        }
        if (!beans.hasAtLeast(drink.getCoffeeNeeded(size))) {
            shortages.add(beans.getName());
        }
        if (!sugar.hasAtLeast(getSugarNeeded(spoons))) {
            shortages.add(sugar.getName());
        }
        return shortages;
    }

    public void brew(Brewable drink, DrinkSize size, int spoons) {
        if (!getShortages(drink, size, spoons).isEmpty()) {
            throw new IllegalStateException("Ingredients are not sufficient.");
        }
        water.use(drink.getWaterNeeded(size));
        beans.use(drink.getCoffeeNeeded(size));
        sugar.use(getSugarNeeded(spoons));
    }
}