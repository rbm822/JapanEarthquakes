package earthquakeNotifier.domain;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeContainer {
    private List<Earthquake> earthquakes;

    public EarthquakeContainer() {
        this.earthquakes = new ArrayList<>();
    }

    public void add(Earthquake earthquake) {
        if (!earthquakes.contains(earthquake)) {
            earthquakes.add(earthquake);
        }
    }

    // TODO What to do with multiple "max" earthquakes?
    public Earthquake findMaxMagnitude() {
        Earthquake earthquakeWithMaxMagnitude = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes) {
            if (earthquake.getMagnitude() > max) {
                max = earthquake.getMagnitude();
                earthquakeWithMaxMagnitude = earthquake;
            }
        }

        return earthquakeWithMaxMagnitude;
    }

    public Earthquake findMaxSeismicActivity() {
        Earthquake earthquakeWithMaxSeismicActivity = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes) {
            String strSeismicActivity = earthquake.getSeismicActivity();
            // Checks for occasional trailing "+".
            if (strSeismicActivity.contains("+")) {
                strSeismicActivity = strSeismicActivity.replace("+", ""); // Removes "+" if it exists.
            }
            double dblSeismicActivity = Double.parseDouble(String.valueOf(strSeismicActivity));
            if (dblSeismicActivity > max) {
                max = dblSeismicActivity;
                earthquakeWithMaxSeismicActivity = earthquake;
            }
        }

        return earthquakeWithMaxSeismicActivity;
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public int size() {
        return this.earthquakes.size();
    }
}
