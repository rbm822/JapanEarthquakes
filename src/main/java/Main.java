import earthquakeNotifier.domain.Location;
import earthquakeNotifier.logic.QuakeLoader;
import earthquakeNotifier.utils.APIConnector;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        UserInterface ui = new UserInterface(scanner);
//        ui.start();
        try {
            APIConnector connector = new APIConnector("https://www.jma.go.jp/bosai/quake/data/list.json");
            QuakeLoader quakeLoader = new QuakeLoader(connector);
            for (Location location : quakeLoader.getLocationsWithEarthquakes().values()) {
                System.out.println(location.getEarthquakeWithMaxMagnitude());
//                System.out.println("There have been " + location.getNumOfEarthquakes() +
//                        " earthquakes at " + location + ".");
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
