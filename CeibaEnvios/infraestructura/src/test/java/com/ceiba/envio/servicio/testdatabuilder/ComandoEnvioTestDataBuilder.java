package com.ceiba.envio.servicio.testdatabuilder;

import com.ceiba.envio.comando.ComandoEnvio;

import java.util.UUID;

public class ComandoEnvioTestDataBuilder {

    private String nombre;
    private String apellido;
    private String telefono;

    private int ciudadOrigen;
    private int ciudadDestino;
    private double peso;

    public ComandoEnvioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        apellido = UUID.randomUUID().toString();
        telefono = "123456789";
        ciudadOrigen = 1;
        ciudadDestino = 2;
        peso = 13;
    }

    public ComandoEnvioTestDataBuilder conNombreCiudadOrigenCiudadDestino(int ciudadOrigen, int ciudadDestino, double peso) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.peso = peso;
        return this;
    }

    public ComandoEnvio build(){
        return new ComandoEnvio(nombre, apellido, telefono, ciudadOrigen, ciudadDestino, peso);
    }

}
