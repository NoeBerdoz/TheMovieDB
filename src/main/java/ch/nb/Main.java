package ch.nb;

import ch.nb.api.ApiService;
import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, JsonException {

        // AUTHENTICATION
        //ApiService.getAuthentication();

        // SEARCH A MOVIE
        ApiService.searchMovies("The Matrix");

    }
}
