package com.ceiba.costo_envio.servicio.testdatabuilder;

import com.ceiba.costo_envio.comando.ComandoCostoEnvio;

import java.math.BigDecimal;

public class ComandoCostoEnvioTestDataBuilder {

    private Long id;
    private Double pesoMin;
    private Double pesoMax;
    private BigDecimal costo;

    public ComandoCostoEnvioTestDataBuilder() {
        this.pesoMin = 0.1D;
        this.pesoMax = 10D;
        this.costo =  new BigDecimal(5000);
    }

    public ComandoCostoEnvioTestDataBuilder conPesoMin(Double pesoMin){
        this.pesoMin = pesoMin;
        return this;
    }

    public ComandoCostoEnvioTestDataBuilder conPesoMax(Double pesoMax){
        this.pesoMax = pesoMax;
        return this;
    }

    public ComandoCostoEnvioTestDataBuilder conCosto(BigDecimal costo){
        this.costo = costo;
        return this;
    }

    public ComandoCostoEnvio build(){
        return new ComandoCostoEnvio(id, pesoMin, pesoMax, costo);
    }
}
