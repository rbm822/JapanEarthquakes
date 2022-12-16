package earthquakeNotifier.domain;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeContainer {
    private List<Earthquake> earthquakes;

    public EarthquakeContainer() {
        this.earthquakes = new ArrayList<>();
    }
}
