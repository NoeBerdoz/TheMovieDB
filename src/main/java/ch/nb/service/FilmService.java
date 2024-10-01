package ch.nb.service;

import ch.nb.business.Film;

import java.util.HashMap;

public class FilmService {

    private static FilmService instance;

    private HashMap<Integer, Film> filmsMap;

    private FilmService() {
        this.filmsMap = new HashMap<>();
    }

    public static FilmService getInstance() {
        if (instance == null) {
            instance = new FilmService();
        }
        return instance;
    }

    public void addFilm(Film film) {
        filmsMap.put(film.getIdTheMovieDb(), film);
    }

    public void printFilms() {
        System.out.println("---------------- FILMS ----------------");
        for (Film film : filmsMap.values()) {
            System.out.println(film.getTitle());
            System.out.println(film.getIdTheMovieDb());
        }
    }

}
