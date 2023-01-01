/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.lab.relatorio.util;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabiolu
 */
public class RelatorioJDBC implements RelatorioDao{

    private Connection connection;
    
    public RelatorioJDBC(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Equipamento> listarEquipamentos() {
        
        String sql ="select numero, DATA_FECHAMENTO, DESCRICAO, CODIGO_EQUIPAMENTO,\n" +
                    "FECHAMENTO_FK, LIBERACAO_FK, DATA_ENTREGA\n" +
                    " FROM laboratorio_altino.osm\n" +
                    "\n" +
                    " where DATA_FECHAMENTO  between '2015-10-01' and '2015-10-30' \n" +
                    "\n" +
                    "	and (RESPONSAVEL_FK ='92002629K' or responsavel_fk='920072968'\n" +
                    "		or RESPONSAVEL_FK='920028152' or responsavel_fk='920025366'\n" +
                    "		or RESPONSAVEL_FK='920023789' or responsavel_fk='92002498K'\n" +
                    "		or RESPONSAVEL_FK='920019234' or responsavel_fk='92002856K'\n" +
                    "		or RESPONSAVEL_FK='920098904' or responsavel_fk='920048706'\n" +
                    "		or RESPONSAVEL_FK='920110398' or responsavel_fk='920048811'\n" +
                    "		or RESPONSAVEL_FK='920080863' or responsavel_fk='920039774'\n" +
                    "		or RESPONSAVEL_FK='920026354' or responsavel_fk='920022863'\n" +
                    "		or responsavel_fk='920039812')\n" +
                    "	order by CODIGO;";
          List<Equipamento> equipamentos = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
          
            while(resultSet.next()){
                Equipamento equipamento = new Equipamento();
                
                
                
                equipamentos.add(equipamento);
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return equipamentos;
        
    }

    @Override
    public List<Subsistema> listarSubsistemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sistema> listarSistemas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SistemaGeral> listaCompleta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
