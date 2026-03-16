package service.implement;

import Utils.responses.UserResponses;
import dto.UserDto;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
import transformer.UserTransformer;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    @Override
    public UserResponses create(UserDto dto) {
        // dto en entity
        User user = userTransformer.toEntity(dto);
        //save
        user = userRepository.save(user);
        // entity en dto response
        return userTransformer.toDto(user);
    }
}
