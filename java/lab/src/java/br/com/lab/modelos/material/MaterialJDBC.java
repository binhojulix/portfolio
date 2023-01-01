/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.material;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio julio
 */
class MaterialJDBC implements MaterialDao {

    private Connection connection = null;

    public MaterialJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Material material) {

        String sql = "INSERT INTO MATERIAL(CODIGO_CPTM, CODIGO_MATERIAL, UNIDADE, SETOR, ESTOQUE, GAVETA, DESCRICAO, SISTEMA) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, material.getCodigoCPTM());
            stmt.setString(2, material.getCodigoMaterial());
            stmt.setString(3, material.getUnidade());
            stmt.setString(4, material.getSetor());
            stmt.setDouble(5, 0);
            stmt.setString(6, material.getGaveta());
            stmt.setString(7, material.getDescricao());
            stmt.setString(8, material.getSistema());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(Material material) {
        String sql = "UPDATE MATERIAL SET ESTOQUE = ? WHERE CODIGO_MATERIAL = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setDouble(1, material.getEstoque());
            stmt.setString(2, material.getCodigoMaterial());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Material bucarPorCodigoMaterial(String criterio) {
        Material material = null;
        try {
            String pesquisar = "SELECT *FROM MATERIAL WHERE CODIGO_MATERIAL = ? ";
            PreparedStatement stmt = this.connection.prepareStatement(pesquisar);
            stmt.setString(1, criterio);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                material = new Material();
                material.setCodigoCPTM(resultado.getString("CODIGO_CPTM"));
                material.setCodigoMaterial(resultado.getString("CODIGO_MATERIAL"));
                material.setDescricao(resultado.getString("DESCRICAO"));
                material.setGaveta(resultado.getString("GAVETA"));
                material.setSistema(resultado.getString("SISTEMA"));
                material.setEstoque(resultado.getDouble("ESTOQUE"));
                material.setUnidade(resultado.getString("UNIDADE"));
                material.setSetor(resultado.getString("SETOR"));
            }
            resultado.close();
            stmt.close();
            return material;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Material> listar(String criterio, String coluna) {
        try {
            List<Material> materiais = new ArrayList<>();
            Double quantidade = 0.0;
            String query = "SELECT *FROM MATERIAL WHERE " + coluna.trim() + " = ? ORDER BY DESCRICAO";
            if (coluna.equals("DESCRICAO")) {
                query = "SELECT *FROM MATERIAL WHERE DESCRICAO LIKE ? ORDER BY DESCRICAO";
            }
            if (coluna.equals("ESTOQUE")) {
                try {
                    if (criterio == null || criterio.isEmpty()) {
                        return null;
                    } else {
                        quantidade = quantidade.parseDouble(criterio);
                        query = "SELECT *FROM MATERIAL WHERE ESTOQUE  = ? ORDER BY DESCRICAO";
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade deve ser valor numérico");
                    e.getMessage();
                }
            }

            PreparedStatement stmt = this.connection.prepareStatement(query);
            if (coluna.equals("DESCRICAO")) {
                stmt.setString(1, "%" + criterio + "%");
            } else if (coluna.equals("ESTOQUE")) {
                stmt.setDouble(1, quantidade);
            } else {
                stmt.setString(1, criterio);
            }

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Material material = new Material();
                material.setCodigoCPTM(resultado.getString("CODIGO_CPTM"));
                material.setCodigoMaterial(resultado.getString("CODIGO_MATERIAL"));
                material.setDescricao(resultado.getString("DESCRICAO"));
                material.setGaveta(resultado.getString("GAVETA"));
                material.setEstoque(resultado.getDouble("ESTOQUE"));
                material.setSistema(resultado.getString("SISTEMA"));
                material.setUnidade(resultado.getString("UNIDADE"));
                material.setSetor(resultado.getString("SETOR"));
                materiais.add(material);
            }
            resultado.close();
            stmt.close();
            return materiais;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Material> listar(String criterio) {
        try {
            List<Material> materiais = new ArrayList<>();
            String query = "SELECT *FROM MATERIAL WHERE DESCRICAO LIKE ? OR CODIGO_MATERIAL LIKE ? OR CODIGO_CPTM LIKE ? OR SISTEMA LIKE ? OR GAVETA LIKE ? ";

            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, "%" + criterio + "%");
            stmt.setString(2, "%" + criterio + "%");
            stmt.setString(3, "%" + criterio + "%");
            stmt.setString(4, "%" + criterio + "%");
            stmt.setString(5, "%" + criterio + "%");

            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Material material = new Material();
                material.setCodigoCPTM(resultado.getString("CODIGO"));
                material.setCodigoMaterial(resultado.getString("CODIGO_MATERIAL"));
                material.setDescricao(resultado.getString("DESCRICAO"));
                material.setGaveta(resultado.getString("GAVETA"));
                material.setEstoque(resultado.getDouble("ESTOQUE"));
                material.setSistema(resultado.getString("SISTEMA"));
                material.setUnidade(resultado.getString("UNIDADE"));
                material.setSetor(resultado.getString("SETOR"));
                materiais.add(material);
            }
            resultado.close();
            stmt.close();
            return materiais;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
