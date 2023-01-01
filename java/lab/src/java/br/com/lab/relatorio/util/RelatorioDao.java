/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.relatorio.util;

import java.util.List;

/**
 *
 * @author fabiolu
 */
interface RelatorioDao {

    public List<Equipamento> listarEquipamentos();

    public List<Subsistema> listarSubsistemas();

    public List<Sistema> listarSistemas();

    public List<SistemaGeral> listaCompleta();
}
