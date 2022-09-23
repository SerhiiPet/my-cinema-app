package my.cinema.service.impl;

import java.util.List;
import my.cinema.dao.CinemaHallDao;
import my.cinema.model.CinemaHall;
import my.cinema.service.CinemaHallService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    private static final Logger logger = LogManager.getLogger(CinemaHallServiceImpl.class);
    private final CinemaHallDao cinemaHallDao;

    public CinemaHallServiceImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        logger.info("add method was called. Param: cinema hall capacity={}",
                cinemaHall.getCapacity());
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).orElseThrow(
                () -> new RuntimeException("Can't get cinema hall by id " + id));
    }

    @Override
    public List<CinemaHall> getAll() {
        logger.info("addAll method was called.");
        return cinemaHallDao.getAll();
    }
}
