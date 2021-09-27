package com.ceiba.destinatario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.destinatario.comando.ComandoDestinatario;
import com.ceiba.destinatario.servicio.testdatabuilder.ComandoDestinatarioTestDataBuilder;
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
@WebMvcTest(ComandoControladorDestinatario.class)
public class ComandoControladordestinatarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void crear() throws  Exception{
        //arrange
        ComandoDestinatario comandoDestinatario = new ComandoDestinatarioTestDataBuilder().build();

        //act - assert
        mockMvc.perform(post("/destinatarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoDestinatario)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        //arrange
        String cedula = "87654321";
        ComandoDestinatario comandoDestinatario = new ComandoDestinatarioTestDataBuilder().build();

        //act -assert
        mockMvc.perform(put("/destinatarios/{cedula}", cedula)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoDestinatario)))
                .andExpect(status().isOk());
    }
}
