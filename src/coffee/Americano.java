package coffee;

public class Americano extends Coffee {

    public Americano() {
        super("Americano");
    }

    @Override
    protected int getBaseWater() {
        return 120;
    }

    @Override
    protected int getBaseCoffee() {
        return 9;
    }
}