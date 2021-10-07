package com.ceiba.dias_espera;

import com.ceiba.BasePrueba;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.dias_espera.servicio.ServicioActualizarDiasEspera;
import com.ceiba.dias_espera.testdatabuilder.DiasEsperaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarDiasEsperaTest {

    @Test
    public void validarExistenciaPreviaDiasEsperaTest(){
        //arrange
        DiasEspera diasEspera = new DiasEsperaTestDataBuilder().conId(1L).build();
        RepositorioDiasEspera repositorioDiasEspera = Mockito.mock(RepositorioDiasEspera.class);
        Mockito.when(repositorioDiasEspera.existeExcluyendoId(Mockito.anyLong(), Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
        ServicioActualizarDiasEspera servicioActualizarDiasEspera = new ServicioActualizarDiasEspera(repositorioDiasEspera);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDiasEspera.ejecutar(diasEspera), ExcepcionDuplicidad.class, "La ruta ya se encuentra registrada en el sistema");
    }
}
