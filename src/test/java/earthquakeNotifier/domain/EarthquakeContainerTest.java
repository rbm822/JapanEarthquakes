package earthquakeNotifier.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarthquakeContainerTest {
    Earthquake earthquake1 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake3 = new Earthquake("2022-10-17T09:33:00+09:00", 4.5, "2");

    EarthquakeContainer earthquakeContainer = new EarthquakeContainer();


    @BeforeEach
    void setUp() {
        earthquakeContainer.add(earthquake1);
        earthquakeContainer.add(earthquake2);
        earthquakeContainer.add(earthquake3);
    }

    // Ensures duplicate Earthquake objects are not added to the List.
    @Test
    void add() {
        assertEquals(2, earthquakeContainer.size());
    }
}
