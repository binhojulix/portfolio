/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.usuario;

import java.util.List;

/**
 *
 * @author fabio julio
 */
interface UsuarioDao {

    void salvar(Usuario usuario);

    void atualizar(Usuario usuario);

    Usuario buscarPorLogin(String login);

    Usuario buscarPorMatricula(String matricula);

    List<Usuario> listar(String criterio);

    List<Usuario> listar();
}
