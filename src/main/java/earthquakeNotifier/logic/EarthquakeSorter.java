package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.EarthquakeContainer;

public class EarthquakeSorter {
    private EarthquakeContainer earthquakes;

    public EarthquakeSorter() {
        this.earthquakes = new EarthquakeContainer();
    }


    public EarthquakeContainer getRecentEarthquakes(int num) {
        for(Earthquake earthquake : earthquakes.getEarthquakes()) {
        }

        return earthquakes;
    }
}
