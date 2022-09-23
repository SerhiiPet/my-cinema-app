package my.cinema.service.impl;

import my.cinema.dao.ShoppingCartDao;
import my.cinema.dao.TicketDao;
import my.cinema.model.MovieSession;
import my.cinema.model.ShoppingCart;
import my.cinema.model.Ticket;
import my.cinema.model.User;
import my.cinema.service.ShoppingCartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private static final Logger logger = LogManager.getLogger(ShoppingCartServiceImpl.class);
    private final ShoppingCartDao shoppingCartDao;
    private final TicketDao ticketDao;

    public ShoppingCartServiceImpl(ShoppingCartDao shoppingCartDao, TicketDao ticketDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.ticketDao = ticketDao;
    }

    @Override
    public void addSession(MovieSession session, User user) {
        logger.info("addSession method was called. Param: movie title={},"
                        + " cinema hall id={}, movie show time={}, user email={}",
                session.getMovie().getTitle(), session.getCinemaHall().getId(),
                session.getShowTime(), user.getEmail());
        Ticket ticket = new Ticket();
        ticket.setMovieSession(session);
        ticket.setUser(user);
        ShoppingCart shoppingCart = shoppingCartDao.getByUser(user);
        ticketDao.add(ticket);
        shoppingCart.getTickets().add(ticket);
        shoppingCartDao.update(shoppingCart);
    }

    @Override
    public ShoppingCart getByUser(User user) {
        logger.info("getByUser method was called. Param: user email={}", user.getEmail());
        return shoppingCartDao.getByUser(user);
    }

    @Override
    public void registerNewShoppingCart(User user) {
        logger.info("registerNewShoppingCart method was called. Param: user email={}",
                user.getEmail());
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCartDao.add(shoppingCart);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        logger.info("clear method was called. Param: shopping cart user email={}",
                shoppingCart.getUser().getEmail());
        shoppingCart.setTickets(null);
        shoppingCartDao.update(shoppingCart);
    }
}
