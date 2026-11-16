package coffee;

import java.util.List;

public class MakeCoffeeScreen extends Screen {
    private final CoffeeMachine machine;

    public MakeCoffeeScreen(Console console, CoffeeMachine machine) {
        super(console);
        this.machine = machine;
    }

    @Override
    public String getTitle() {
        return "Make Coffee";
    }

    @Override
    protected void render() {
        Brewable drink = chooseDrink();
        DrinkSize size = chooseSize();
        int spoons = chooseSugar();

        String order = size.getLabel() + " " + drink.getName() + " with " + spoons + " spoon(s) of sugar";
        show("You ordered: " + order);
        show("Needs " + drink.getWaterNeeded(size) + " ml water, "
                + drink.getCoffeeNeeded(size) + " g coffee, "
                + machine.getSugarNeeded(spoons) + " g sugar.");

        List<String> shortages = machine.getShortages(drink, size, spoons);
        if (!shortages.isEmpty()) {
            show("Cannot brew. Not enough: " + String.join(", ", shortages) + ".");
            return;
        }
        machine.brew(drink, size, spoons);
        show("Brewing complete. Enjoy your " + order + "!");
    }

    private Brewable chooseDrink() {
        List<Brewable> menu = machine.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            show((i + 1) + ". " + menu.get(i).getName());
        }
        return menu.get(askNumber("Choose a coffee: ", 1, menu.size()) - 1);
    }

    private DrinkSize chooseSize() {
        DrinkSize[] sizes = DrinkSize.values();
        for (int i = 0; i < sizes.length; i++) {
            show((i + 1) + ". " + sizes[i].getLabel());
        }
        return sizes[askNumber("Choose a size: ", 1, sizes.length) - 1];
    }

    private int chooseSugar() {
        show("1. No sugar");
        show("2. One spoon");
        show("3. Two spoons");
        return askNumber("Choose sugar: ", 1, 3) - 1;
    }
}