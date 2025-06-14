package com.majed.SpringSecTemplate.service;

import com.majed.SpringSecTemplate.domain.model.Users;
import com.majed.SpringSecTemplate.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final BCryptPasswordEncoder passWordEncoder = new BCryptPasswordEncoder(12);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public Users addUser(Users user) {
        user.setPassword(passWordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String login(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(user);
        } else {
            return "Failed";
        }
    }
}
