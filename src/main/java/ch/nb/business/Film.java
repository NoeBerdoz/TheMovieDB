package ch.nb.business;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Locale;

public class Film {

    public String title;

    public Float voteAverage;

    public LocalDate releaseDate;

    public Integer durationInSeconds;

    public Integer idTheMovieDb;

    public String OriginalTitle;

    public String OriginalLanguage;

    public HashMap<Integer, String> genresMap;

    public String imagePath;

    public BigDecimal budget;

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

    public Film(String title, Float voteAverage, LocalDate releaseDate, Integer durationInSeconds, Integer idTheMovieDb, String OriginalTitle, String OriginalLanguage, HashMap<Integer, String> genresMap, String imagePath) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.durationInSeconds = durationInSeconds;
        this.idTheMovieDb = idTheMovieDb;
        this.OriginalTitle = OriginalTitle;
        this.OriginalLanguage = OriginalLanguage;
        this.genresMap = genresMap;
        this.imagePath = imagePath;
    }

    public Film(String title, Float voteAverage, LocalDate releaseDate, Integer durationInSeconds, Integer idTheMovieDb, String OriginalTitle, String OriginalLanguage, HashMap<Integer, String> genresMap, String imagePath, BigDecimal budget) {
        this.title = title;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
        this.durationInSeconds = durationInSeconds;
        this.idTheMovieDb = idTheMovieDb;
        this.OriginalTitle = OriginalTitle;
        this.OriginalLanguage = OriginalLanguage;
        this.genresMap = genresMap;
        this.imagePath = imagePath;
        this.budget = budget;
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

    public HashMap<Integer, String> getGenresMap() {
        return genresMap;
    }

    public String getImagePath() {
        return imagePath;
    }

    public BigDecimal getBudget() {
        return budget;
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

    public void setGenreIds(HashMap<Integer, String> genresMap) {
        this.genresMap = genresMap;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public static String formatCurrency(BigDecimal value) {
        // Create a NumberFormat instance with grouping separator (space)
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.FRANCE);
        numberFormat.setGroupingUsed(true); // Use grouping (thousands separator)

        // Format the BigDecimal value
        String formattedValue = numberFormat.format(value);

        // Append the currency symbol
        return formattedValue + " $";
    }
}
