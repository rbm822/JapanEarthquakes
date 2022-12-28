package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.EarthquakeContainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarthquakeFinderTest {
    Earthquake earthquake1 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake3 = new Earthquake("2022-10-17T09:33:00+09:00", 4.5, "2");
    Earthquake earthquake4 = new Earthquake("2022-12-17T09:33:00+09:00", 2.7, "3");
    Earthquake earthquake5 = new Earthquake("2022-09-17T11:45:00+09:00", 2.4, "5");
    Earthquake earthquake6 = new Earthquake("2022-01-27T11:45:00+09:00", 4.4, "5+");
    EarthquakeContainer earthquakes = new EarthquakeContainer();

    @BeforeEach
    void setUp() {
        earthquakes.add(earthquake1);
        earthquakes.add(earthquake2);
        earthquakes.add(earthquake3);
        earthquakes.add(earthquake4);
        earthquakes.add(earthquake5);
        earthquakes.add(earthquake6);
    }

    @Test
    void findMaxMagnitude() {
        assertEquals(earthquake3, EarthquakeFinder.findMaxMagnitude(earthquakes.getEarthquakes()));
    }

    @Test
    void findMaxSeismicActivity() {
        assertEquals(earthquake6, EarthquakeFinder.findMaxSeismicActivity(earthquakes.getEarthquakes()));
    }
}