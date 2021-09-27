package com.ceiba.envio.service;

import com.ceiba.BasePrueba;
import com.ceiba.destinatario.servicio.testdatabuilder.DestinatarioTestDataBuilder;
import com.ceiba.destinatatio.modelo.entidad.Destinatario;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.puerto.repositorio.RepositorioEnvio;
import com.ceiba.envio.service.testdatabuilder.EnvioTestDataBuilder;
import com.ceiba.remitente.modelo.entidad.Remitente;
import com.ceiba.remitente.puerto.repositorio.RepositorioRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.RemitenteTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearEnvio {

    @Test
    public void validarPesoPositivo(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().build();
        Destinatario destinatario = new DestinatarioTestDataBuilder().build();
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(-10D).conDestinatario(destinatario).conRemitente(remitente);

        //act -assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar un peso positivo");
    }

    @Test
    public void validarPesoMaximo50(){
        //arrange
        Remitente remitente = new RemitenteTestDataBuilder().build();
        Destinatario destinatario = new DestinatarioTestDataBuilder().build();
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(51D).conDestinatario(destinatario).conRemitente(remitente);

        //act -assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar un peso menor a 50 kg");
    }

}
