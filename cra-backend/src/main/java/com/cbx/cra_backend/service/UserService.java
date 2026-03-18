package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.UserResponses;
import com.cbx.cra_backend.dto.UserDto;
import com.cbx.cra_backend.dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponses createUser(UserDto dto);

    List<UserResponses> getAllUsers();
    UserResponses getUserById(Long id);
    UserResponses updateUsers(Long id, UserUpdateDto dto);
    UserResponses activationUser(Long id);

    void deleteUser(Long id);
}
