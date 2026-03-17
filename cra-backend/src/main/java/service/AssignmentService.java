package service;

import Utils.responses.AssignmentResponse;
import dto.AssignmentDto;
import entity.Assignment;

import java.util.List;

public interface AssignmentService {

    AssignmentResponse createAssignment(AssignmentDto dto);

    List<AssignmentResponse> getAllAssignments();
    List<AssignmentResponse> getAllAssignmentsByUser(Long id);
    void deleteAssignment(Long id);
}
