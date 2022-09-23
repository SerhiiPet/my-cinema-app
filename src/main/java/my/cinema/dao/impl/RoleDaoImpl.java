package my.cinema.dao.impl;

import java.util.Optional;
import my.cinema.dao.AbstractDao;
import my.cinema.dao.RoleDao;
import my.cinema.exception.DataProcessingException;
import my.cinema.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> roleQuery = session.createQuery("FROM Role r "
                            + "WHERE r.roleName = :roleName", Role.class);
            roleQuery.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return roleQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't find role by name: " + roleName, e);
        }
    }
}
