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
    private Map<Location, List<Earthquake>> earthquakeMap;

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

            Location location = new Location(getLocation(element));
//            earthquakeMap.putIfAbsent(location,);

            String date = getDate(element);
            double magnitude = Double.parseDouble(getMagnitude(element));
            String seismicActivity = getSeismicActivity(element);
            Earthquake earthquake = new Earthquake(date, magnitude, seismicActivity);

//            if (initialEarthquakeList.size() > 0 && isDuplicate(initialEarthquakeList, earthquake)) {
//                continue;
//            }

//            initialEarthquakeList.add(earthquake);
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

