package ch.nb.service;

import ch.nb.business.Movie;

import java.util.HashMap;

public class MovieService {

    private static MovieService instance;

    private HashMap<Integer, Movie> moviesMap;

    private MovieService() {
        this.moviesMap = new HashMap<>();
    }

    public static MovieService getInstance() {
        if (instance == null) {
            instance = new MovieService();
        }
        return instance;
    }

    public void addMovie(Movie movie) {
        moviesMap.put(movie.getIdTheMovieDb(), movie);
    }

    private void printGenres(HashMap<Integer, String> genresMap) {
        for (Integer genreId : genresMap.keySet()) {
            System.out.println("   genreID : " + genreId + " genreName : " + genresMap.get(genreId));
        }
    }

    public void printMovie() {
        int movieCounter = 0;
        System.out.println("---------------- MOVIES ----------------");
        for (Movie movie : moviesMap.values()) {
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Vote average: " + movie.voteAverage);
            System.out.println("Release date : " + movie.getReleaseDate());
            System.out.println("Duration in seconds : " + movie.getDurationInSeconds());
            System.out.println("ID : " + movie.getIdTheMovieDb());
            System.out.println("Original title : " + movie.getOriginalTitle());
            System.out.println("Original language : " + movie.getOriginalLanguage());
            System.out.println("Genres :");
            printGenres(movie.genresMap);
            System.out.println("Image path : " + movie.getImagePath());
            System.out.println("Budget : " + Movie.formatCurrency(movie.getBudget()));
            System.out.println("---------------- " + movieCounter + " ----------------");
            movieCounter++;
        }
    }

}
