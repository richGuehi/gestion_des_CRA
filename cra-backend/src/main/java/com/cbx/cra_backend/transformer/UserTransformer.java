package com.cbx.cra_backend.transformer;

import com.cbx.cra_backend.Utils.enums.ContratEnum;
import com.cbx.cra_backend.Utils.enums.RoleEnum;
import com.cbx.cra_backend.Utils.enums.SerioriteEnum;
import com.cbx.cra_backend.Utils.enums.UserStatusEnum;
import com.cbx.cra_backend.Utils.responses.UserResponses;
import com.cbx.cra_backend.dto.UserDto;
import com.cbx.cra_backend.entity.User;
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
                .status(UserStatusEnum.valueOf(dto.getStatus()))
                .contrat(ContratEnum.valueOf(dto.getContrat()))
                .seriorite(SerioriteEnum.valueOf(dto.getSeriorite()))
                .salaire(dto.getSalaire())
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
                .role(user.getRole() != null ? user.getRole().name() : null)
                .statut(user.getStatus() != null ? user.getStatus().name() : null)
                .contrat(user.getContrat() != null ? user.getContrat().name() : null)
                .seriorite(user.getSeriorite() != null ? user.getSeriorite().name() : null)
                .salaire(user.getSalaire())
                .active(user.isActive())
                .build();
    }
}
