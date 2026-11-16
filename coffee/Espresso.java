package coffee;

public class Espresso extends Coffee {

    public Espresso() {
        super("Espresso");
    }

    @Override
    protected int getBaseWater() {
        return 30;
    }

    @Override
    protected int getBaseCoffee() {
        return 9;
    }
}