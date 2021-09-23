package com.ceiba.destinatario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.destinatario.comando.ComandoDestinatario;
import com.ceiba.destinatario.comando.manejador.ManejadorActualizarDestinatario;
import com.ceiba.destinatario.comando.manejador.ManejadorCrearDestinatario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destinatarios")
@Api(tags = {"Controlador comando destinatarios"})
public class ComandoControladorDestinatario {

    private final ManejadorCrearDestinatario manejadorCrearDestinatario;
    private final ManejadorActualizarDestinatario manejadorActualizarDestinatario;

    @Autowired
    public ComandoControladorDestinatario(ManejadorCrearDestinatario manejadorCrearDestinatario, ManejadorActualizarDestinatario manejadorActualizarDestinatario) {
        this.manejadorCrearDestinatario = manejadorCrearDestinatario;
        this.manejadorActualizarDestinatario = manejadorActualizarDestinatario;
    }

    @PostMapping
    @ApiOperation("Crear destinatario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDestinatario comandoDestinatario){
        return this.manejadorCrearDestinatario.ejecutar(comandoDestinatario);
    }

    @PutMapping
    @ApiOperation("Actualizar destinatario")
    public void actualizar(@RequestBody ComandoDestinatario comandoDestinatario){
        this.manejadorActualizarDestinatario.ejecutar(comandoDestinatario);
    }
}
