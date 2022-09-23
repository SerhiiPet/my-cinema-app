package my.cinema.service;

import my.cinema.model.MovieSession;
import my.cinema.model.ShoppingCart;
import my.cinema.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
