package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private String locationName;
    private List<Earthquake> earthquakes;

    public Location(String locationName) {
        this.locationName = locationName;
        this.earthquakes = new ArrayList<>();
    }

    public void addEarthquake(Earthquake earthquake) {
        this.earthquakes.add(earthquake);
    }

    public String toString() {
        return locationName;
    }
}
