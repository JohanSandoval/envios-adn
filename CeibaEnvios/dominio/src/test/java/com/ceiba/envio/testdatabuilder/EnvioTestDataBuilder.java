package com.ceiba.envio.testdatabuilder;

import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;

import java.awt.font.TextHitInfo;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EnvioTestDataBuilder {

    private static final Double PESO_ENVIO= 7D;
    private static final BigDecimal COSTO_ENVIO = new BigDecimal(5000);
    private static final Double DIAS_ESPERA = 1D;
    private static final String DIRECCION_ENVIO = "CALLE AV SIEMPRE VIVA";

    private Long id;
    private Usuario remitente;
    private Usuario destinatario;
    private double peso;
    private BigDecimal costo;
    private Double diasEspera;
    private String direccion;

    public EnvioTestDataBuilder() {

        Usuario usuario = new UsuarioTestDataBuilder().build();

        this.remitente = usuario;
        this.destinatario = usuario;
        this.peso = PESO_ENVIO;
        this.costo = COSTO_ENVIO;
        this.diasEspera = DIAS_ESPERA;
        this.direccion = DIRECCION_ENVIO;
    }

    public EnvioTestDataBuilder conId(){
        this.id = id;
        return this;
    }

    public EnvioTestDataBuilder conRemitente(Usuario remitente){
        this.remitente = remitente;
        return this;
    }

    public EnvioTestDataBuilder conDestinatario(Usuario destinatario){
        this.destinatario = destinatario;
        return this;
    }

    public EnvioTestDataBuilder conPeso(Double peso){
        this.peso = peso;
        return this;
    }

    public EnvioTestDataBuilder conCosto(BigDecimal costo){
        this.costo = costo;
        return this;
    }

    public EnvioTestDataBuilder conDiasEspera(Double dias){
        this.diasEspera = dias;
        return this;
    }

    public Envio build(){
        return new Envio(id, remitente, destinatario, peso, costo, diasEspera, direccion);
    }
}
