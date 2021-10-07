package com.ceiba.costo_envio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.costo_envio.comando.ComandoCostoEnvio;
import com.ceiba.costo_envio.servicio.testdatabuilder.ComandoCostoEnvioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCostoEnvio.class)
public class ComandoControladorCostoEnvioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    public void crear() throws Exception{
        //arrange
        ComandoCostoEnvio comandoCostoEnvio = new ComandoCostoEnvioTestDataBuilder().build();
        //act - assert
        mockMvc.perform(post("/costoEnvio")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCostoEnvio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    public void actualizar() throws Exception{
        //arrange
        Long id = 1L;
        BigDecimal costo = new BigDecimal(4750);
        ComandoCostoEnvio comandoCostoEnvio = new ComandoCostoEnvioTestDataBuilder().conPesoMin(1D).conPesoMax(9.9D).conCosto(costo).build();
        //act - assert
        mockMvc.perform(put("/costoEnvio/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCostoEnvio)))
                .andExpect(status().isOk());
    }

}
