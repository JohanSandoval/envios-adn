package com.ceiba.envio.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.envio.servicio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.Test;

public class ServicioCrearEnvioTest {

    @Test
    public void validarPesoMayor0Test(){
        // arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(-1);
        // act - assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), Exception.class, "Se debe ingresar un peso positivo");

    }

    @Test
    public void validarPesoMenor50Test(){
        // arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(51);
        // act - assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), Exception.class, "Se debe ingresar un peso menor a 50 kg");
    }

}
