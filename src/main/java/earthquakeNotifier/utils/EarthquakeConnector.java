package earthquakeNotifier.utils;

import java.io.IOException;

public class EarthquakeConnector {
    private String url;
    private APIConnector apiConnector;

    public EarthquakeConnector() {
        // TODO This should be moved back to QuakeLoader.java
        this.url = "https://www.jma.go.jp/bosai/quake/data/list.json";
        try {
            this.apiConnector = new APIConnector(url);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
