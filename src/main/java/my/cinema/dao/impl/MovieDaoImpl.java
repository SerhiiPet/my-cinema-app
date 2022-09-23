package my.cinema.dao.impl;

import my.cinema.dao.AbstractDao;
import my.cinema.dao.MovieDao;
import my.cinema.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
