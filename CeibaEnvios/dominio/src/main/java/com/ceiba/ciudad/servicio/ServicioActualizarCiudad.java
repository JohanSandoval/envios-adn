package com.ceiba.ciudad.servicio;

import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCiudad {

    private static final String LA_CIUDAD_NO_ESTA_REGISTRADA = "La ciudad no esta registrada en el sistema";

    private final RepositorioCiudad repositorioCiudad;

    public ServicioActualizarCiudad(RepositorioCiudad repositorioCiudad) {
        this.repositorioCiudad = repositorioCiudad;
    }

    public void ejecutar(Ciudad ciudad){
        validarExistenciaPrevia(ciudad);
        this.repositorioCiudad.actualizar(ciudad);
    }

    public void validarExistenciaPrevia(Ciudad ciudad){
        boolean existe = this.repositorioCiudad.existeExcluyendoId(ciudad.getId(), ciudad.getNombre());
        System.out.println(existe);
        if (existe){
            throw new ExcepcionDuplicidad(LA_CIUDAD_NO_ESTA_REGISTRADA);
        }
    }
}
