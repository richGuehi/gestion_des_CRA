package service.impl;

import Utils.responses.AssignmentResponse;
import dto.AssignmentDto;
import entity.Assignment;
import entity.Mission;
import entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repository.AssignmentRepository;
import repository.MissionRepository;
import repository.UserRepository;
import service.AssignmentService;
import service.MissionService;
import transformer.AssignmentTransformer;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final AssignmentTransformer assignmentTransformer;


    @Override
    public AssignmentResponse createAssignment(AssignmentDto dto) {

        if (dto.getDateFin() != null && dto.getDateFin().isBefore(dto.getDateDebut()) ) {
            throw new IllegalArgumentException("Date de fin ne peut etre avant la date de debut");
        }

        // recuparation des entity
        User user = userRepository.findById(dto.getCollaborateurId())
                .orElseThrow(() -> new RuntimeException("User introuvablele avec Id : "+ dto.getCollaborateurId()));

        Mission mission = missionRepository.findById(dto.getMissionId())
                .orElseThrow(() -> new RuntimeException("Mission introuvablele"));

        Assignment assignment = assignmentTransformer.toEntity(dto, user, mission);

        //save
        assignment = assignmentRepository.save(assignment);

        return assignmentTransformer.toDto(assignment);
    }

    @Override
    public List<AssignmentResponse> getAllAssignments() {
        return assignmentRepository.findAll().stream()
                .map(assignmentTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AssignmentResponse> getAllAssignmentsByUser(Long id) {
        return assignmentRepository.findByCollaborateurId(id).stream()
                .map(assignmentTransformer::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAssignment(Long id) {
        if(!assignmentRepository.existsById(id)) {
            throw new RuntimeException("Affectation introuvable ");
        }
        assignmentRepository.deleteById(id);
    }
}
