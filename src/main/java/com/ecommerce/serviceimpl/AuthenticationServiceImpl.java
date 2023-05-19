package com.ecommerce.serviceimpl;

import com.ecommerce.dto.request.LoginRequest;
import com.ecommerce.dto.response.LoginResponse;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.security.JwtService;
import com.ecommerce.service.Authentication;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@AllArgsConstructor
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements Authentication {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse authentication(LoginRequest loginRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        userRepository.findByUsername(loginRequest.getUsername()).orElseThrow();
        String token = jwtService.createToken(loginRequest);
        return new LoginResponse(loginRequest.getUsername(), token);
    }
}
