package coffee;

import java.util.List;

public class CoffeeApp {
    private final Console console = new Console();
    private final List<Screen> screens;

    public CoffeeApp() {
        CoffeeMachine machine = new CoffeeMachine();
        screens = List.of(
                new MakeCoffeeScreen(console, machine),
                new StockScreen(console, machine)
        );
    }

    public void run() {
        int exitOption = screens.size() + 1;
        while (true) {
            printMenu(exitOption);
            int choice = console.askNumber("Choose a menu: ", 1, exitOption);
            if (choice == exitOption) {
                console.show("Machine turned off. Goodbye!");
                return;
            }
            screens.get(choice - 1).open();
        }
    }

    private void printMenu(int exitOption) {
        console.show("");
        console.show("COFFEE MACHINE MAIN MENU");
        for (int i = 0; i < screens.size(); i++) {
            console.show((i + 1) + ". " + screens.get(i).getTitle());
        }
        console.show(exitOption + ". Exit");
    }
}