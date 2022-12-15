package earthquakeNotifier.logic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.utils.APIConnection;

import java.util.ArrayList;
import java.util.List;

public class QuakeLoader {
    private JsonArray jsonArray;
    private List<Earthquake> earthquakes;

    public QuakeLoader(APIConnection connection) {
        this.jsonArray = new Gson().fromJson(connection.getHttpResponse().body(), JsonArray.class);
        this.earthquakes = new ArrayList<>();
        loadEarthquakes();
    }

    private void loadEarthquakes() {
        for (JsonElement element : jsonArray) {
            // Skips iteration if location or seismic activity is blank.
            if (isFieldNull(element, "en_anm") ||       // Location
                    isFieldNull(element, "maxi")) {     // Seismic activity
                continue;
            }

            String location = getLocation(element);
            String date = getDate(element);
            double magnitude = Double.parseDouble(getMagnitude(element));
            String seismicActivity = getSeismicActivity(element);
            Earthquake earthquake = new Earthquake(date, magnitude, seismicActivity);

            if (earthquakes.size() > 0 && isDuplicate(earthquakes, earthquake)) {
                continue;
            }

            earthquakes.add(earthquake);
        }
    }

    // TODO I want to be able to sort the locations by number of earthquakes

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    private boolean isDuplicate(List<Earthquake> earthquakes, Earthquake earthquake) {
        return earthquakes.get(earthquakes.size() - 1).equals(earthquake);
    }

    private boolean isFieldNull(JsonElement element, String field) {
        return element.getAsJsonObject().get(field).getAsString().isEmpty();
    }

    private String getLocation(JsonElement element) {
        return stripQuotes(element, "en_anm");
    }

    private String getDate(JsonElement element) {
        return stripQuotes(element, "rdt");
    }

    private String getMagnitude(JsonElement element) {
        return stripQuotes(element, "mag");
    }

    private String getSeismicActivity(JsonElement element) {
        return stripQuotes(element, "maxi");
    }

    private String stripQuotes(JsonElement element, String string) {
        return element.getAsJsonObject().get(string).toString()
                .replace("\"", "");
    }
}

// Iterate through the JSON data
// Get the location
// If it does not already exist, create it and add a new Earthquake
// If it does exist, add a new Earthquake
// When checking for the number of earthquakes, simply check for earthquakes.size()
