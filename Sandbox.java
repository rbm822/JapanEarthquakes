import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

public class Sandbox {
    public static void main(String[] args) {
	    try {
	    	APIConnector connector =
		       	new APIConnector("https://www.jma.go.jp/bosai/quake/data/list.json");
		System.out.println(connector.getHttpResponse().body());
	    } catch (IOException e) {
		    System.out.println("Could not load URL.");
	    } catch (InterruptedException e) {
		    System.out.println("Something bad happened.");
	    }

    }

    public static String stream(URL url) throws IOException {
	    try (InputStream input = url.openStream()) {
		    InputStreamReader isr = new InputStreamReader(input);
		    BufferedReader reader = new BufferedReader(isr);
		    StringBuilder json = new StringBuilder();
		    int c;
		    while ((c = reader.read()) != -1) {
			    json.append((char) c);
		    }

		    return json.toString();
	    }
    }
}
