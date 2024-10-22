package ch.nb.utils;
import ch.nb.business.Movie;
import ch.nb.service.MovieService;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class JsonSimpleParser {

    private static final MovieService MOVIE_SERVICE = MovieService.getInstance();

    private static JsonObject getJsonObject(String jsonString) throws JsonException {
        return (JsonObject) Jsoner.deserialize(jsonString);
    }

    /* Initially here for testing, should delete this method later */
    public static void parseJson(String jsonString) throws JsonException {

        System.out.println(jsonString);

        JsonObject jsonObject = getJsonObject(jsonString);
        System.out.println(jsonObject.get("title"));

    }

    public static void parseGetMovieDetails(String jsonString) throws JsonException {

        JsonObject jsonObject = getJsonObject(jsonString);

        BigDecimal id = (BigDecimal) jsonObject.get("id");
        BigDecimal voteAverage = (BigDecimal) jsonObject.get("vote_average");
        BigDecimal runtime = (BigDecimal) jsonObject.get("runtime");
        LocalDate releaseDate = LocalDate.parse((String) jsonObject.get("release_date"));
        BigDecimal durationInSeconds = runtime.multiply(BigDecimal.valueOf(3600));

        // Did this while being sick, not sure is the cleanest way to do it
        HashMap<Integer, String> genresMap = new HashMap<>();
        JsonArray genres = (JsonArray) jsonObject.get("genres");
        for (Object genre : genres) {
            JsonObject genreObject = (JsonObject) genre;
            genresMap.put(((BigDecimal) genreObject.get("id")).intValue(), (String) genreObject.get("name"));
        }

        Movie limitedMovie = new Movie(
                id.intValue(), // Convert BigDecimal to Integer
                (String) jsonObject.get("title")
        );

        Movie missingGenreMovie = new Movie(
                id.intValue(),
                (String) jsonObject.get("title"),
                voteAverage.floatValue(),
                releaseDate,
                durationInSeconds.intValue(),
                (String) jsonObject.get("original_title"),
                (String) jsonObject.get("original_language"),
                (String) jsonObject.get("poster_path")
        );

        Movie movie = new Movie(
                id.intValue(),
                (String) jsonObject.get("title"),
                voteAverage.floatValue(),
                releaseDate,
                durationInSeconds.intValue(),
                (String) jsonObject.get("original_title"),
                (String) jsonObject.get("original_language"),
                genresMap,
                (String) jsonObject.get("poster_path"),
                (BigDecimal) jsonObject.get("budget")
        );

        MOVIE_SERVICE.addMovie(movie);

    }

    public static void parseGetMovieCredits(String jsonString) throws JsonException {

        JsonObject jsonObject = getJsonObject(jsonString);

        BigDecimal idMovie = (BigDecimal) jsonObject.get("id");

        System.out.println("--- parseGetMovieCredits ---");
        System.out.println("idMovie : " + idMovie);

    }
}
