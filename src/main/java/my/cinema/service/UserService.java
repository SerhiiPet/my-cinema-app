package my.cinema.service;

import java.util.Optional;
import my.cinema.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
