package com.ceiba.costo_envio.modelo.entidad;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
@ToString
public class CostoEnvio {

    private static final String PESO_MINIMO_OBLIGATORIO = "Se debe ingresar un peso minimo";
    private static final String PESO_MAXIMO_OBLIGATORIO = "Se debe ingresar un peso maximo";
    private static final String COSTO_OBLIGATORIO = "Se debe de ingresar un costo";
    private static final String PESO_POSITIVO = "Se debe inbresar un peso positivooo";
    private static final String PESO_MINIMO_MENOR_QUE_MAXIMO = "El peso minimo debe de ser menor que el peso maximo";

    private Long id;
    private Double pesoMax;
    private Double pesoMin;
    private BigDecimal costo;

    public CostoEnvio(Long id, Double pesoMin, Double pesoMax, BigDecimal costo) {

        validarObligatorio(pesoMin, PESO_MINIMO_OBLIGATORIO);
        validarPositivo(pesoMin, PESO_POSITIVO);
        validarObligatorio(pesoMax, PESO_MAXIMO_OBLIGATORIO);
        validarPositivo(pesoMax, PESO_POSITIVO);
        validarMenor(pesoMin, pesoMax, PESO_MINIMO_MENOR_QUE_MAXIMO);
        validarObligatorio(costo, COSTO_OBLIGATORIO);


        this.id = id;
        this.pesoMax = pesoMax;
        this.pesoMin = pesoMin;
        this.costo = costo;
    }
}
