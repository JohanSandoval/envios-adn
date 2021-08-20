package com.ceiba.envio.servicio.testdatabuilder;

import com.ceiba.envio.modelo.entidad.Envio;

public class EnvioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;

    private int ciudadOrigen;
    private int ciudadDestino;
    private double peso;

    public EnvioTestDataBuilder() {
        nombre = "juan";
        apellido = "perez";
        telefono = "123456789";
        ciudadOrigen = 1;
        ciudadDestino = 2;
        peso = 15;
    }

    public EnvioTestDataBuilder conCiudades(int ciudadOrigen, int ciudadDestino) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        return this;
    }

    public EnvioTestDataBuilder conPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public Envio build(){
        return new Envio(nombre, apellido, telefono, ciudadOrigen, ciudadDestino, peso);
    }
}
