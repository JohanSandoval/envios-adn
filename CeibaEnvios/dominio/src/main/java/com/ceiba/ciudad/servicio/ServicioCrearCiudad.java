package com.ceiba.ciudad.servicio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearCiudad {

    private static final String LA_CIUDAD_YA_ESTA_REGISTRADA = "La ciudad ya esta registrada en el sistema";

    private final RepositorioCiudad repositorioCiudad;

    public ServicioCrearCiudad(RepositorioCiudad repositorioCiudad) {
        this.repositorioCiudad = repositorioCiudad;
    }

    public Long ejecutar(Ciudad ciudad){
        validarExistenciaPrevia(ciudad);
        return  this.repositorioCiudad.crear(ciudad);
    }

    public void validarExistenciaPrevia(Ciudad ciudad){
        boolean existe = this.repositorioCiudad.existe(ciudad.getNombre());
        if (existe){
            throw new ExcepcionDuplicidad(LA_CIUDAD_YA_ESTA_REGISTRADA);
        }
    }
}
