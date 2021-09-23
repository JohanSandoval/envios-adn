package com.ceiba.remitente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarRemitenteTest {

    @Test
    public void validarExistenciaPreviaRemitenteTest(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().build();
        RepositorioRemitente repositorioRemitente = Mockito.mock(RepositorioRemitente.class);
        Mockito.when(repositorioRemitente.existe(Mockito.anyString())).thenReturn(true);
        ServicioActualizarRemitente servicioActualizarRemitente = new ServicioActualizarRemitente(repositorioRemitente);

        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarRemitente.ejecutar(remitente), ExcepcionDuplicidad.class, "El remitente no esta registrado en el sistema");
    }

}
