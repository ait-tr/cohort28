package movie.dao;

import movie.model.Movie;

import java.time.LocalDate;

public class MoviesCollectionImpl implements MoviesCollection{

    @Override
    public boolean addMovie(Movie movie) {
        return false;
    }

    @Override
    public Movie removeMovie(long imdb) {
        return null;
    }

    @Override
    public Movie findById(long imdb) {
        return null;
    }

    @Override
    public Iterable<Movie> findByGenre(String genre) {
        return null;
    }

    @Override
    public Iterable<Movie> findByDirector(String director) {
        return null;
    }

    @Override
    public Iterable<Movie> findMoviesCreatedBetweenDares(LocalDate from, LocalDate to) {
        return null;
    }

    @Override
    public int totalQuantity() {
        return 0;
    }
}
