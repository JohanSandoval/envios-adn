package com.ceiba.dias_espera.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDiasEspera {

    private Long id;
    private Long idCiudadO;
    private Long idCiudadD;
    private Double dias;

}
