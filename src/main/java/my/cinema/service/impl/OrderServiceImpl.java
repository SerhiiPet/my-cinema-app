package my.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import my.cinema.dao.OrderDao;
import my.cinema.model.Order;
import my.cinema.model.ShoppingCart;
import my.cinema.model.User;
import my.cinema.service.OrderService;
import my.cinema.service.ShoppingCartService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);
    private final OrderDao orderDao;
    private final ShoppingCartService shoppingCartService;

    public OrderServiceImpl(OrderDao orderDao, ShoppingCartService shoppingCartService) {
        this.orderDao = orderDao;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        logger.info("completeOrder method was called. Param: shopping cart user email={}",
                shoppingCart.getUser().getEmail());
        Order order = new Order();
        order.setOrderTime(LocalDateTime.now());
        order.setTickets(shoppingCart.getTickets());
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clear(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        logger.info("getOrdersHistory method was called. Param: user email={}", user.getEmail());
        return orderDao.getOrdersHistory(user);
    }
}
