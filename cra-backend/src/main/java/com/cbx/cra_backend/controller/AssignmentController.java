package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.AssignmentResponse;
import com.cbx.cra_backend.dto.AssignmentDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.AssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @PostMapping
    public ResponseEntity<AssignmentResponse> createAssignment(@Valid @RequestBody AssignmentDto dto) {
        return new ResponseEntity<>(assignmentService.createAssignment(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AssignmentResponse>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @GetMapping("/collaborateur/{collaborateurId}")
    public ResponseEntity<List<AssignmentResponse>> getAssignmentsByCollaborateur(@PathVariable Long collaborateurId) {
        return ResponseEntity.ok(assignmentService.getAllAssignmentsByUser(collaborateurId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
