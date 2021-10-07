package com.ceiba.ciudad.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.ciudad.comando.ComandoCiudad;
import com.ceiba.ciudad.servicio.testdatabuilder.ComandoCiudadTestDataBuilder;
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
@WebMvcTest(ComandoControladorCiudad.class)
public class ComandoControladorCiudadTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    public void crear() throws Exception{
        //arrange
        ComandoCiudad comandoCiudad = new ComandoCiudadTestDataBuilder().build();
        //act - assert
        mockMvc.perform(post("/ciudad")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCiudad)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
    @Test
    public void actualizar() throws Exception{
        //arrange
        Long id = 2L;
        ComandoCiudad comandoCiudad = new ComandoCiudadTestDataBuilder().conNombre("MEDELLIN").build();
        //act - assert
        mockMvc.perform(put("/ciudad/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCiudad)))
                .andExpect(status().isOk());
    }

}
