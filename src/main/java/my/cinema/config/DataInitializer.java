package my.cinema.config;

import java.util.Set;
import javax.annotation.PostConstruct;
import my.cinema.model.Role;
import my.cinema.model.User;
import my.cinema.service.RoleService;
import my.cinema.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        User bobUser = new User();

        bobUser.setEmail("e-mail address of the administrator");
        bobUser.setPassword("password of the administrator");
        bobUser.setRoles(Set.of(adminRole));
        userService.add(bobUser);
    }
}
