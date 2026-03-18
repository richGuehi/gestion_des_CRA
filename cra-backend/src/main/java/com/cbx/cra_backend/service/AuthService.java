package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.AuthResponse;
import com.cbx.cra_backend.dto.LoginDto;

public interface AuthService {

    AuthResponse  login(LoginDto loginDto);
}
