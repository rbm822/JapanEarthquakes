package earthquakeNotifier.logic;

import earthquakeNotifier.utils.APIConnection;

import java.io.IOException;

public class QuakePrinter {
    private String url;
    private APIConnection apiConnection;
    private QuakeLoader quakeLoader;

    public QuakePrinter() {
        // TODO This should be moved back to QuakeLoader.java
        this.url = "https://www.jma.go.jp/bosai/quake/data/list.json";
        try {
            this.apiConnection = new APIConnection(url);
            this.quakeLoader = new QuakeLoader(apiConnection);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void testQuakes() {
        quakeLoader.buildListOfEarthquakes();
    }
}
