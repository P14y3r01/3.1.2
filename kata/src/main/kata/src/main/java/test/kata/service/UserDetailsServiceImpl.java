package test.kata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import test.kata.repository.UserRepositoryTest;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepositoryTest userRepositoryTest;

    @Autowired
    public UserDetailsServiceImpl(UserRepositoryTest userRepositoryTest) {
        this.userRepositoryTest = userRepositoryTest;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepositoryTest.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
