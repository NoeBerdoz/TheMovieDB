package ch.nb.persistence.dao;

import ch.nb.business.Movie;
import ch.nb.logging.SimpleLogger;
import ch.nb.persistence.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDao implements Dao<Movie> {

    @Override
    public Optional<Movie> selectById(Long id) {
        String sql = "SELECT * FROM MOVIES WHERE ID = ?";

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(mapRowToMovie(resultSet));
            }

        } catch (SQLException e) {
            SimpleLogger.error("Failed to select MOVIE by ID: " + e.getMessage());
        }

        return Optional.empty();

    }

    @Override
    public List<Movie> selectAll() {
        String query = "SELECT * FROM MOVIES";

        List<Movie> movies = new ArrayList<>();

        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Integer countMovies = 0;
            while (resultSet.next()) {
                Movie movie = mapRowToMovie(resultSet);
                movies.add(movie);
                countMovies++;
            }
            SimpleLogger.info("[SELECTED] MOVIES COUNT: " + countMovies);

        } catch (SQLException e) {
            SimpleLogger.error("Failed to select all MOVIES: " + e.getMessage());
        }

        return movies;
    }

    @Override
    public void insert(Movie movie) {

        String query = "INSERT INTO RESTAURANT (TMDB_MOVIE_ID, TITLE, VOTE_AVERAGE, RELEASE_DATE, DURATION_IN_SECONDS, ORIGINAL_TITLE, ORIGINAL_LANGUAGE, IMAGE_PATH, BUDGET) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

        }

    }

    @Override
    public void update(Movie movie, String[] params) {
    }

    @Override
    public void delete(Movie movie) {

    }

    private Movie mapRowToMovie(ResultSet resultSet) throws SQLException {

        return new Movie.Builder()
                .withTmdbMovieId(resultSet.getInt("TMDB_MOVIE_ID"))
                .withTitle(resultSet.getString("TITLE"))
                .withVoteAverage(resultSet.getFloat("VOTE_AVERAGE"))
                .withReleaseDate(resultSet.getDate("RELEASE_DATE").toLocalDate())
                .withDurationInSeconds(resultSet.getInt("DURATION_IN_SECONDS"))
                .withOriginalTitle(resultSet.getString("ORIGINAL_TITLE"))
                .withOriginalLanguage(resultSet.getString("ORIGINAL_LANGUAGE"))
                .withImagePath(resultSet.getString("IMAGE_PATH"))
                .withBudget(resultSet.getBigDecimal("BUDGET"))
                .build();

    }
}
