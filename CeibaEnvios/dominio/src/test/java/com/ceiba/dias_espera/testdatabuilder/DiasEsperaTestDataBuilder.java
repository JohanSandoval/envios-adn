package com.ceiba.dias_espera.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;

public class DiasEsperaTestDataBuilder {

    private static final Double DIAS_ESPERA = 1D;

    private Long id;
    private Ciudad ciudadOrigen;
    private Ciudad ciudadDestino;
    private Double dias;

    public DiasEsperaTestDataBuilder() {
        Ciudad origen = new CiudadTestDataBuilder().build();
        Ciudad destino = new CiudadTestDataBuilder().build();

        this.ciudadOrigen = origen;
        this.ciudadDestino = destino;
        this.dias = DIAS_ESPERA;
    }

    public DiasEsperaTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public DiasEsperaTestDataBuilder conCiudadOrigen(Ciudad ciudad){
        this.ciudadOrigen = ciudad;
        return this;
    }
    public DiasEsperaTestDataBuilder conCiudadDestino(Ciudad ciudad){
        this.ciudadDestino = ciudad;
        return this;
    }

    public DiasEsperaTestDataBuilder conDias(Double dias){
        this.dias = dias;
        return this;
    }

    public DiasEspera build(){
        return new DiasEspera(this.id, this.ciudadOrigen, this.ciudadDestino, this.dias);
    }

}
