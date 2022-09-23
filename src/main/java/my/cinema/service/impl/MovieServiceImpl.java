package my.cinema.service.impl;

import java.util.List;
import my.cinema.dao.MovieDao;
import my.cinema.model.Movie;
import my.cinema.service.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private static final Logger logger = LogManager.getLogger(MovieServiceImpl.class);
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Movie add(Movie movie) {
        logger.info("add method was called. Param: movie title={}", movie.getTitle());
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        logger.info("get method was called. Param: movie id={}", id);
        return movieDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get movie by id " + id));
    }

    @Override
    public List<Movie> getAll() {
        logger.info("getAll method was called.");
        return movieDao.getAll();
    }
}
