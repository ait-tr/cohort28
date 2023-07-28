package movie.dao;

import movie.model.Movie;

import java.time.LocalDate;

public interface MoviesCollection {
    boolean addMovie(Movie movie);
    Movie removeMovie(long imdb);
    Movie findById(long imdb);
    Iterable<Movie> findByGenre(String genre);

    Iterable<Movie> findByDirector(String director);

    Iterable<Movie> findMoviesCreatedBetweenDares(LocalDate from, LocalDate to);
    int totalQuantity();

}
