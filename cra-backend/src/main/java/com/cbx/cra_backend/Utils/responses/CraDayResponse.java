package com.cbx.cra_backend.Utils.responses;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CraDayResponse {
    private Long id;
    private Long craId;

//    private CraResponse cra;
    private LocalDate date;
    private String typeActivite;
}
