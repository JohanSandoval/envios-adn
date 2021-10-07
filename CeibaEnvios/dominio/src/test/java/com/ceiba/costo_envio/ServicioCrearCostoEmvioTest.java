package com.ceiba.costo_envio;


import com.ceiba.BasePrueba;
import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioCrearCostoEnvio;
import com.ceiba.costo_envio.testdatabuilder.CostoEnvioTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class ServicioCrearCostoEmvioTest {

    @Test
    public void validarPesoMaximoPositivoTest(){
        //arrange
        CostoEnvioTestDataBuilder costoEnvioTestDataBuilder = new CostoEnvioTestDataBuilder().conPesoMaximo(-1D);
        //act - assert
        BasePrueba.assertThrows(() -> costoEnvioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe inbresar un peso positivo");
    }

    @Test
    public void validarPesoMinimoPositivoTest(){
        //arrange
        CostoEnvioTestDataBuilder costoEnvioTestDataBuilder = new CostoEnvioTestDataBuilder().conPesoMinimo(-1D);
        //act - assert
        BasePrueba.assertThrows(() -> costoEnvioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe inbresar un peso positivo");
    }

    @Test
    public void validarPesoMinimoMenorQuePesoMaximoTest(){
        //arrange
        CostoEnvioTestDataBuilder costoEnvioTestDataBuilder = new CostoEnvioTestDataBuilder().conPesoMaximo(2D).conPesoMinimo(3D);
        //act -aseert
        BasePrueba.assertThrows(() -> costoEnvioTestDataBuilder.build(), ExcepcionValorInvalido.class, "El peso minimo debe de ser menor que el peso maximo");
    }

    @Test
    public void validarCrearCostoEnvioTest(){
        Long id = 2L;
        CostoEnvio costoEnvio = new CostoEnvioTestDataBuilder().build();
        RepositorioCostoEnvio repositorioCostoEnvio = Mockito.mock(RepositorioCostoEnvio.class);
        Mockito.when(repositorioCostoEnvio.crear(costoEnvio)).thenReturn(id);
        ServicioCrearCostoEnvio servicioCrearCostoEnvio = new ServicioCrearCostoEnvio(repositorioCostoEnvio);

        Long respuesta = servicioCrearCostoEnvio.ejecutar(costoEnvio);

        Assert.assertEquals(id,respuesta);
    }
}
