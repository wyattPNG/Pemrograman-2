package coffee;

public class StockScreen extends Screen {
    private final CoffeeMachine machine;

    public StockScreen(Console console, CoffeeMachine machine) {
        super(console);
        this.machine = machine;
    }

    @Override
    public String getTitle() {
        return "Check Stock";
    }

    @Override
    protected void render() {
        for (Ingredient ingredient : machine.getStock()) {
            show(ingredient.toString());
        }
    }
}