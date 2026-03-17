package service;

import Utils.responses.UserResponses;
import dto.UserDto;
import dto.UserUpdateDto;

import java.util.List;

public interface UserService {
    UserResponses createUser(UserDto dto);

    List<UserResponses> getAllUsers();
    UserResponses getUserById(Long id);
    UserResponses updateUsers(Long id, UserUpdateDto dto);
    UserResponses activationUser(Long id);

    void deleteUser(Long id);
}
