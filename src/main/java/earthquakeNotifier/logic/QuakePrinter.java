package earthquakeNotifier.logic;

import earthquakeNotifier.domain.Earthquake;
import earthquakeNotifier.utils.APIConnection;

import java.io.IOException;

public class QuakePrinter implements Printable {
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

    public void print() {
        for (Earthquake earthquake : quakeLoader.getEarthquakes()) {
            System.out.println(earthquake);
        }
    }

    public void printMostActiveLocation() {
        System.out.println("The most active location in Japan is: " + quakeLoader.getMostActiveLocation());
    }
}
