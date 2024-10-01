package ch.nb.service;

import ch.nb.business.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmService {

    private static FilmService instance;

    private List<Film> films;

    private FilmService() {
        this.films = new ArrayList<>();
    }

    public static FilmService getInstance() {
        if (instance == null) {
            instance = new FilmService();
        }
        return instance;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

}
