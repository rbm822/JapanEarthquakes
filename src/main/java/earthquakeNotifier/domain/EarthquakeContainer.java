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

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public Earthquake get(int num) {
        return earthquakes.get(num);
    }

    public void set(int index, Earthquake earthquake) {
        this.earthquakes.set(index, earthquake);
    }

    public int size() {
        return this.earthquakes.size();
    }

    public List<Earthquake> sublist(int fromIndex, int toIndex) {
        return this.earthquakes.subList(fromIndex, toIndex);
    }
}
