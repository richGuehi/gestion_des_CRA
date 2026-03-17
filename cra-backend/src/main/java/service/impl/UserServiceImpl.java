package service.impl;

import Utils.enums.ContratEnum;
import Utils.enums.RoleEnum;
import Utils.enums.SerioriteEnum;
import Utils.enums.UserStatusEnum;
import Utils.responses.UserResponses;
import dto.UserDto;
import dto.UserUpdateDto;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.UserService;
import transformer.UserTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponses createUser(UserDto dto) {
        // dto en entity
        User user = userTransformer.toEntity(dto);

        String motDePasseHache = passwordEncoder.encode(user.getPassword());
        user.setPassword(motDePasseHache);

        //save
        user = userRepository.save(user);
        // entity en dto response
        return userTransformer.toDto(user);
    }


    @Override
    public List<UserResponses> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponses getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User introuvable"));
        return userTransformer.toDto(user);
    }

    @Override
    public UserResponses updateUsers(Long id, UserUpdateDto dto) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User introuvable"));

        //mise jour
        user.setNom(dto.getNom());
        user.setPrenom(dto.getPrenom());
        user.setRole(RoleEnum.valueOf(dto.getRole()));
        user.setStatus(UserStatusEnum.valueOf(dto.getStatus()));
        user.setContrat(ContratEnum.valueOf(dto.getContrat()));
        user.setSeriorite(SerioriteEnum.valueOf(dto.getSeriorite()));
        user.setSalaire(dto.getSalaire());

        user = userRepository.save(user);
        return userTransformer.toDto(user);
    }

    @Override
    public UserResponses activationUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User introuvable"));

                //changer le statut (active, desactive)
        user.setActive(!user.isActive());
        user = userRepository.save(user);
        return userTransformer.toDto(user);
    }


//    changer après pour eviter de supprimer pour de vrai
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User introuvable");
        }
        userRepository.deleteById(id);
    }
}
