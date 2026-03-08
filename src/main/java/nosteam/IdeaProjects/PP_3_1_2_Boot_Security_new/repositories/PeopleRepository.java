package nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.repositories;

import nosteam.IdeaProjects.PP_3_1_2_Boot_Security_new.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFirstName(String username);
}
