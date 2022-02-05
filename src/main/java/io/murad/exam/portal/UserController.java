package io.murad.exam.portal;

import io.murad.exam.portal.model.Role;
import io.murad.exam.portal.model.User;
import io.murad.exam.portal.model.UserRole;
import io.murad.exam.portal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("ROLE_USER");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);
        return new ResponseEntity<>(userService.createUser(user, userRoles), HttpStatus.CREATED);
    }
}
