package com.ceiba.usuario.testdatabuilder;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

    private static final String CEDULA_USUARIO = "10101010";
    private static final String NOMBRE_USUARIO = "Juan";
    private static final String APELLIDO_USUARIO = "Perez";
    private static final String TELEFONO_USUARIO = "5552221";

    private Long id;
    private String cedula;
    private String nombre;
    private String apellido;
    private Ciudad ciudad;
    private String telefono;

    public UsuarioTestDataBuilder() {

        Ciudad ciudad = new CiudadTestDataBuilder().build();

        this.cedula = CEDULA_USUARIO;
        this.nombre = NOMBRE_USUARIO;
        this.apellido = APELLIDO_USUARIO;
        this.ciudad = ciudad;
        this.telefono = TELEFONO_USUARIO;
    }


    public UsuarioTestDataBuilder conCedula(String cedula){
        this.cedula = cedula;
        return this;
    }

    public UsuarioTestDataBuilder conCiudad(Ciudad ciudad){
        this.ciudad = ciudad;
        return this;
    }

    public UsuarioTestDataBuilder conid(Long id){
        this.id = id;
        return this;
    }

    public Usuario build(){
        return new Usuario(this.id, this.cedula, this.nombre, this.apellido, this.ciudad, this.telefono);
    }
}
