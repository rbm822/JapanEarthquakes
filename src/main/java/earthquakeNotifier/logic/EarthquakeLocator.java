package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.EarthquakeContainer;

public class EarthquakeLocator {
    private EarthquakeContainer earthquakes;

    public EarthquakeLocator(EarthquakeContainer earthquakes) {
        this.earthquakes = earthquakes;
    }

    public Earthquake findMaxMagnitude() {
        Earthquake earthquakeWithMaxMagnitude = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes.getEarthquakes()) {
            if (earthquake.getMagnitude() >= max) {
                max = earthquake.getMagnitude();
                earthquakeWithMaxMagnitude = earthquake;
            }
        }

        return earthquakeWithMaxMagnitude;
    }

    public Earthquake findMaxSeismicActivity() {
        Earthquake earthquakeWithMaxSeismicActivity = null;
        double max = 0.0;
        for (Earthquake earthquake : earthquakes.getEarthquakes()) {
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
