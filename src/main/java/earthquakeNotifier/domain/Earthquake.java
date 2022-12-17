package earthquakeNotifier.domain;

import java.util.Objects;

public class Earthquake {
    private String time;
    private String seismicActivity;
    private String date;
    private double magnitude;

    /**
     * Incoming format of dates from JSON data is: "2022-11-17T09:33:00+09:00". The substrings in the constructor
     * separate the date and time in a readable format: Date: 2022-11-27 & Time: 09:33.
     * Seismic activity is a String because sometimes there is a trailing "+".
     */
    public Earthquake(String date, double magnitude, String seismicActivity) {
        this.date = date.substring(0, 10);
        this.time = date.substring(11, 16);
        this.magnitude = magnitude;
        this.seismicActivity = seismicActivity;
    }

    private String getDate() {
        return date;
    }

    private String getTime(){return time;}

    private double getMagnitude() {
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
