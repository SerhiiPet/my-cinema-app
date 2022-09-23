package my.cinema.service;

import my.cinema.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);
}
