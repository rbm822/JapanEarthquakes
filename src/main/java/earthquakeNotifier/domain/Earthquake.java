package earthquakeNotifier.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Earthquake {
    private DateTimeFormatter formatter;
    private LocalDateTime dateTime;
    private String seismicActivity;
    private double magnitude;

    /**
     * Seismic activity is a String because sometimes there is a trailing "+".
     */
    public Earthquake(String date, double magnitude, String seismicActivity) {
        this.formatter = DateTimeFormatter.ISO_DATE_TIME;
        this.dateTime = LocalDateTime.parse(date, formatter);
        this.magnitude = magnitude;
        this.seismicActivity = seismicActivity;
    }

    private LocalDate getDate() {
        return dateTime;
    }

    private LocalTime getTime() { return dateTime; }

    public double getMagnitude() {
        return magnitude;
    }

    public String getSeismicActivity() {
        return seismicActivity;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Date: ").append(getDate()).append("\n")
                .append("Time: ").append(getTime()).append("\n")
                .append("Magnitude: ").append(getMagnitude()).append("\n")
                .append("Seismic Activity: ").append(getSeismicActivity()).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earthquake that = (Earthquake) o;
        return Double.compare(that.magnitude, magnitude) == 0 && Objects.equals(time, that.time) && Objects.equals(seismicActivity, that.seismicActivity) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, seismicActivity, date, magnitude);
    }
}
