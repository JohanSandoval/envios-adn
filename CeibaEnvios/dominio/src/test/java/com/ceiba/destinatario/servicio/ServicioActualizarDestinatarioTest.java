package com.ceiba.destinatario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.destinatatio.servicio.ServicioActualizarDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.ServicioActualizarRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

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

}
