package earthquakeNotifier.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EarthquakeTest {
    Earthquake earthquake1 = new Earthquake("2022-11-16T09:33:00+09:00", 1.2, "4");
    Earthquake earthquake2 = new Earthquake("2022-11-17T09:33:00+09:00", 1.2, "4");

    @Test
    void isBefore() {
        assertTrue(earthquake1.isBefore(earthquake2));
    }

    @Test
    void isAfter() {
        assertTrue(earthquake2.isAfter(earthquake1));
    }
}