package my.cinema.service;

import java.util.List;
import my.cinema.model.Order;
import my.cinema.model.ShoppingCart;
import my.cinema.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
