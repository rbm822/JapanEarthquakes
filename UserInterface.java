package earthquakes;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println("Japan Earthquake Notifier");
        System.out.println("*************************");
        System.out.println(
                "1. Display all earthquakes\n" +
                "2. Display Most Active Location");
        System.out.print("Please make your selection: ");

        String usersChoice = scanner.next();
        if (usersChoice.equals("1")) {
//            quakePrinter.print();
        }

        // TODO need to fix QuakePrinter
        if (usersChoice.equals("2")) {
//            quakePrinter.printMostActiveLocation();
        }


    }
}
