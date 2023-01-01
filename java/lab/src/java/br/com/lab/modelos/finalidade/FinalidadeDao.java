/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.finalidade;

import java.util.List;

/**
 *
 * @author fabiolu
 */
interface FinalidadeDao {

    public void salvar(Equipamento finalidade);

    public void editar(Equipamento finalidade);
    
    public void excluir(String codigo);

    public Equipamento getFinalidades(String codigo);

    public List<Equipamento> listar();

    public List<Equipamento> listar(String search);

    public List<Equipamento> listAll();

}
