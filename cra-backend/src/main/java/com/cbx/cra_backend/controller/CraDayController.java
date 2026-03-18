package com.cbx.cra_backend.controller;

import com.cbx.cra_backend.Utils.responses.CraDayResponse;
import com.cbx.cra_backend.dto.CraDayDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cbx.cra_backend.service.CraDayService;

import java.util.List;

@RestController
@RequestMapping("/api/cradays")
@RequiredArgsConstructor
public class CraDayController {

    private final CraDayService craDayService;

    @PostMapping
    public ResponseEntity<CraDayResponse> saveDay(@Valid @RequestBody CraDayDto dto) {
        return new ResponseEntity<>(craDayService.saveDay(dto), HttpStatus.CREATED);
    }

    @PostMapping("/autofill/{craId}")
    public ResponseEntity<List<CraDayResponse>> autoFillCra(@PathVariable Long craId) {
        return new ResponseEntity<>(craDayService.autoFillCra(craId), HttpStatus.CREATED);
    }

    @GetMapping("/cra/{craId}")
    public ResponseEntity<List<CraDayResponse>> getAllDaysForCra(@PathVariable Long craId) {
        return ResponseEntity.ok(craDayService.getAllDaysForCra(craId));
    }
}
