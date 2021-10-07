package com.ceiba.dias_espera;

import com.ceiba.BasePrueba;
import com.ceiba.dias_espera.modelo.entidad.DiasEspera;
import com.ceiba.dias_espera.puerto.repositorio.RepositorioDiasEspera;
import com.ceiba.dias_espera.servicio.ServicioCrearDiasEspera;
import com.ceiba.dias_espera.testdatabuilder.DiasEsperaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearDiasEsperaTest {

    @Test
    public void validaCiudadOrigenExistenteTest(){
        //arrange
        DiasEsperaTestDataBuilder diasEsperaTestDataBuilder = new DiasEsperaTestDataBuilder().conCiudadOrigen(null);
        //act - assert
        BasePrueba.assertThrows(() -> diasEsperaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar una ciudad de origen");
    }
    @Test
    public void validaCiudadDestinoExistenteTest(){
        //arrange
        DiasEsperaTestDataBuilder diasEsperaTestDataBuilder = new DiasEsperaTestDataBuilder().conCiudadDestino(null);
        //act - assert
        BasePrueba.assertThrows(() -> diasEsperaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar una ciudad de destino");
    }

    @Test
    public void validarNumeroDiasPositivoTest(){
        //arrange
        DiasEsperaTestDataBuilder diasEsperaTestDataBuilder = new DiasEsperaTestDataBuilder().conDias(0D);
        //act - assert
        BasePrueba.assertThrows(() -> diasEsperaTestDataBuilder.build(), ExcepcionValorInvalido.class, "los dias de espera tiene que se mayor a 0");
    }

    @Test
    public void validarExistenciaPreviaTest(){
        //arrange
        DiasEspera diasEspera = new DiasEsperaTestDataBuilder().build();
        RepositorioDiasEspera repositorioDiasEspera = Mockito.mock(RepositorioDiasEspera.class);
        Mockito.when(repositorioDiasEspera.existe(Mockito.anyLong(),Mockito.anyLong())).thenReturn(true);
        ServicioCrearDiasEspera servicioCrearDiasEspera = new ServicioCrearDiasEspera(repositorioDiasEspera);
        //act - assert
        BasePrueba.assertThrows(() -> servicioCrearDiasEspera.ejecutar(diasEspera), ExcepcionDuplicidad.class, "la ruta ya esta definida en el sistema" );
    }

    @Test
    public void crearDiasEsperaTest(){
        //arrange
        Long id = 2L;
        DiasEspera diasEspera = new DiasEsperaTestDataBuilder().build();
        RepositorioDiasEspera repositorioDiasEspera = Mockito.mock(RepositorioDiasEspera.class);
        Mockito.when(repositorioDiasEspera.crear(diasEspera)).thenReturn(id);
        ServicioCrearDiasEspera servicioCrearDiasEspera = new ServicioCrearDiasEspera(repositorioDiasEspera);

        Long repuesta = servicioCrearDiasEspera.ejecutar(diasEspera);
        //act - assert
        Assert.assertEquals(id, repuesta);
    }
}
