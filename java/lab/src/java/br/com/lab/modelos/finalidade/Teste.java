/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.finalidade;

import br.com.lab.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author fabiolu
 */
public class Teste {

    public static void main(String args[]) {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            FinalidadeJDBC finalidadeJDBC = new FinalidadeJDBC(connection);
            Equipamento equipamento = new Equipamento();
            equipamento.setCodigo("ADM00000000");
            equipamento.setDescricao("SISTEMA ADMINISTRATIVO");
            finalidadeJDBC.editar(equipamento);
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
