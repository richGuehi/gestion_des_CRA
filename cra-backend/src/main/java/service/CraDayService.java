package service;

import Utils.responses.CraDayResponse;
import dto.CraDayDto;

import java.util.List;

public interface CraDayService {

    CraDayResponse saveDay(CraDayDto dto);
    List<CraDayResponse> autoFillCra(Long craId);
    List<CraDayResponse> getAllDaysForCra(Long craId);
}
