package com.tripping.question.core.services;

import com.tripping.question.core.domain.User;
import com.tripping.question.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by krzysztofsa on 8/27/14.
 */
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> userList = userRepository.findByEmail(username);
        if (userList.isEmpty()) {
            throw new UsernameNotFoundException(username + " not found");
        }
        User user = userList.get(0);
        return new UserDetailsImplementation(user.getName(), user.getPasswordHash(), user.getRoles());
    }
}
