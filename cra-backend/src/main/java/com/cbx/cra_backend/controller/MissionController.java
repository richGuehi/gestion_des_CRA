package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.MissionResponse;
import com.cbx.cra_backend.dto.MissionDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.MissionService;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping
    public ResponseEntity<MissionResponse> createMission(@Valid @RequestBody MissionDto dto) {
        return new ResponseEntity<>(missionService.createMissions(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MissionResponse>> getAllMissions() {
        return ResponseEntity.ok(missionService.getAllMissions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionResponse> getMissionById(@PathVariable Long id) {
        return ResponseEntity.ok(missionService.getMissionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionResponse> updateMission(@PathVariable Long id, @Valid @RequestBody MissionDto dto) {
        return ResponseEntity.ok(missionService.updateMission(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable Long id) {
        missionService.deleteMissionById(id);
        return ResponseEntity.noContent().build();
    }

}
