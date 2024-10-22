package ch.nb.service;

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


    private static HttpResponse<String> sendHttpRequest(String endpoint) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + endpoint))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Check authentication
    public static void getAuthentication() throws IOException, InterruptedException {
        HttpResponse<String> response = sendHttpRequest("/authentication");
        PrettyJsonWithGson.printJson(response.body());
    }

    // Search for movies by their original, translated and alternative titles.
    public static void searchMovies(String query) throws IOException, InterruptedException {
        String encodedQUery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        HttpResponse<String> response = sendHttpRequest("/search/movie?query=" + encodedQUery + "&include_adult=false&language=en-US");
        PrettyJsonWithGson.printJson(response.body()); // Using Gson parser exemple
    }

    // Get all the details from a movie by its id
    public static void getMovieDetails(String tmdbMovieId) throws JsonException, IOException, InterruptedException {
        HttpResponse<String> response = sendHttpRequest("/movie/" + tmdbMovieId + "?language=en-US");
        JsonSimpleParser.parseGetMovieDetails(response.body());
    }

    // Get the cast and crew for a movie
    public static void getMovieCredits(String tmdbMovieId) throws JsonException, IOException, InterruptedException {
        HttpResponse<String> response = sendHttpRequest("/movie/" + tmdbMovieId + "/credits?language=en-US");
        JsonSimpleParser.parseGetMovieCredits(response.body());
    }

}
