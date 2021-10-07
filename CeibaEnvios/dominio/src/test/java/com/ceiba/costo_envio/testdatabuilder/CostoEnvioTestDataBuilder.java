package com.ceiba.costo_envio.testdatabuilder;

import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;

import java.math.BigDecimal;

public class CostoEnvioTestDataBuilder {

    private static final Double PESO_MAXIMO = 10D;
    private static final Double PESO_MINIMO = 1D;
    private static final BigDecimal COSTO_ENVIO = new BigDecimal(5000);


    private Long id;
    private Double pesoMax;
    private Double pesoMin;
    private BigDecimal costo;

    public CostoEnvioTestDataBuilder() {

        this.pesoMax = PESO_MAXIMO;
        this.pesoMin = PESO_MINIMO;
        this.costo = COSTO_ENVIO;
    }

    public CostoEnvioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public CostoEnvioTestDataBuilder conPesoMaximo(Double pesoMax){
        this.pesoMax = pesoMax;
        return this;
    }

    public CostoEnvioTestDataBuilder conPesoMinimo(Double pesoMin){
        this.pesoMin = pesoMin;
        return this;
    }

    public CostoEnvioTestDataBuilder conCosto(BigDecimal costo){
        this.costo = costo;
        return this;
    }

    public CostoEnvio build(){
        return new CostoEnvio(id, pesoMax, pesoMin, costo);
    }

}
