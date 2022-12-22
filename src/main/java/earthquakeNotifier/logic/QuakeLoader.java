package earthquakeNotifier.logic;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.Location;
import earthquakeNotifier.utils.APIConnector;

import java.util.HashMap;
import java.util.Map;

public class QuakeLoader {
    private JsonArray jsonArray;
    private Map<String, Location> locations;

    public QuakeLoader(APIConnector connection) {
        this.jsonArray = new Gson().fromJson(connection.getHttpResponse().body(), JsonArray.class);
        this.locations = new HashMap<>();
        buildListOfEarthquakes();
    }

    private void buildListOfEarthquakes()  {
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
            if (locations.containsKey(getLocation(element))) {
                // Find the key and add the earthquake
                locations.get(getLocation(element)).addEarthquake(earthquake);
            } else {
                location.addEarthquake(earthquake);
                locations.put(getLocation(element), location);
            }
        }
    }

    public Map<String, Location> getLocationsWithEarthquakes() {
        return locations;
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

