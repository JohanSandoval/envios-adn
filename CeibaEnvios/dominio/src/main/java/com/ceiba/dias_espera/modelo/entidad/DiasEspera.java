package com.ceiba.dias_espera.modelo.entidad;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import lombok.Getter;
import lombok.ToString;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
public class DiasEspera {

    private static final String CIUDAD_ORIGEN_OBLIGATORIA = "Se debe ingresar una ciudad de origen";
    private static final String CIUDAD_DESTINO_OBLIGATORIA = "Se debe ingresar una ciudad de destino";
    private static final String DIAS_MAYOR_A_0 = "los dias de espera tiene que se mayor a 0";

    private Long id;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Double dias;

    public DiasEspera(Long id, Ciudad ciudadOrigen, Ciudad ciudadDestino, Double dias) {

        validarObligatorio(ciudadOrigen, CIUDAD_ORIGEN_OBLIGATORIA);
        validarObligatorio(ciudadDestino, CIUDAD_DESTINO_OBLIGATORIA);
        validarPositivo(dias, DIAS_MAYOR_A_0);

        this.id = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.dias = dias;
    }
}
