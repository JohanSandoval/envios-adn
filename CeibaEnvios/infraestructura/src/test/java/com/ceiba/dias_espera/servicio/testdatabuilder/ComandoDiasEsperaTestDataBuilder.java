package com.ceiba.dias_espera.servicio.testdatabuilder;

import com.ceiba.dias_espera.comando.ComandoDiasEspera;

public class ComandoDiasEsperaTestDataBuilder {

    private Long id;
    private Long idCiudadO;
    private Long idCiudadD;
    private Double dias;

    public ComandoDiasEsperaTestDataBuilder() {

        this.idCiudadO = 1L;
        this.idCiudadD = 2L;
        this.dias = 2D;
    }

    public ComandoDiasEsperaTestDataBuilder conCiudadO(Long id){
        this.idCiudadO = id;
        return this;
    }

    public ComandoDiasEsperaTestDataBuilder conCiudadD(Long id){
        this.idCiudadD = id;
        return this;
    }

    public ComandoDiasEsperaTestDataBuilder conDias(Double dias){
        this.dias = dias;
        return this;
    }

    public ComandoDiasEspera build(){
        return new ComandoDiasEspera(this.id, this.idCiudadO, this.idCiudadD, this.dias);
    }
}
