package com.ceiba.ciudad;

import com.ceiba.BasePrueba;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.ciudad.servicio.ServicioCrearCiudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCiudadTest {

    @Test
    public void validarExistenciaPreviaCiudadTest(){

        //arrange
        Ciudad ciudad = new CiudadTestDataBuilder().build();
        RepositorioCiudad repositorioCiudad = Mockito.mock(RepositorioCiudad.class);
        Mockito.when(repositorioCiudad.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCiudad servicioCrearCiudad = new ServicioCrearCiudad(repositorioCiudad);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearCiudad.ejecutar(ciudad), ExcepcionDuplicidad.class, "La ciudad ya esta registrada en el sistema");
    }

    @Test
    public void validarCrearCiudadTest(){
        //arrange
        Long id = 2L;
        Ciudad ciudad = new CiudadTestDataBuilder().build();
        RepositorioCiudad repositorioCiudad = Mockito.mock(RepositorioCiudad.class);
        Mockito.when(repositorioCiudad.crear(ciudad)).thenReturn(id);
        ServicioCrearCiudad servicioCrearCiudad = new ServicioCrearCiudad(repositorioCiudad);

        Long respuesta = servicioCrearCiudad.ejecutar(ciudad);

        //act - assert
        Assert.assertEquals(id, respuesta);
    }
}
