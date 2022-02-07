package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.model.User;
import io.murad.exam.portal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User existingUser = userRepository.findByUsername(username);
        if (existingUser == null) {
            log.info("Username not found");
            throw new UsernameNotFoundException("Username not found");
        } else {
            return existingUser;
        }

    }
}
