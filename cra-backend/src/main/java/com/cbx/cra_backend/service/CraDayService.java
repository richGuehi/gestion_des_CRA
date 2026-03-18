package com.cbx.cra_backend.service;

import com.cbx.cra_backend.Utils.responses.CraDayResponse;
import com.cbx.cra_backend.dto.CraDayDto;

import java.util.List;

public interface CraDayService {

    CraDayResponse saveDay(CraDayDto dto);
    List<CraDayResponse> autoFillCra(Long craId);
    List<CraDayResponse> getAllDaysForCra(Long craId);
}
