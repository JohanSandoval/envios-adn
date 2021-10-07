package com.ceiba.costo_envio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoCostoEnvio {

    private Long id;
    private Double pesoMax;
    private Double pesoMin;
    private BigDecimal costo;
}
