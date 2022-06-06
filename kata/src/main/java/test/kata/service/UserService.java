package test.kata.service;

import org.springframework.security.core.userdetails.UserDetails;
import test.kata.model.Role;
import test.kata.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void delete(long id);
    User getUserBiId(long id);
    User getUserByName(String name);
    List<User> all();
    UserDetails loadUserByUsername(String username);

    List<Role> listRoles();
}
