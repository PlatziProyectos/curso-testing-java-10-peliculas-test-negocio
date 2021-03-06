package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryImpl implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        return null;
    }

    @Override
    public Collection<Movie> findAll() {
        RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("minutes"),
                        Genre.valueOf(resultSet.getString("genre")));
            }
        };
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {

    }
}
