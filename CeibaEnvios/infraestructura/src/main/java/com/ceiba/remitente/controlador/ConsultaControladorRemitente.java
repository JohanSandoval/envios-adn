package com.ceiba.remitente.controlador;

import com.ceiba.remitente.consulta.ManejadorBuscarRemitente;
import com.ceiba.remitente.consulta.ManejadorListarRemitentes;
import com.ceiba.remitente.modelo.dto.DtoRemitente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/remitentes")
@Api(tags = {"Controlador consulta remitentes"})
public class ConsultaControladorRemitente {

    private final ManejadorBuscarRemitente manejadorBuscarRemitente;

    private final ManejadorListarRemitentes manejadorListarRemitentes;

    public ConsultaControladorRemitente(ManejadorBuscarRemitente manejadorBuscarRemitente, ManejadorListarRemitentes manejadorListarRemitentes) {
        this.manejadorBuscarRemitente = manejadorBuscarRemitente;
        this.manejadorListarRemitentes = manejadorListarRemitentes;
    }

    @GetMapping
    @ApiOperation("Listar remitentes")
    public List<DtoRemitente> listar(){
        return manejadorListarRemitentes.ejecutar();
    }

    @GetMapping(value = "/{cedula}")
    @ApiOperation("Buscar Remitente")
    public List<DtoRemitente> listarById(@PathVariable String cedula){
        return  manejadorBuscarRemitente.ejecutar(cedula);
    }
}

