package earthquakeNotifier.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeContainerTest {
    Earthquake earthquake1 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake3 = new Earthquake("2022-10-17T09:33:00+09:00", 4.5, "2");
    Earthquake earthquake4 = new Earthquake("2022-12-17T09:33:00+09:00", 2.7, "3");
    Earthquake earthquake5 = new Earthquake("2022-09-17T11:45:00+09:00", 2.4, "5");
    Earthquake earthquake6 = new Earthquake("2022-01-27T11:45:00+09:00", 4.4, "5+");
    EarthquakeContainer earthquakeContainer = new EarthquakeContainer();


    @BeforeEach
    void setUp() {
        earthquakeContainer.add(earthquake1);
        earthquakeContainer.add(earthquake2);
        earthquakeContainer.add(earthquake3);
        earthquakeContainer.add(earthquake4);
        earthquakeContainer.add(earthquake5);
        earthquakeContainer.add(earthquake6);
    }

    // Ensures duplicate Earthquake objects are not added to the List.
    @Test
    void add() {
        assertEquals(5, earthquakeContainer.size());
    }

    @Test
    void findMaxMagnitude() {
        assertEquals(earthquake3, earthquakeContainer.findMaxMagnitude());
    }

    @Test
    void findMaxSeismicActivity() {
        assertEquals(earthquake6, earthquakeContainer.findMaxSeismicActivity());
    }

    @Test
    void sublist() {
        EarthquakeContainer earthquakeContainer1 = new EarthquakeContainer();
        earthquakeContainer1.add(earthquake1);
        earthquakeContainer1.add(earthquake2);
        earthquakeContainer1.add(earthquake3);

//        assertEquals(earthquakeContainer1, earthquakeContainer.sublist(0, 2));
    }
}
