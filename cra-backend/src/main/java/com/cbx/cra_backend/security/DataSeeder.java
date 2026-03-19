package com.cbx.cra_backend.security;

import com.cbx.cra_backend.Utils.enums.RoleEnum;
import com.cbx.cra_backend.entity.User;
import com.cbx.cra_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

//    le user pour le test si SpringSecurity ferme toute les route

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // verifier et crer un compte
        if (userRepository.findByEmail("user0.User0@gmail.com").isEmpty()) {

            User admin = User.builder()
                    .nom("User0")
                    .prenom("User0")
                    .email("user0.User0@gmail.com")
                    .password(passwordEncoder.encode("user0"))
                    .role(RoleEnum.ADMIN)
                    .active(true)
                    .build();
            userRepository.save(admin);
        }
    }
}