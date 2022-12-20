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

    public int size() {
        return this.earthquakes.size();
    }
}
