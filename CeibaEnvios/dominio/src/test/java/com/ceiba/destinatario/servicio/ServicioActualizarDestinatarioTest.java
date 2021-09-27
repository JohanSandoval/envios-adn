package com.ceiba.destinatario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.destinatatio.servicio.ServicioActualizarDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class ServicioActualizarDestinatarioTest {

    @Test
    public void validarExistenciaPreviaDestinatarioTest() {
        //arrange
        Destinatario destinatario = new DestinatarioTestDataBuilder().build();
        RepositorioDestinatario repositorioDestinatario = Mockito.mock(RepositorioDestinatario.class);
        Mockito.when(repositorioDestinatario.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarDestinatario servicioActualizarDestinatario = new ServicioActualizarDestinatario(repositorioDestinatario);

        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarDestinatario.ejecutar(destinatario), ExcepcionDuplicidad.class, "El destinatario no esta registrado en el sistema");
    }

    @Test
    public void validarActualizarDestinatarioTest(){
        //arrange
        Destinatario destinatario = new DestinatarioTestDataBuilder().conId(2L).build();
        RepositorioDestinatario repositorioDestinatario = Mockito.mock(RepositorioDestinatario.class);
        Mockito.when(repositorioDestinatario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarDestinatario servicioActualizarDestinatario = new ServicioActualizarDestinatario(repositorioDestinatario);

        //act - assert
        servicioActualizarDestinatario.ejecutar(destinatario);
        Long esperado = Long.valueOf(2L);

        assertEquals(esperado, destinatario.getId());
    }

}
