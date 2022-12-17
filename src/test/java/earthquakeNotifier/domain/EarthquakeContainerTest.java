package earthquakeNotifier.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarthquakeContainerTest {
    Earthquake earthquake1 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    EarthquakeContainer earthquakeContainer = new EarthquakeContainer();

    @Test
    void add() {
        earthquakeContainer.add(earthquake1);
        earthquakeContainer.add(earthquake2);
        assertEquals(1, earthquakeContainer.size());
    }
}