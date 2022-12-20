import earthquakeNotifier.utils.EarthquakeConnector;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        UserInterface ui = new UserInterface(scanner);
//        ui.start();
        EarthquakeConnector printer = new EarthquakeConnector();
        printer.testQuakes();
    }
}
