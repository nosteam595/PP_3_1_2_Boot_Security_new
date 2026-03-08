package nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.dao;

import nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.model.Role;
import java.util.List;

public interface RoleDao {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    void addRole(Role role);
}
