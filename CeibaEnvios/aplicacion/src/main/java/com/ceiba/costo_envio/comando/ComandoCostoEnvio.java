package com.ceiba.costo_envio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCostoEnvio {

    private Long id;
    private Double pesoMin;
    private Double pesoMax;
    private BigDecimal costo;
}
