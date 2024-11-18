package ch.nb.persistence.dao;

import ch.nb.business.Movie;
import ch.nb.logging.SimpleLogger;
import ch.nb.persistence.utils.DatabaseConnection;
import ch.nb.persistence.utils.StatementHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieDAO implements DAO<Movie> {

    private static MovieDAO instance;

    public static MovieDAO getInstance() {
        if (instance == null) {
            instance = new MovieDAO();
        }
        return instance;
    }

    private MovieDAO() {
    }

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
    public void insert(Movie movie) throws SQLException{

        String query = "INSERT INTO MOVIES (TMDB_MOVIE_ID, TITLE, VOTE_AVERAGE, RELEASE_DATE, DURATION_IN_SECONDS, ORIGINAL_TITLE, ORIGINAL_LANGUAGE, IMAGE_PATH, BUDGET) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, new String[]{"ID"});
            StatementHelper.bindStatementParameters(
                    preparedStatement,
                    movie.getTmdbMovieId(),
                    movie.getTitle(),
                    movie.getVoteAverage(),
                    movie.getReleaseDate(),
                    movie.getDurationInSeconds(),
                    movie.getOriginalTitle(),
                    movie.getOriginalLanguage(),
                    movie.getImagePath(),
                    movie.getBudget()
            );

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {

                // Set the new generated ID to the restaurant object
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    String generatedId = generatedKeys.getString(1);
                    movie.setId(Long.valueOf(generatedId));
                    SimpleLogger.info("[DB][INSERTED] MOVIE ID: " + movie.getId());

                    connection.commit();
                }
            }
        } catch (SQLException e) {
            connection.rollback();
            SimpleLogger.error("Failed to insert MOVIE: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void update(Movie movie, String[] params) throws SQLException {

        Connection connection = DatabaseConnection.getConnection();

        String query = "UPDATE MOVIES SET TMDB_MOVIE_ID, TITLE, VOTE_AVERAGE, RELEASE_DATE, DURATION_IN_SECONDS, ORIGINAL_TITLE, ORIGINAL_LANGUAGE, IMAGE_PATH, BUDGET WHERE ID = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            StatementHelper.bindStatementParameters(
                    preparedStatement,
                    movie.getTmdbMovieId(),
                    movie.getTitle(),
                    movie.getVoteAverage(),
                    movie.getReleaseDate(),
                    movie.getDurationInSeconds(),
                    movie.getOriginalTitle(),
                    movie.getOriginalLanguage(),
                    movie.getImagePath(),
                    movie.getBudget(),
                    movie.getId()
            );

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                SimpleLogger.info("[DB][UPDATED] MOVIE ID: " + movie.getId());
                connection.commit();
            } else {
                SimpleLogger.warning("[DB][UPDATE] NO MOVIE FOUND WITH ID: " + movie.getId());
            }

        } catch (SQLException e) {
            connection.rollback();
            SimpleLogger.error("Failed to update MOVIE: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void delete(Movie movie) throws SQLException {

        String query = "DELETE FROM MOVIES WHERE ID = ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            StatementHelper.bindStatementParameters(
                    preparedStatement,
                    movie.getId()
            );

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                SimpleLogger.info("[DB][DELETED] MOVIE ID: " + movie.getId());
                connection.commit();
            } else {
                SimpleLogger.warning("[DB][DELETE] NO MOVIE FOUND WITH ID: " + movie.getId());
            }

        } catch (SQLException e) {
            connection.rollback();
            SimpleLogger.error("Failed to delete MOVIE: " + e.getMessage());
            throw e;
        }
    }

    private Movie mapRowToMovie(ResultSet resultSet) throws SQLException {

        return new Movie.Builder()
                .withId(resultSet.getLong("ID"))
                .withTmdbMovieId(resultSet.getLong("TMDB_MOVIE_ID"))
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
