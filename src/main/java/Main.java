import earthquakeNotifier.logic.QuakePrinter;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        UserInterface ui = new UserInterface(scanner);
//        ui.start();
        QuakePrinter printer = new QuakePrinter();
        printer.testQuakes();
    }
}
