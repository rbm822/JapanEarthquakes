package earthquakes;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
      try {
            APIConnector connector = new APIConnector("https://www.jma.go.jp/bosai/quake/data/list.json");
            QuakeLoader quakeLoader = new QuakeLoader(connector);
      } catch (IOException | InterruptedException e) {
           throw new RuntimeException(e);
       }
   }
}
