package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@Api(tags = {"controlador comando usuario"})
public class ComandoControladorUsuario {

    private final ManejadorCrearUsuario manejadorCrearUsuario;
    private final ManejadorActualizarUsuario manejadorActualizarUsuario;

    public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,
                                     ManejadorActualizarUsuario manejadorActualizarUsuario) {
        this.manejadorCrearUsuario = manejadorCrearUsuario;
        this.manejadorActualizarUsuario = manejadorActualizarUsuario;
    }

    @PostMapping
    @ApiOperation("crear usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario){
        return manejadorCrearUsuario.ejecutar(comandoUsuario);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar usuario")
    public void actualizar(@RequestBody ComandoUsuario comandoUsuario, @PathVariable Long id){
        comandoUsuario.setId(id);
        manejadorActualizarUsuario.ejecutar(comandoUsuario);
    }

}
