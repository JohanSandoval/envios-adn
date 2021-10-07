package com.ceiba.dias_espera.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.dias_espera.comando.ComandoDiasEspera;
import com.ceiba.dias_espera.comando.manejador.ManejadorActualizarDiasEspera;
import com.ceiba.dias_espera.comando.manejador.ManejadorCrearDiasEspera;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diasespera")
@Api(tags = {"Controlador comando dias espera"})
public class ComandoControladorDiasEspera {

    private final ManejadorCrearDiasEspera manejadorCrearDiasEspera;
    private final ManejadorActualizarDiasEspera manejadorActualizarDiasEspera;

    public ComandoControladorDiasEspera(ManejadorCrearDiasEspera manejadorCrearDiasEspera,
                                        ManejadorActualizarDiasEspera manejadorActualizarDiasEspera) {
        this.manejadorCrearDiasEspera = manejadorCrearDiasEspera;
        this.manejadorActualizarDiasEspera = manejadorActualizarDiasEspera;
    }

    @PostMapping
    @ApiOperation("Crear dias espera")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoDiasEspera comandoDiasEspera){
        return manejadorCrearDiasEspera.ejecutar(comandoDiasEspera);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("actualizar dias espera")
    public void actualizar(@RequestBody ComandoDiasEspera comandoDiasEspera, @PathVariable Long id){
        comandoDiasEspera.setId(id);
        manejadorActualizarDiasEspera.ejecutar(comandoDiasEspera);
    }
}
