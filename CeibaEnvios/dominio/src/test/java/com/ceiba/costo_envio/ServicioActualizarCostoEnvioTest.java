package com.ceiba.costo_envio;

import com.ceiba.BasePrueba;
import com.ceiba.costo_envio.modelo.entidad.CostoEnvio;
import com.ceiba.costo_envio.puerto.repositorio.RepositorioCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioActualizarCostoEnvio;
import com.ceiba.costo_envio.servicio.ServicioCrearCostoEnvio;
import com.ceiba.costo_envio.testdatabuilder.CostoEnvioTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarCostoEnvioTest {

    @Test
    public void validarExistenciaPreviaCostoEnvioTest(){
        //arrange
        CostoEnvio costoEnvio = new CostoEnvioTestDataBuilder().conId(1L).build();
        RepositorioCostoEnvio repositorioCostoEnvio = Mockito.mock(RepositorioCostoEnvio.class);
        Mockito.when(repositorioCostoEnvio.existeExcluyendoId(Mockito.anyLong(), Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(true);
        ServicioActualizarCostoEnvio servicioActualizarCostoEnvio = new ServicioActualizarCostoEnvio(repositorioCostoEnvio);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCostoEnvio.ejecutar(costoEnvio), ExcepcionDuplicidad.class, "El costo no ha sido encontrado");
    }
}
