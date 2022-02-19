package io.murad.exam.portal.controller;

import io.murad.exam.portal.model.Role;
import io.murad.exam.portal.model.User;
import io.murad.exam.portal.model.UserRole;
import io.murad.exam.portal.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("ROLE_USER");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);
        return new ResponseEntity<>(userService.createUser(user, userRoles), HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> removeUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User Removed", HttpStatus.OK);
    }
}
