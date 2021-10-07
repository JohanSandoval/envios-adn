package com.ceiba.usuario.controlador;

import com.ceiba.usuario.consulta.ManejadorBuscarUsuario;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Api(tags = {"Controlador consulta usuarios"})
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarCiudad;
    private final ManejadorBuscarUsuario manejadorBuscarUsuario;

    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarCiudad,
                                      ManejadorBuscarUsuario manejadorBuscarUsuario) {
        this.manejadorListarCiudad = manejadorListarCiudad;
        this.manejadorBuscarUsuario = manejadorBuscarUsuario;
    }

    @GetMapping
    @ApiOperation("Listar usuarios")
    public List<DtoUsuario> listar(){
        return manejadorListarCiudad.ejecutar();
    }

    @GetMapping(value = "/{cedula}")
    @ApiOperation("Buscar usuario")
    public List<DtoUsuario> listByCedula(@PathVariable String cedula){
        return manejadorBuscarUsuario.ejecutar(cedula);
    }
}