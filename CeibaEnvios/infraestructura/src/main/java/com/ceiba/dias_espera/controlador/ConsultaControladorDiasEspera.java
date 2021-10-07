package com.ceiba.dias_espera.controlador;

import com.ceiba.dias_espera.consulta.ManejadorBuscarDiasEspera;
import com.ceiba.dias_espera.consulta.ManejadorListarDiasEspera;
import com.ceiba.dias_espera.modelo.dto.DtoDiasEspera;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diasEspera")
@Api(tags = {"Controlador consulta dias espera"})
public class ConsultaControladorDiasEspera {

    private final ManejadorListarDiasEspera manejadorListarDiasEspera;
    private final ManejadorBuscarDiasEspera manejadorBuscarDiasEspera;

    public ConsultaControladorDiasEspera(ManejadorListarDiasEspera manejadorListarDiasEspera,
                                         ManejadorBuscarDiasEspera manejadorBuscarDiasEspera) {
        this.manejadorListarDiasEspera = manejadorListarDiasEspera;
        this.manejadorBuscarDiasEspera = manejadorBuscarDiasEspera;
    }

    @GetMapping
    @ApiOperation("Listar dias espera")
    public List<DtoDiasEspera> litar(){
        return manejadorListarDiasEspera.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Buscar usuario")
    public List<DtoDiasEspera> listarById(@PathVariable Long id){
        return manejadorBuscarDiasEspera.ejecutar(id);
    }
}
