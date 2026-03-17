package service;

import Utils.responses.CraResponse;
import dto.CraDto;

import java.util.List;

public interface CraService {

    CraResponse createCra(CraDto dto);
    CraResponse getCraById(Long id);
    List<CraResponse> getCrasByCollaborateur(Long userId);

    CraResponse submitCra(Long id);
    CraResponse updateCra(Long id, String newStatus, String motifRejet);

}