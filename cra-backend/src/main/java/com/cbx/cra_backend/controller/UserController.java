package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.UserResponses;
import com.cbx.cra_backend.dto.UserDto;
import com.cbx.cra_backend.dto.UserUpdateDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.UserService;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponses> createCollaborateur(@Valid @RequestBody UserDto dto) {
        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponses> getCollaborateurById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponses> updateCollaborateur(@PathVariable Long id, @Valid @RequestBody UserUpdateDto dto) {
        return ResponseEntity.ok(userService.updateUsers(id, dto));
    }

    @PatchMapping("/{id}/toggle-activation")
    public ResponseEntity<UserResponses> toggleActivation(@PathVariable Long id) {
        return ResponseEntity.ok(userService.activationUser(id));
    }


}
