import earthquakeNotifier.logic.EarthquakeFinder;
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
            System.out.println(EarthquakeFinder.findLocationWithMostEarthquakes(quakeLoader.getLocationsWithEarthquakes()));
//            System.out.println(EarthquakeFinder.findMaxSeismicActivity(quakeLoader.getEarthquakeList()));
//            for (Earthquake earthquake : quakeLoader.getEarthquakeList(0, 10)) {
//                System.out.println(earthquake);
//            }
//            for (Earthquake earthquake : quakeLoader.getEarthquakeList()) {
//                System.out.println(earthquake);
//            }
//            for (Location location : quakeLoader.getLocationsWithEarthquakes().values()) {
//                System.out.println(EarthquakeFinder.findMaxSeismicActivity(location.getEarthquakes()));
//                System.out.println("There have been " + location.getNumOfEarthquakes() +
//                        " earthquakes at " + location + ".");
//            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
