package my.cinema.service;

import java.util.List;
import my.cinema.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
