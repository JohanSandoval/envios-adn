package com.ceiba.envio.servicio.testdatabuilder;

import com.ceiba.envio.comando.ComandoEnvio;

public class ComandoEnvioTestDataBuilder {

    private Long id;
    private String cedulaRemitente;
    private String cedulaDestinatario;
    private double peso;
    private String direccion;


    public ComandoEnvioTestDataBuilder(){
        this.cedulaRemitente = "12345678";
        this.cedulaDestinatario = "12345678";
        this.peso = 7;
        this.direccion = "Av 75 a sur";
    }

    public ComandoEnvioTestDataBuilder conCedulaRemitente(String cedulaRemitente){
        this.cedulaRemitente = cedulaRemitente;
        return this;
    }

    public ComandoEnvioTestDataBuilder conCedulaDestinatario(String cedulaDestinatario){
        this.cedulaDestinatario = cedulaDestinatario;
        return this;
    }

    public ComandoEnvioTestDataBuilder conPeso(Double peso){
        this.peso = peso;
        return this;
    }

    public ComandoEnvioTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoEnvio build(){
        return new ComandoEnvio(id, cedulaRemitente, cedulaDestinatario, peso, direccion);
    }
}
