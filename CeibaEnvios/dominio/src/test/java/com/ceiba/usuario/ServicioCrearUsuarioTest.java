package com.ceiba.usuario;

import com.ceiba.BasePrueba;
import com.ceiba.ciudad.modelo.entidad.Ciudad;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearUsuarioTest {

    @Test
    public void validarCiudadExistenteTest(){
        //arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCiudad(null);
        //act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar una ciudad valida");
    }

    @Test
    public void validarExistenciaPreveaUsuarioTest(){
        //arange
        Usuario usuario = new UsuarioTestDataBuilder().conCedula("12345678").build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        //act -assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, "El usuario ya esta registrado en el sistema" );
    }


    @Test
    public void validarLongitudMinimaCedulaTest(){
        //arrange
        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conCedula("1234");
        //act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La cedula es muy corta la logitud minima es de 8");
    }

    @Test
    public void validarCrearUsuarioTest(){
        //arrange
        Long id = 2L;
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.crear(usuario)).thenReturn(id);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);

        Long repuesta = servicioCrearUsuario.ejecutar(usuario);

        //act .assert
        Assert.assertEquals(id, repuesta);
    }
}
