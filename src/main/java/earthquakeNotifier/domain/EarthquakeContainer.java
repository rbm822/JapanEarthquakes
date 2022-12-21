package earthquakeNotifier.domain;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeContainer {
    private List<Earthquake> earthquakes;

    EarthquakeContainer() {
        this.earthquakes = new ArrayList<>();
    }

    public void add(Earthquake earthquake) {
        if (!earthquakes.contains(earthquake)) {
            earthquakes.add(earthquake);
        }
    }

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
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

    public int size() {
        return this.earthquakes.size();
    }
}
