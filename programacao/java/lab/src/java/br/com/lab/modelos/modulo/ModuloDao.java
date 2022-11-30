/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.modulo;

import java.util.List;

/**
 *
 * @author fabio julio
 */
interface ModuloDao {

    //carrega a chaver primaria
    Integer carregarNumero();

    //carrega o modulo atual
    Integer carregarModulo(String osm);

    Integer quantidadeEquipamento(String osm);

    void saveModulo(Modulo modulo);

    void saveFinalidade(ModuloFinalidade moduloFinalidade);

    void saveInstrumento(ModuloInstrumento moduloInstrumento);

    void saveMovimentacao(ModuloMovimentacao moduloMaterial);

    void saveAtraso(ModuloAtraso moduloAtraso);

    void saveFuncionario(ModuloUsuario moduloUsuario);

    public List<Modulo> listarModulos(String osm);

    public List<ModuloAtraso> listAtraso(Integer modulo);

    public List<ModuloMovimentacao> listMovimentacao(Integer modulo);

    public List<ModuloInstrumento> listInstrumentos(Integer modulo);

    public List<ModuloUsuario> listUsuarios(Integer osm);

    public List<ModuloFinalidade> listFinalidade(Integer modulo);
    
    public String getLastObservacao(int lastModulo, String osm);
}
