package test.kata.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import test.kata.model.User;


public interface UserRepositoryTest extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findUserByUsername(String name);
}
