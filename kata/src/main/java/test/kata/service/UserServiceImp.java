package test.kata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.kata.model.Role;
import test.kata.model.User;
import test.kata.repository.RoleRepositoryTest;
import test.kata.repository.UserRepositoryTest;

import java.util.List;



@Service

public class UserServiceImp implements UserDetailsService, UserService {


    private final UserRepositoryTest userRepositoryTest;
    private final RoleRepositoryTest roleRepository;

    @Autowired
    public UserServiceImp(UserRepositoryTest userRepositoryTest, RoleRepositoryTest roleRepository) {
        this.userRepositoryTest = userRepositoryTest;
        this.roleRepository = roleRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepositoryTest.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }


    public List<Role> listRoles() {
        return roleRepository.findAll();
    }



    @Transactional
    public void save(User user) {
        userRepositoryTest.save(user);
    }


    @Transactional
    public void delete(long id) {
        userRepositoryTest.deleteById(id);
    }


    public User getUserBiId(long id) {
        return userRepositoryTest.getOne(id);
    }


    public User getUserByName(String name) {
        return userRepositoryTest.findUserByUsername(name);
    }


    public List<User> all() {
        return userRepositoryTest.findAll();
    }
}
