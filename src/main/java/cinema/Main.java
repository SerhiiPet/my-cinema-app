package cinema;

import cinema.lib.Injector;
import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.Order;
import cinema.model.User;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import cinema.service.MovieSessionService;
import cinema.service.OrderService;
import cinema.service.ShoppingCartService;
import cinema.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    private static final Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) {
        // create/add/get movies:
        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);
        Movie createdFastAndFurious = new Movie("Fast and Furious");
        createdFastAndFurious.setDescription("An action film about street"
                + " racing, heists, and spies.");
        Movie createdTerminator = new Movie("The Terminator");
        createdTerminator.setDescription("The Terminator is a 1984 American"
                + " science fiction action film directed by James Cameron."
                + " It stars Arnold Schwarzenegger as the Terminator.");
        movieService.add(createdFastAndFurious);
        movieService.add(createdTerminator);
        System.out.println(movieService.getAll());

        // create/add/get cinemaHallServices:
        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");
        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");
        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);
        System.out.println(cinemaHallService.getAll());

        // create/add/get/find movieSessions:
        MovieSession tomorrowDayMovieSession = new MovieSession();
        tomorrowDayMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowDayMovieSession.setMovie(createdFastAndFurious);
        tomorrowDayMovieSession.setShowTime(LocalDateTime.of(
                LocalDate.now().plusDays(1L), LocalTime.of(15, 00)));
        MovieSession tomorrowEveningMovieSession = new MovieSession();
        tomorrowEveningMovieSession.setCinemaHall(secondCinemaHall);
        tomorrowEveningMovieSession.setMovie(createdTerminator);
        tomorrowEveningMovieSession.setShowTime(LocalDateTime.of(
                LocalDate.now().plusDays(1L), LocalTime.of(18, 00)));
        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(tomorrowDayMovieSession);
        movieSessionService.add(tomorrowEveningMovieSession);

        System.out.println(movieSessionService.get(tomorrowDayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                        createdFastAndFurious.getId(), LocalDate.now().plusDays(1L)));

        // create users:
        UserService userService = (UserService) injector.getInstance(UserService.class);
        User createdBob = new User();
        createdBob.setEmail("bob@i.ua");
        createdBob.setPassword("1234");
        User bob = userService.add(createdBob);

        // shoppingCart registration for the user:
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.registerNewShoppingCart(bob);

        //  creating ticket and adding it to user's shoppingCart:
        shoppingCartService.addSession(tomorrowDayMovieSession, bob);
        shoppingCartService.addSession(tomorrowEveningMovieSession, bob);

        // creating an order and clearing the user's shoppingCart:
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
        Order order = orderService.completeOrder(shoppingCartService.getByUser(bob));
        System.out.println(order);
        // getting all user orders:
        System.out.println(orderService.getOrdersHistory(bob));
    }
}
