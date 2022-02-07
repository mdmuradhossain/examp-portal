package io.murad.exam.portal.service;

import io.murad.exam.portal.model.AuthenticationRequest;
import io.murad.exam.portal.model.AuthenticationResponse;
import io.murad.exam.portal.model.User;
import io.murad.exam.portal.security.JWTAuthenticationProvider;
import io.murad.exam.portal.service.impl.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private UserDetailsServiceImpl userDetailsService;
    private JWTAuthenticationProvider jwtAuthenticationProvider;
    private AuthenticationManager authenticationManager;

    public void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }

    public AuthenticationResponse generateToken(AuthenticationRequest authenticationRequest) {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token = jwtAuthenticationProvider.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .build();

    }

}
