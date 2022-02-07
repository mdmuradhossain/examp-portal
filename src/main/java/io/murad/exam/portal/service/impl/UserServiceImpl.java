package io.murad.exam.portal.service.impl;

import io.murad.exam.portal.exception.UsernameAlreadyExistsException;
import io.murad.exam.portal.model.User;
import io.murad.exam.portal.model.UserRole;
import io.murad.exam.portal.repository.RoleRepository;
import io.murad.exam.portal.repository.UserRepository;
import io.murad.exam.portal.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            log.info("User with username {} already exists. Nothing will be done.", user.getUsername());
            throw new UsernameAlreadyExistsException("User with username " + user.getUsername() + " already exists.");
        } else {
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }
            user.getUserRoles().addAll(userRoles);
            return userRepository.save(user);
        }
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}