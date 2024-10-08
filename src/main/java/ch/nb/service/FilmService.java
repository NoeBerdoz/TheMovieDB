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
        int filmCounter = 0;
        System.out.println("---------------- FILMS ----------------");
        for (Film film : filmsMap.values()) {
            System.out.println("Title: " + film.getTitle());
            System.out.println("Release date : " + film.getReleaseDate());
            System.out.println("Duration in seconds : " + film.getDurationInSeconds());
            System.out.println("ID : " + film.getIdTheMovieDb());
            System.out.println("Original title : " + film.getOriginalTitle());
            System.out.println("Original language : " + film.getOriginalLanguage());
            System.out.println("Image path : " + film.getImagePath());
            System.out.println("---------------- " + filmCounter + " ----------------");
            filmCounter++;
        }
    }

}
