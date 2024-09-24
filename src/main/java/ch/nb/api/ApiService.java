package ch.nb.api;

import ch.nb.utils.PrettyJsonWithGson;
import ch.nb.utils.JsonSimpleParser;
import ch.nb.utils.PropertiesLoader;
import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ApiService {

    private static PropertiesLoader propertiesLoader = new PropertiesLoader("api.properties");

    private static final String API_URL = propertiesLoader.getProperty("api.url");
    private static final String API_KEY = propertiesLoader.getProperty("api.key");

    // Check authentication
    public static void getAuthentication() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "/authentication"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        PrettyJsonWithGson.printJson(response.body());
    }

    // Search for movies by their original, translated and alternative titles.
    public static void searchMovies(String query) throws IOException, InterruptedException, JsonException {
        String encodedQUery = URLEncoder.encode(query, StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + "/search/movie?query=" + encodedQUery + "&include_adult=false&language=en-US"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // THE WAY WITH Gson parser
        PrettyJsonWithGson.printJson(response.body());
        JsonSimpleParser.printJson(response.body());
    }

}
