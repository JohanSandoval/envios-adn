package com.ceiba.destinatario.controlador;

import com.ceiba.destinatario.consulta.ManejadorBuscarDestinatario;
import com.ceiba.destinatario.consulta.ManejadorListarDestinatario;
import com.ceiba.destinatatio.modelo.dto.DtoDestinatario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destinatarios")
@Api(tags = {"Controlador consulta destinatarios"})
public class ConsultaControladorDestinatario {

    private final ManejadorBuscarDestinatario manejadorBuscarDestinatario;
    private final ManejadorListarDestinatario manejadorListarDestinatario;

    public ConsultaControladorDestinatario(ManejadorBuscarDestinatario manejadorBuscarDestinatario, ManejadorListarDestinatario manejadorListarDestinatario) {
        this.manejadorBuscarDestinatario = manejadorBuscarDestinatario;
        this.manejadorListarDestinatario = manejadorListarDestinatario;
    }

    @GetMapping
    @ApiOperation("Listar destinatarios")
    public List<DtoDestinatario> listar(){
        return manejadorListarDestinatario.ejecutar();
    }

    @GetMapping(value = "/{cedula}")
    @ApiOperation("Buscar Destinatario")
    public List<DtoDestinatario> listarById(@PathVariable String cedula){
        return manejadorBuscarDestinatario.ejecutar(cedula);
    }
}
