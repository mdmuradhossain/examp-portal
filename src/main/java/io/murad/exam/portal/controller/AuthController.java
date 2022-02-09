package io.murad.exam.portal.controller;

import io.murad.exam.portal.model.AuthenticationRequest;
import io.murad.exam.portal.model.AuthenticationResponse;
import io.murad.exam.portal.model.User;
import io.murad.exam.portal.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private AuthService authService;

    @PostMapping("/generateToken")
    public ResponseEntity<AuthenticationResponse> generateToken(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authService.generateToken(authenticationRequest);
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    @GetMapping("/currentUser")
    public ResponseEntity<User> getCurrentUser(Principal principal) {
        return new ResponseEntity<>(authService.getLoggedInUser(principal.getName()), HttpStatus.OK);
    }
}
