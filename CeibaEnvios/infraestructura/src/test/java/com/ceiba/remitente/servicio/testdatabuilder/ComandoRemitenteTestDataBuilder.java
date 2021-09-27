package com.ceiba.remitente.servicio.testdatabuilder;

import com.ceiba.remitente.comando.ComandoRemitente;

import java.util.UUID;

public class ComandoRemitenteTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String telefono;

    public ComandoRemitenteTestDataBuilder(){

        this.cedula = "111234567";
        this.nombre = "NombreR";
        this.apellido ="ApellidoR";
        this.ciudad = "CALI";
        this.telefono = "5553331";
    }

    public ComandoRemitenteTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public ComandoRemitenteTestDataBuilder conCiudad(String ciudad){
        this.ciudad = ciudad;
        return this;
    }

    public ComandoRemitenteTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoRemitente build(){
        return new ComandoRemitente(id, cedula, nombre, apellido, ciudad, telefono);
    }

}
