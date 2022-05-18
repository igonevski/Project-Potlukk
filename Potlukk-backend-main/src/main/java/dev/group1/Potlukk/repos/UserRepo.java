package dev.group1.Potlukk.repos;

import dev.group1.Potlukk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
