package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.AuthResponse;
import com.cbx.cra_backend.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDto request){
        return ResponseEntity.ok(authService.login(request));
    }
}
