package com.cbx.cra_backend.service.impl;

import com.cbx.cra_backend.Utils.responses.AuthResponse;
import com.cbx.cra_backend.dto.LoginDto;
import com.cbx.cra_backend.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import com.cbx.cra_backend.repository.UserRepository;
import com.cbx.cra_backend.security.JwtService;
import com.cbx.cra_backend.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final JwtService jwtService;
    //verif des password haché
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse login(LoginDto request) {

        //verif si ils sont en bd sinon
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // prendre le user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User introuvable"));

        //Token
        String jwtToken = jwtService.generateToken(user);

        return AuthResponse.builder()
                .token(jwtToken)
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .role(user.getRole().name())
                .build();
    }
}
