package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.CraResponse;
import com.cbx.cra_backend.dto.CraDto;

import java.util.List;

public interface CraService {

    CraResponse createCra(CraDto dto);
    CraResponse getCraById(Long id);
    List<CraResponse> getCrasByCollaborateur(Long userId);

    CraResponse submitCra(Long id);
    CraResponse updateCra(Long id, String newStatus, String motifRejet);

}