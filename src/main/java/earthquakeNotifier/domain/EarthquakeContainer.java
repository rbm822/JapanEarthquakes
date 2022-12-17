package earthquakeNotifier.domain;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeContainer {
    private List<Earthquake> earthquakes;

    public EarthquakeContainer() {
        this.earthquakes = new ArrayList<>();
    }

    // TODO Needs to add earthquakes
    // TODO Needs to check for duplicates

    public void add(Earthquake earthquake) {
        earthquakes.add(earthquake);
    }
}
