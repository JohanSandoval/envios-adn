package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Long ciudad;
    private String telefono;

    public ComandoUsuarioTestDataBuilder() {

        this.cedula = "87654321";
        this.nombre = "Destinatario Nombre";
        this.apellido = "Destinatario Apellido";
        this.ciudad = 1L;
        this.telefono = "1112223";
    }

    public ComandoUsuarioTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCiudad(Long ciudad){
        this.ciudad = ciudad;
        return this;
    }

    public ComandoUsuario build(){
        return new ComandoUsuario(this.id, this.cedula, this.nombre, this.apellido, this.ciudad, this.telefono);
    }

}
