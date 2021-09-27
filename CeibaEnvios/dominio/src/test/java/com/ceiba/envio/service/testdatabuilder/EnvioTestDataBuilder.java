package com.ceiba.envio.service.testdatabuilder;

import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;


public class EnvioTestDataBuilder {

    private static final Remitente REMITENTE = new RemitenteTestDataBuilder().build();
    private static final Destinatario DESTINATARIO = new DestinatarioTestDataBuilder().build();
    private static final Double PESO = 10D;

    private Long id;
    private Remitente remitente;
    private Destinatario destinatario;
    private double peso;

    public EnvioTestDataBuilder() {

        this.remitente = REMITENTE;
        this.destinatario = DESTINATARIO;
        this.peso = PESO;
    }

    public EnvioTestDataBuilder conPeso(Double peso){
        this.peso = peso;
        return this;
    }

    public EnvioTestDataBuilder conRemitente(Remitente remitente){
        this.remitente = remitente;
        return this;
    }

    public EnvioTestDataBuilder conDestinatario(Destinatario destinatario){
        this.destinatario = destinatario;
        return this;
    }

    public Envio build(){
        return new Envio(id, remitente, destinatario, peso);
    }

}
