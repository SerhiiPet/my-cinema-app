package my.cinema.service.impl;

import java.time.LocalDate;
import java.util.List;
import my.cinema.dao.MovieSessionDao;
import my.cinema.model.MovieSession;
import my.cinema.service.MovieSessionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    private static final Logger logger = LogManager.getLogger(MovieSessionServiceImpl.class);
    private final MovieSessionDao movieSessionDao;

    public MovieSessionServiceImpl(MovieSessionDao movieSessionDao) {
        this.movieSessionDao = movieSessionDao;
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return movieSessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession add(MovieSession session) {
        logger.info("add method was called. Param: movie title={}, cinema hall id={},"
                        + " movie show time={}",
                session.getMovie().getTitle(), session.getCinemaHall().getId(),
                session.getShowTime());
        return movieSessionDao.add(session);
    }

    @Override
    public MovieSession get(Long id) {
        logger.info("get method was called. Param: movie session id={}", id);
        return movieSessionDao.get(id).orElseThrow(
                () -> new RuntimeException("Session with id " + id + " not found"));
    }

    @Override
    public MovieSession update(MovieSession session) {
        logger.info("update method was called. Param: movie title={},"
                        + " cinema hall id={}, movie show time={}",
                session.getMovie().getTitle(), session.getCinemaHall().getId(),
                session.getShowTime());
        return movieSessionDao.update(session);
    }

    @Override
    public void delete(Long id) {
        logger.info("delete method was called. Param: movie session id={}", id);
        movieSessionDao.delete(id);
    }
}
