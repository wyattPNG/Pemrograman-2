package coffee;

public class Lungo extends Coffee {

    public Lungo() {
        super("Lungo");
    }

    @Override
    protected int getBaseWater() {
        return 60;
    }

    @Override
    protected int getBaseCoffee() {
        return 10;
    }
}