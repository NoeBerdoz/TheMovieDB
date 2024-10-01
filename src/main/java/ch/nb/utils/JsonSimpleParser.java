package ch.nb.utils;
import ch.nb.business.Film;
import ch.nb.service.FilmService;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.math.BigDecimal;

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

        Film limitedFilm = new Film(
                (String) jsonObject.get("title"),
                id.intValue() // Convert BigDecimal to Integer
        );

//        Film completeFilm = new Film(
//                (String) jsonObject.get("title"),
//                (Float) jsonObject.get("vote_average"),
//                (LocalDate) jsonObject.get("release_date"),
//                3600,
//                (Integer) jsonObject.get("id"),
//                (String) jsonObject.get("original_title"),
//                (String) jsonObject.get("original_language"),
//                (List<Integer>) jsonObject.get("genre_ids"),
//                (String) jsonObject.get("poster_path")
//        );

        filmService.addFilm(limitedFilm);
        filmService.printFilms();

    }
}
