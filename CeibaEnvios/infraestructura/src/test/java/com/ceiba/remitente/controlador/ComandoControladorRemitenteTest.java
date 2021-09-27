package com.ceiba.remitente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.ComandoRemitenteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorRemitente.class)
public class ComandoControladorRemitenteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void crear() throws Exception{
        //arrange
        ComandoRemitente comandoRemitente = new ComandoRemitenteTestDataBuilder().build();
        //act - assert
        mockMvc.perform(post("/remitentes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoRemitente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        //arrange
        Long id = 1L;
        ComandoRemitente comandoRemitente = new ComandoRemitenteTestDataBuilder().conCedula("12345678").build();
        //act -assert
        mockMvc.perform(put("/remitentes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoRemitente)))
                .andExpect(status().isOk());

    }
}
