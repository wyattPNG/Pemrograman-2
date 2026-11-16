package coffee;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);

    public void show(String text) {
        System.out.println(text);
    }

    public int askNumber(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // the message below is shown for non-numeric input too
            }
            show("Please enter a number between " + min + " and " + max + ".");
        }
    }
}