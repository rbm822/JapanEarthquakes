package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.Location;

import java.util.List;
import java.util.Map;

public final class EarthquakeFinder {
    private EarthquakeFinder() {
    }

    // TODO All three of these methods are performing the same function...consider refactoring!
    public static Location findLocationWithMostEarthquakes(Map<String, Location> earthquakes) {
        Location locationWithMostEarthquakes = null;
        int highest = 0;
        for (Location location : earthquakes.values()) {
            if (location.getNumOfEarthquakes() >= highest) {
                highest = location.getNumOfEarthquakes();
                locationWithMostEarthquakes = location;
            }
        }

        return locationWithMostEarthquakes;
    }

    // TODO What to do with multiple "max" earthquakes?
    public static Earthquake findMaxMagnitude(List<Earthquake> earthquakes) {
        Earthquake earthquakeWithMaxMagnitude = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes) {
            if (earthquake.getMagnitude() >= max) {
                max = earthquake.getMagnitude();
                earthquakeWithMaxMagnitude = earthquake;
            }
        }

        return earthquakeWithMaxMagnitude;
    }

    // TODO What to do with multiple "max" earthquakes?
    public static Earthquake findMaxSeismicActivity(List<Earthquake> earthquakes) {
        Earthquake earthquakeWithMaxSeismicActivity = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes) {
            String strSeismicActivity = earthquake.getSeismicActivity();
            // Checks for occasional trailing "+".
            if (strSeismicActivity.contains("+")) {
                strSeismicActivity = strSeismicActivity.replace("+", ""); // Removes "+" if it exists.
            }
            double dblSeismicActivity = Double.parseDouble(strSeismicActivity);
            if (dblSeismicActivity >= max) {
                max = dblSeismicActivity;
                earthquakeWithMaxSeismicActivity = earthquake;
            }
        }

        return earthquakeWithMaxSeismicActivity;
    }
}