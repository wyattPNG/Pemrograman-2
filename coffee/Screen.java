package coffee;

public abstract class Screen {
    private final Console console;

    protected Screen(Console console) {
        this.console = console;
    }

    public abstract String getTitle();

    protected abstract void render();

    public final void open() {
        console.show("");
        console.show("=== " + getTitle() + " ===");
        render();
    }

    protected void show(String text) {
        console.show(text);
    }

    protected int askNumber(String prompt, int min, int max) {
        return console.askNumber(prompt, min, max);
    }
}