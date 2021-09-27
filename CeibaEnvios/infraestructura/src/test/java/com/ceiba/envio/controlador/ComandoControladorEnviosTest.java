package com.ceiba.envio.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.envio.comando.ComandoEnvio;
import com.ceiba.envio.servicio.testdatabuilder.ComandoEnvioTestDataBuilder;
import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.servicio.testdatabuilder.ComandoRemitenteTestDataBuilder;
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
@WebMvcTest(ComandoControladorEnvio.class)
public class ComandoControladorEnviosTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    public void crear() throws  Exception{
        //arrange
        ComandoEnvio comandoEnvio = new ComandoEnvioTestDataBuilder().build();
        //act -assert
        mockMvc.perform(post("/envios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEnvio)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    @Test
    public void  actualizar() throws Exception{
        //arrange
        Long id = 1L;
        ComandoEnvio comandoEnvio = new ComandoEnvioTestDataBuilder().conPeso(30D).build();
        System.out.println(comandoEnvio.toString());
        //act -assert
        mockMvc.perform(put("/envios/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoEnvio)))
                .andExpect(status().isOk());
    }
}
