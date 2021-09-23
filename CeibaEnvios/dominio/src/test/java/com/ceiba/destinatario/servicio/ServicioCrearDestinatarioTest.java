package com.ceiba.destinatario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.destinatatio.puerto.repositorio.RepositorioDestinatario;
import com.ceiba.destinatatio.servicio.ServicioCrearDestinatario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.ServicioCrearRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearDestinatarioTest {

    @Test
    public void validarCiudadExistente(){
        //arrange
        DestinatarioTestDataBuilder destinatarioTestDataBuilder = new DestinatarioTestDataBuilder().conCiudad("CARTAGENA");
        //act - assert
        BasePrueba.assertThrows(() -> destinatarioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Debe ingresar una ciudad valida");
    }

    @Test
    public void validarExistenciaPreviaDestinatario(){
        //arrange
        Destinatario destinatario = new DestinatarioTestDataBuilder().build();
        RepositorioDestinatario repositorioDestinatario = Mockito.mock(RepositorioDestinatario.class);
        Mockito.when(repositorioDestinatario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearDestinatario servicioCrearDestinatario = new ServicioCrearDestinatario(repositorioDestinatario);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearDestinatario.ejecutar(destinatario), ExcepcionDuplicidad.class, "El destinatario ya esta registrado en el sistema");
    }


}
