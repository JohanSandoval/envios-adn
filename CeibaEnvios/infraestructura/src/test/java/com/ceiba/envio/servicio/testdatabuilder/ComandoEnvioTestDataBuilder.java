package com.ceiba.envio.servicio.testdatabuilder;

import com.ceiba.envio.comando.ComandoEnvio;

public class ComandoEnvioTestDataBuilder {

    private Long id;
    private String cedulaRemitente;
    private String cedulaDestinatario;
    private double peso;

    public ComandoEnvioTestDataBuilder(){
        this.cedulaRemitente = "12345678";
        this.cedulaDestinatario = "87654321";
        this.peso = 10;
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
        return new ComandoEnvio(id, cedulaRemitente, cedulaDestinatario, peso);
    }
}
