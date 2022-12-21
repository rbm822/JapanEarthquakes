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

    public double getMaxMagnitude() {
        double max = 0.0;
        for (Earthquake earthquake : earthquakes) {
            if (earthquake.getMagnitude() > max) {
                max = earthquake.getMagnitude();
            }
        }

        return max;
    }

    public int size() {
        return this.earthquakes.size();
    }
}
