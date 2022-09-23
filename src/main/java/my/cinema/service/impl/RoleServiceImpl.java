package my.cinema.service.impl;

import my.cinema.dao.RoleDao;
import my.cinema.model.Role;
import my.cinema.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger logger = LogManager.getLogger(RoleServiceImpl.class);
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        logger.info("add method was called. Param: role name={}", role.getRoleName().name());
        return roleDao.add(role);
    }

    @Override
    public Role getByName(String roleName) {
        logger.info("getByName method was called. Param: role name={}", roleName);
        return roleDao.getByName(roleName).orElseThrow(
                () -> new RuntimeException("RoleName not fount: " + roleName));
    }
}
