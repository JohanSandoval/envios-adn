package com.ceiba.usuario;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class ServicioActualizarUsuarioTest {

    @Test
    public void validarExistenciaPreviaUsuarioTest(){
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().conid(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El usuario no esta registrado en el sistema");
    }

    @Test
    public void validarActualizarUsuarioTest(){
        //arrenge
        Usuario usuario = new UsuarioTestDataBuilder().conid(2L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

        servicioActualizarUsuario.ejecutar(usuario);
        Long esperado = Long.valueOf(2L);

        assertEquals(esperado, usuario.getId());
    }
}
