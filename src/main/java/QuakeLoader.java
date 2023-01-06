import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.domain.EarthquakeContainer;
import earthquakeNotifier.domain.Location;
import earthquakeNotifier.utils.APIConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuakeLoader {
    private JsonArray jsonArray;
    private Map<String, Location> locations;
    private EarthquakeContainer earthquakeContainer;

    public QuakeLoader(APIConnector connection) {
        this.jsonArray = new Gson().fromJson(connection.getHttpResponse().body(), JsonArray.class);
        this.locations = new HashMap<>();
        this.earthquakeContainer = new EarthquakeContainer();
        buildLocationsWithEarthquakes();
    }

    private void buildLocationsWithEarthquakes()  {
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
            Earthquake earthquake = new Earthquake(location, date, magnitude, seismicActivity);
            earthquakeContainer.add(earthquake);
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

    public List<Earthquake> getEarthquakeList() {
        return earthquakeContainer.getEarthquakes();
    }

    public List<Earthquake> getEarthquakeList(int fromIndex, int toIndex) {
        return earthquakeContainer.sublist(fromIndex, toIndex);
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

