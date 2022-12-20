package earthquakeNotifier.logic;

import earthquakeNotifier.utils.APIConnector;

import java.io.IOException;

public class QuakePrinter {
    private String url;
    private APIConnector apiConnector;
    private QuakeLoader quakeLoader;

    public QuakePrinter() {
        // TODO This should be moved back to QuakeLoader.java
        this.url = "https://www.jma.go.jp/bosai/quake/data/list.json";
        try {
            this.apiConnector = new APIConnector(url);
            this.quakeLoader = new QuakeLoader(apiConnector);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void testQuakes() {
        quakeLoader.buildListOfEarthquakes();
    }
}
