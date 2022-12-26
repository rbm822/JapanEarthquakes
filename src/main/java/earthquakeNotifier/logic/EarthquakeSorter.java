package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.EarthquakeContainer;

public class EarthquakeSorter {
    private EarthquakeContainer earthquakes;

    public EarthquakeSorter() {
        this.earthquakes = new EarthquakeContainer();
    }

    public void sortEarthquakesByDate(EarthquakeContainer earthquakes) {
        boolean isSorted = false;
        for (int i = 0; i < earthquakes.size() - 1; i++) {
            Earthquake tempQuake = earthquakes.get(i);
            if (earthquakes.get(i).isBefore(earthquakes.get(i + 1))) {
                tempQuake = earthquakes.get(i);
                earthquakes.set(i, earthquakes.get(i + 1));
                earthquakes.set(i + 1, tempQuake);
            }
        }
    }
}
