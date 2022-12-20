package earthquakeNotifier.utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnector {

//    private String API_URL;
    private HttpClient httpClient;
    private HttpRequest httpRequest;
    private HttpResponse<String> httpResponse;

    public APIConnector(String API_URL) throws IOException, InterruptedException {

//        this.API_URL = API_URL;
        this.httpClient = HttpClient.newHttpClient();
        this.httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(API_URL))
                .build();
        this.httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> getHttpResponse() {
        return this.httpResponse;
    }
}
