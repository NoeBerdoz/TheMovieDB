package ch.nb.utils;
import ch.nb.business.Film;
import ch.nb.service.FilmService;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;

public class JsonSimpleParser {

    private static final FilmService filmService = FilmService.getInstance();

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

        Film limitedFilm = new Film(
                (String) jsonObject.get("title"),
                id.intValue() // Convert BigDecimal to Integer
        );

        Film missingGenreFilm = new Film(
                (String) jsonObject.get("title"),
                voteAverage.floatValue(),
                releaseDate,
                durationInSeconds.intValue(),
                id.intValue(),
                (String) jsonObject.get("original_title"),
                (String) jsonObject.get("original_language"),
                (String) jsonObject.get("poster_path")
        );

        Film film = new Film(
                (String) jsonObject.get("title"),
                voteAverage.floatValue(),
                releaseDate,
                durationInSeconds.intValue(),
                id.intValue(),
                (String) jsonObject.get("original_title"),
                (String) jsonObject.get("original_language"),
                genresMap,
                (String) jsonObject.get("poster_path"),
                (BigDecimal) jsonObject.get("budget")
        );

        filmService.addFilm(film);

    }

    public static void parseGetMovieCredits(String jsonString) throws JsonException {

        JsonObject jsonObject = getJsonObject(jsonString);

        BigDecimal idMovie = (BigDecimal) jsonObject.get("id");

        System.out.println("--- parseGetMovieCredits ---");
        System.out.println("idMovie : " + idMovie);

    }
}
