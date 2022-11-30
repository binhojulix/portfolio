/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.sff;

import br.com.lab.modelos.osm.OrdemServico;
import java.util.List;

/**
 *
 * @author fabiolu
 */
interface SffDao {

    public void salvarSFF(Sff sff);

    public void salvar(Andamento andamento);

    public void editar(Sff sff);

    public void deletar(long id);

    public void deletarAndamento(long id);

    public boolean exist(long id);

    public Sff buscar(long id);

    public List<Sff> listar();

    public List<Andamento> listarAndamentos(Long sff);

    public OrdemServico buscarOSM(String osm);

    public void atualizarStatus(Sff sff);
    
    public List<OrdemServico> listarFaltando();

}
