package earthquakeNotifier.logic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.utils.APIConnection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuakeLoader {
    private JsonArray jsonArray;
    private Map<String, Location> earthquakeMap;

    public QuakeLoader(APIConnection connection) {
        this.jsonArray = new Gson().fromJson(connection.getHttpResponse().body(), JsonArray.class);
        this.earthquakeMap = new HashMap<>();
        buildListOfEarthquakes();
    }

    protected void buildListOfEarthquakes() {
        for (JsonElement element : jsonArray) {
            // Skips iteration if location or seismic activity is blank.
            if (isFieldNull(element, "en_anm") ||       // Location
                    isFieldNull(element, "maxi")) {     // Seismic activity
                continue;
            }

            String date = getDate(element);
            double magnitude = Double.parseDouble(getMagnitude(element));
            String seismicActivity = getSeismicActivity(element);
            Location location = new Location(getLocation(element));
            Earthquake earthquake = new Earthquake(date, magnitude, seismicActivity);
            location.addEarthquake(earthquake);

            // Each location has a list
            // Add the earthquake to the location (if not a duplicate)
            // The K should be String location and V should be the OBJECT Location!

            // If location already exists in Map, only add the earthquake to the list of earthquakes at the location

            earthquakeMap.put(location.getLocationName(), location);
        }
    }

    // TODO I want to be able to sort the locations by number of earthquakes

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

