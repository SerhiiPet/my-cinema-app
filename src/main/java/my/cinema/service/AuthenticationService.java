package my.cinema.service;

import my.cinema.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
