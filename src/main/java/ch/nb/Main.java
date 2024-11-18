package ch.nb;

import ch.nb.persistence.utils.DatabaseConnection;
import ch.nb.service.ApiService;
import com.github.cliftonlabs.json_simple.JsonException;

import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, JsonException, SQLException {

        // AUTHENTICATION
        //ApiService.getAuthentication();

        // SEARCH A MOVIE
        //ApiService.searchMovies("The Matrix");

        // GET A MOVIE DETAILS BY ID
//        ApiService.getMovieDetails("624860");
//        ApiService.getMovieDetails("624861");
//        ApiService.getMovieDetails("624860");
//        ApiService.getMovieDetails("624859");
//        ApiService.getMovieDetails("62560");
//
//        MovieService movieService = MovieService.getInstance();
//        movieService.printMovie();
//
//        ApiService.getMovieCredits("624860");

        DatabaseConnection.getConnection();

        ApiService.getMovieDetails("624860");

        DatabaseConnection.closeConnection();
    }
}
