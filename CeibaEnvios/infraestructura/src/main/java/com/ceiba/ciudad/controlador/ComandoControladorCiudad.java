package com.ceiba.ciudad.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.ciudad.comando.ComandoCiudad;
import com.ceiba.ciudad.comando.manejador.ManejadorActualizarCiudad;
import com.ceiba.ciudad.comando.manejador.ManejadorCrearCiudad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ciudad")
@Api(tags = {"Controlador comando ciudad"})
public class ComandoControladorCiudad {

    private final ManejadorCrearCiudad manejadorCrearCiudad;
    private final ManejadorActualizarCiudad manejadorActualizarCiudad;

    @Autowired
    public ComandoControladorCiudad(ManejadorCrearCiudad manejadorCrearCiudad,
                                    ManejadorActualizarCiudad manejadorActualizarCiudad) {
        this.manejadorCrearCiudad = manejadorCrearCiudad;
        this.manejadorActualizarCiudad = manejadorActualizarCiudad;
    }

    @PostMapping
    @ApiOperation("Crear ciudad")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCiudad comandoCiudad){
        return manejadorCrearCiudad.ejecutar(comandoCiudad);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("actualizar ciudad")
    public void actualizar(@RequestBody ComandoCiudad comandoCiudad, @PathVariable Long id){
        comandoCiudad.setId(id);
        manejadorActualizarCiudad.ejecutar(comandoCiudad);
    }
}
