package com.ceiba.envio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.envio.modelo.entidad.Envio;
import com.ceiba.envio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCrearEnvioTest {

    @Test
    public void validarExistenciaRemitenteTest(){
        //arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conRemitente(null);
        //act -assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar un remitente");
    }
    @Test
    public void validarExistenciaDestinatarioTest(){
        //arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conDestinatario(null);
        //act - assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar destinatario");
    }

    @Test
    public void validarPesoPositivoTest(){
        //arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(-1D);
        //act -assert
        BasePrueba.assertThrows(()-> envioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar un peso positivo");
    }

    @Test
    public void validarPesoMenorA50Test(){
        //arrange
        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder().conPeso(51D);
        //act - assert
        BasePrueba.assertThrows(() -> envioTestDataBuilder.build(), ExcepcionValorInvalido.class, "Se debe ingresar un peso maximo a 50 kg");
    }

    @Test
    public void validarCostoTotalEnvioTest(){
        //arrange
        BigDecimal costoKl = new BigDecimal(5000);
        Double peso = 5D;
        Envio envio = new EnvioTestDataBuilder().conPeso(peso).conCosto(costoKl).build();
        BigDecimal costoEnvio = calcularCostoTotal(costoKl, peso);

        //act - assert
        Assert.assertEquals(costoEnvio, envio.getCosto());
    }

    @Test
    public void validarFechaLlegadaTest(){
        //arrange
        Double diasEspera = 3D;
        Envio envio = new EnvioTestDataBuilder().conDiasEspera(diasEspera).build();
        LocalDate fechaLlegada = calcularFechaLlegada(diasEspera);

        //act - assert
        Assert.assertEquals(fechaLlegada, envio.getFechaEstimadaLlegada());
    }

    private BigDecimal calcularCostoTotal(BigDecimal costoKl, Double peso){
        BigDecimal pesoBD = new BigDecimal(peso);
        return costoKl.multiply(pesoBD);
    }

    private LocalDate calcularFechaLlegada(Double diasHabiles){
        LocalDate result = LocalDate.now();
        int addedDays = 0;
        while (addedDays < diasHabiles) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

}
