package ch.nb;

import ch.nb.service.ApiService;
import ch.nb.service.FilmService;
import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, JsonException {

        // AUTHENTICATION
        //ApiService.getAuthentication();

        // SEARCH A MOVIE
        //ApiService.searchMovies("The Matrix");

        // GET A MOVIE DETAILS BY ID
        ApiService.getMovieDetails("624860");
        ApiService.getMovieDetails("624861");
        ApiService.getMovieDetails("624860");
        ApiService.getMovieDetails("624859");
        ApiService.getMovieDetails("62560");

        FilmService filmService = FilmService.getInstance();
        filmService.printFilms();

        // TODO
        // Refactor ApiService with an http request handler method
        // Refactor the term Film into Movie

        ApiService.getMovieCredits("624860");
    }
}
