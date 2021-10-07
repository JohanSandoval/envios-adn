package com.ceiba.dias_espera.modelo.dto;

import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDiasEspera {

    private Long id;
    private DtoCiudad ciudadOrigen;
    private DtoCiudad ciudadDestino;
    private int dias;
}
