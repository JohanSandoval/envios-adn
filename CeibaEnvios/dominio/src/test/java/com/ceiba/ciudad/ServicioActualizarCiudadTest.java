package com.ceiba.ciudad;

import com.ceiba.BasePrueba;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.ciudad.puerto.repositorio.RepositorioCiudad;
import com.ceiba.ciudad.servicio.ServicioActualizarCiudad;
import com.ceiba.ciudad.testdatabuilder.CiudadTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class ServicioActualizarCiudadTest {

    @Test
    public void validarExistenciaPreviaCiudadTest(){
        //arrange
        Ciudad ciudad = new CiudadTestDataBuilder().conId(2L).build();
        RepositorioCiudad repositorioCiudad = Mockito.mock((RepositorioCiudad.class));
        Mockito.when(repositorioCiudad.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCiudad servicioActualizarCiudad = new ServicioActualizarCiudad(repositorioCiudad);

        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCiudad.ejecutar(ciudad),
                ExcepcionDuplicidad.class, "La ciudad no esta registrada en el sistema");
    }

    @Test
    public void validarActualizarCiudadTest(){
        //arrage
        Ciudad ciudad = new CiudadTestDataBuilder().conId(2L).build();
        RepositorioCiudad repositorioCiudad = Mockito.mock(RepositorioCiudad.class);
        Mockito.when(repositorioCiudad.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarCiudad servicioActualizarCiudad = new ServicioActualizarCiudad(repositorioCiudad);

        //act -assert
        servicioActualizarCiudad.ejecutar(ciudad);
        Long esperado = Long.valueOf(2l);

        assertEquals(esperado, ciudad.getId());
    }
}
