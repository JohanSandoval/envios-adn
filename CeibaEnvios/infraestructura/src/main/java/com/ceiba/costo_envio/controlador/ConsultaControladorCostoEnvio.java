package com.ceiba.costo_envio.controlador;

import com.ceiba.costo_envio.consulta.ManejadorBuscarCostoEnvio;
import com.ceiba.costo_envio.consulta.ManejadorListarCostoEnvio;
import com.ceiba.costo_envio.modelo.dto.DtoCostoEnvio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/costoEnvio")
@Api(tags = {"Controlador consulta costo envio"})
public class ConsultaControladorCostoEnvio {

    private final ManejadorListarCostoEnvio manejadorListarCostoEnvio;
    private final ManejadorBuscarCostoEnvio manejadorBuscarCostoEnvio;

    public ConsultaControladorCostoEnvio(ManejadorListarCostoEnvio manejadorListarCostoEnvio,
                                         ManejadorBuscarCostoEnvio manejadorBuscarCostoEnvio) {
        this.manejadorListarCostoEnvio = manejadorListarCostoEnvio;
        this.manejadorBuscarCostoEnvio = manejadorBuscarCostoEnvio;
    }

    @GetMapping
    @ApiOperation("Listar costos de envio")
    public List<DtoCostoEnvio> listar(){
        return manejadorListarCostoEnvio.ejecutar();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("Buscar costo ennvio")
    public List<DtoCostoEnvio> listarById(@PathVariable Long id){
        return manejadorBuscarCostoEnvio.ejecutar(id);
    }


}
