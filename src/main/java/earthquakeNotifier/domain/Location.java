package earthquakeNotifier.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String getLocationName() {
        return locationName;
    }

    public String toString() {
        return locationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationName.equals(location.locationName) && earthquakes.equals(location.earthquakes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName, earthquakes);
    }
}
