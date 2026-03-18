package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.CraResponse;
import com.cbx.cra_backend.dto.CraDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.CraService;

import java.util.List;

@Controller
@RequestMapping("api/cras")
@RequiredArgsConstructor
public class CraController {
    private final CraService craService;

    @PostMapping
    public ResponseEntity<CraResponse> createCra(@Valid @RequestBody CraDto dto) {
        return new ResponseEntity<>(craService.createCra(dto), HttpStatus.CREATED);
    }

    @GetMapping("/collaborateur/{collaborateurId}")
    public ResponseEntity<List<CraResponse>> getCrasByCollaborateur(@PathVariable Long collaborateurId) {
        return ResponseEntity.ok(craService.getCrasByCollaborateur(collaborateurId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CraResponse> getCraById(@PathVariable Long id) {
        return ResponseEntity.ok(craService.getCraById(id));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<CraResponse> submitCra(@PathVariable Long id) {
        return ResponseEntity.ok(craService.submitCra(id));
    }

        @PatchMapping("/{id}/evaluate")
    public ResponseEntity<CraResponse> evaluateCra(
            @PathVariable Long id,
            @RequestParam String statut,
            @RequestParam(required = false) String motif) {
        return ResponseEntity.ok(craService.updateCra(id, statut, motif));
    }
}
