package com.ceiba.remitente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.remitente.comando.ComandoRemitente;
import com.ceiba.remitente.comando.manejador.ManejadorActualizarRemitente;
import com.ceiba.remitente.comando.manejador.ManejadorCrearRemitente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remitentes")
@Api(tags = {"Controlador comando remitentes"})
public class ComandoControladorRemitente {

    private final ManejadorCrearRemitente manejadorCrearRemitente;
    private final ManejadorActualizarRemitente manejadorActualizarRemitente;

    public ComandoControladorRemitente(ManejadorCrearRemitente manejadorCrearRemitente, ManejadorActualizarRemitente manejadorActualizarRemitente) {
        this.manejadorCrearRemitente = manejadorCrearRemitente;
        this.manejadorActualizarRemitente = manejadorActualizarRemitente;
    }

    @PostMapping
    @ApiOperation("Crear remitente")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoRemitente comandoRemitente){
        return  this.manejadorCrearRemitente.ejecutar(comandoRemitente);
    }

    @PutMapping
    @ApiOperation("Actualizar remitente")
    public void actualizar(@RequestBody ComandoRemitente comandoRemitente){
        this.manejadorActualizarRemitente.ejecutar(comandoRemitente);
    }



}
