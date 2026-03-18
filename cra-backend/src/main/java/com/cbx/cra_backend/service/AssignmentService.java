package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.AssignmentResponse;
import com.cbx.cra_backend.dto.AssignmentDto;

import java.util.List;

public interface AssignmentService {

    AssignmentResponse createAssignment(AssignmentDto dto);

    List<AssignmentResponse> getAllAssignments();
    List<AssignmentResponse> getAllAssignmentsByUser(Long id);
    void deleteAssignment(Long id);
}
