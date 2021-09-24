package com.ceiba.envio.service.testdatabuilder;

import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EnvioTestDataBuilder {

    private static final Remitente REMITENTE = new RemitenteTestDataBuilder().build();
    private static final Destinatario DESTINATARIO = new DestinatarioTestDataBuilder().build();
    private static final Double PESO = 10D;

    private Remitente remitente;
    private Destinatario destinatario;
    private double peso;


    public EnvioTestDataBuilder() {

        this.remitente = REMITENTE;
        this.destinatario = DESTINATARIO;
        this.peso = PESO;
    }


}
