package my.cinema.dao;

import java.util.List;
import my.cinema.model.Order;
import my.cinema.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
