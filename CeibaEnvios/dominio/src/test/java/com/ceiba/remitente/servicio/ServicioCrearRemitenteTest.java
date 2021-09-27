package com.ceiba.remitente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearRemitenteTest {

    @Test
    public void validarCiudadExistenteTest(){
        //arrange
        RemitenteTestDataBuilder remitenteTestDataBuilder = new RemitenteTestDataBuilder().conCiudad("CARTAGENA");
        //act - assert
        BasePrueba.assertThrows(() -> remitenteTestDataBuilder.build(), ExcepcionValorInvalido.class, "Debe ingresar una ciudad valida");
    }

    @Test
    public void validarExistenciaPreviaRemitenteTest(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().build();
        RepositorioRemitente repositorioRemitente = Mockito.mock(RepositorioRemitente.class);
        Mockito.when(repositorioRemitente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearRemitente servicioCrearRemitente = new ServicioCrearRemitente(repositorioRemitente);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearRemitente.ejecutar(remitente), ExcepcionDuplicidad.class, "El remitente ya esta registrado en el sistema");
    }

    @Test
    public void validarCedulaLongitudMenor8Test(){
        //arrange
        RemitenteTestDataBuilder remitenteTestDataBuilder= new RemitenteTestDataBuilder().conCedula("123456");
        BasePrueba.assertThrows(() -> remitenteTestDataBuilder.build(), ExcepcionLongitudValor.class, "la cedula debe tener un longiturd minima de 8");

    }

}
