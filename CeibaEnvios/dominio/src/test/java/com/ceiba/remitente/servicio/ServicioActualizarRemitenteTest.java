package com.ceiba.remitente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class ServicioActualizarRemitenteTest {

    @Test
    public void validarExistenciaPreviaRemitenteTest(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().conId(1L).build();
        RepositorioRemitente repositorioRemitente = Mockito.mock(RepositorioRemitente.class);
        Mockito.when(repositorioRemitente.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarRemitente servicioActualizarRemitente = new ServicioActualizarRemitente(repositorioRemitente);

        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRemitente.ejecutar(remitente), ExcepcionDuplicidad.class, "El remitente no esta registrado en el sistema");
    }

    @Test
    public void validarActualizarRemitenteTest(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().conId(2L).build();
        RepositorioRemitente repositorioRemitente = Mockito.mock(RepositorioRemitente.class);
        Mockito.when(repositorioRemitente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarRemitente servicioActualizarRemitente = new ServicioActualizarRemitente(repositorioRemitente);

        servicioActualizarRemitente.ejecutar(remitente);
        Long esperado = Long.valueOf(2L);

        assertEquals(esperado, remitente.getId());
    }
}
