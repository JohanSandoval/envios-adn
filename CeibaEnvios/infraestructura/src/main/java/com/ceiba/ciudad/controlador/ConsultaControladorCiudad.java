package com.ceiba.ciudad.controlador;

import com.ceiba.ciudad.consulta.ManejadorBuscarCiudad;
import com.ceiba.ciudad.consulta.ManejadorListarCiudad;
import com.ceiba.ciudad.modelo.dto.DtoCiudad;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
@Api(tags = {"Controlador consulta ciudad"})
public class ConsultaControladorCiudad {

    private final ManejadorBuscarCiudad manejadorBuscarCiudad;
    private final ManejadorListarCiudad manejadorListarCiudad;

    public ConsultaControladorCiudad(ManejadorBuscarCiudad manejadorBuscarCiudad, ManejadorListarCiudad manejadorListarCiudad) {
        this.manejadorBuscarCiudad = manejadorBuscarCiudad;
        this.manejadorListarCiudad = manejadorListarCiudad;
    }

    @GetMapping
    @ApiOperation("Listar ciudad")
    public List<DtoCiudad> list(){
        return manejadorListarCiudad.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Buscar ciudad")
    public List<DtoCiudad> listarById(@PathVariable Long id){
        return manejadorBuscarCiudad.ejecutar(id);
    }
}
