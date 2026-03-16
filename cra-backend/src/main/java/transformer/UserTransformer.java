package transformer;

import Utils.enums.RoleEnum;
import Utils.responses.UserResponses;
import dto.UserDto;
import entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    // Trannsformation du DTO en Entité
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(RoleEnum.valueOf(dto.getRole()))
                .active(false)
                .build();
    }

    // transformation de Entité de bd en en DTO
    public UserResponses toDto(User user) {

        if (user == null) {
            return null;
        }

        return UserResponses.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom(user.getPrenom())
                .email(user.getEmail())
                .role(user.getRole().name())
                .active(user.isActive())
                .build();
    }
}
