package com.ceiba.costo_envio.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.costo_envio.comando.ComandoCostoEnvio;
import com.ceiba.costo_envio.comando.manejador.ManejadorActualizarCostoEnvio;
import com.ceiba.costo_envio.comando.manejador.ManejadorCrearCostoEnvio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costoEnvio")
@Api(tags = {"Controlador comando costo envio"})
public class ComandoControladorCostoEnvio {

    private final ManejadorCrearCostoEnvio manejadorCrearCostoEnvio;
    private final ManejadorActualizarCostoEnvio manejadorActualizarCostoEnvio;

    public ComandoControladorCostoEnvio(ManejadorCrearCostoEnvio manejadorCrearCostoEnvio,
                                        ManejadorActualizarCostoEnvio manejadorActualizarCostoEnvio) {
        this.manejadorCrearCostoEnvio = manejadorCrearCostoEnvio;
        this.manejadorActualizarCostoEnvio = manejadorActualizarCostoEnvio;
    }

    @PostMapping
    @ApiOperation("crear costo envio")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCostoEnvio costoEnvio){
        return manejadorCrearCostoEnvio.ejecutar(costoEnvio);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar costo envio")
    public void actualizar(@RequestBody ComandoCostoEnvio comandoCostoEnvio, @PathVariable Long id){
        comandoCostoEnvio.setId(id);
        manejadorActualizarCostoEnvio.ejecutar(comandoCostoEnvio);
    }
}
