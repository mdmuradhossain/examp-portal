package io.murad.exam.portal.service;

import io.murad.exam.portal.model.User;
import io.murad.exam.portal.model.UserRole;

import java.util.Set;

public interface UserService {
    public User createUser(User user, Set<UserRole> userRoles);

    public User getUser(String username);

    public void deleteUser(Long userId);
}
