package nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }
}