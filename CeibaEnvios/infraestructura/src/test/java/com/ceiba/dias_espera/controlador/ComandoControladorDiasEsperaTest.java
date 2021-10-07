package com.ceiba.dias_espera.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.dias_espera.comando.ComandoDiasEspera;
import com.ceiba.dias_espera.servicio.testdatabuilder.ComandoDiasEsperaTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorDiasEspera.class)
public class ComandoControladorDiasEsperaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws Exception{
        //arrange
        ComandoDiasEspera comandoDiasEspera = new ComandoDiasEsperaTestDataBuilder().build();
        //act - assert
        mockMvc.perform(post("/diasespera")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoDiasEspera)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        //arrange
        Long id = 1L;
        ComandoDiasEspera comandoDiasEspera = new ComandoDiasEsperaTestDataBuilder()
                .conCiudadD(1L).conCiudadD(1L).conDias(4D).build();
        //act - assert
        mockMvc.perform(put("/diasespera/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoDiasEspera)))
                .andExpect(status().isOk());
    }
}
