package ch.nb.business;

import java.time.LocalDate;
import java.util.List;

public class Film {

    public String title;

    public Float voteAverage;

    public LocalDate releaseDate;

    public Integer durationInSeconds;

    public Integer idTheMovieDb;

    public String OriginalTitle;

    public String OriginalLanguage;

    public List<Integer> genreIds;

    public String imagePath;

    public Film(String title, Integer idTheMovieDb) {
        this.title = title;
        this.idTheMovieDb = idTheMovieDb;
    }

    public Film(String title, Float voteAverage, LocalDate releaseDate, Integer durationInSeconds, Integer idTheMovieDb, String OriginalTitle, String OriginalLanguage, String imagePath) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.durationInSeconds = durationInSeconds;
        this.idTheMovieDb = idTheMovieDb;
        this.OriginalTitle = OriginalTitle;
        this.OriginalLanguage = OriginalLanguage;
        this.imagePath = imagePath;
    }

    public Film(String title, Float voteAverage, LocalDate releaseDate, Integer durationInSeconds, Integer idTheMovieDb, String OriginalTitle, String OriginalLanguage, List<Integer> genreIds, String imagePath) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.durationInSeconds = durationInSeconds;
        this.idTheMovieDb = idTheMovieDb;
        this.OriginalTitle = OriginalTitle;
        this.OriginalLanguage = OriginalLanguage;
        this.genreIds = genreIds;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public Integer getIdTheMovieDb() {
        return idTheMovieDb;
    }

    public String getOriginalTitle() {
        return OriginalTitle;
    }

    public String getOriginalLanguage() {
        return OriginalLanguage;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    public void setIdTheMovieDb(Integer idTheMovieDb) {
        this.idTheMovieDb = idTheMovieDb;
    }

    public void setOriginalTitle(String OriginalTitle) {
        this.OriginalTitle = OriginalTitle;
    }

    public void setOriginalLanguage(String OriginalLanguage) {
        this.OriginalLanguage = OriginalLanguage;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

}
