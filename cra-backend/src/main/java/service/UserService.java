package service;

import Utils.responses.UserResponses;
import dto.UserDto;

public interface UserService {
    UserResponses create(UserDto dto);
}
