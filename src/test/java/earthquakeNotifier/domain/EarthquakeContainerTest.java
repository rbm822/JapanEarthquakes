package earthquakeNotifier.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarthquakeContainerTest {
    Earthquake earthquake1 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake3 = new Earthquake("2022-10-17T09:33:00+09:00", 4.5, "2");
    Earthquake earthquake4 = new Earthquake("2022-12-17T09:33:00+09:00", 2.7, "3");
    Earthquake earthquake5 = new Earthquake("2022-09-17T11:45:00+09:00", 4.4, "5");
    EarthquakeContainer earthquakeContainer = new EarthquakeContainer();

    @Test
    void add() {
        earthquakeContainer.add(earthquake1);
        earthquakeContainer.add(earthquake2);
        assertEquals(1, earthquakeContainer.size());
    }

    @Test
    void findMaxMagnitude() {
        earthquakeContainer.add(earthquake3);
        earthquakeContainer.add(earthquake4);
        earthquakeContainer.add(earthquake5);

        assertEquals(4.5, earthquakeContainer.findMaxMagnitude());
    }
}