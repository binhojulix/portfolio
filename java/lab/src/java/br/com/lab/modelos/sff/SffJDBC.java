/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.sff;

import br.com.lab.modelos.osm.Equipamento;
import br.com.lab.modelos.osm.OrdemServico;
import br.com.lab.modelos.tabela.Tabela;
import br.com.lab.modelos.usuario.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabiolu
 */
class SffJDBC implements SffDao {

    private Connection connection = null;

    public SffJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvarSFF(Sff sff) {

        String sql = "INSERT INTO sff(sff, solicitante, material, qtd_material, osm, ultimo_andamento, "
                + "data_ultimo_andamento)"
                + " values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sff.getSff());
            stmt.setString(2, sff.getSolicitante().getMatricula());
            stmt.setString(3, sff.getMaterial());
            stmt.setInt(4, sff.getQtdMaterial());
            stmt.setString(5, sff.getOsm().getNumero());
            stmt.setString(6, sff.getUltimoAndamento());
            stmt.setDate(7, new java.sql.Date(sff.getDataUltimoAndamento().getTime()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void salvar(Andamento andamento) {
        String sql = "INSERT INTO andamento(andamento, data_modificacao, sff_fk) values(?,?,?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, andamento.getDescricaoAndamento());
            stmt.setDate(2, new java.sql.Date(andamento.getData().getTime()));
            stmt.setLong(3, andamento.getSff());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void editar(Sff sff) {
        String sql = "update sff set sff=?, solicitante=?, material=?,"
                + " qtd_material=?, osm=?, ultimo_andamento=?"
                + " where sff_id =?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sff.getSff());
            stmt.setString(2, sff.getSolicitante().getMatricula());
            stmt.setString(3, sff.getMaterial());
            stmt.setInt(4, sff.getQtdMaterial());
            stmt.setString(5, sff.getOsm().getNumero());
            stmt.setString(6, sff.getUltimoAndamento());

            stmt.setLong(7, sff.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarStatus(Sff sff) {
        String sql = "update sff set ultimo_andamento=?,"
                + "data_ultimo_andamento = ?, sff = ?  where sff_id =?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, sff.getUltimoAndamento());
            stmt.setDate(2, new java.sql.Date(sff.getDataUltimoAndamento().getTime()));
            stmt.setString(3, sff.getSff());
            stmt.setLong(4, sff.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletar(long id) {
        String sql = "delete from sff where sff_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletarAndamento(long id) {
        String sql = "delete from andamento where sff_fk = ? ";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exist(long id) {
        try {

            String query = "SELECT sff_id FROM sff";

            PreparedStatement stmt = this.connection.prepareStatement(query);

            ResultSet resultado = stmt.executeQuery();

            boolean saida = false;

            while (resultado.next()) {
                saida = true;
            }
            resultado.close();
            stmt.close();
            return saida;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Sff> listar() {
        try {

            String query = "SELECT *FROM (sff as s"
                    + "  inner join solicitante on s.solicitante = solicitante.MATRICULA)"
                    + "order by sff_id desc";
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();

            List<Sff> sffs = new ArrayList<>();

            while (resultado.next()) {

                //preencher a sff
                long idSff = resultado.getLong("sff_id");
                String numeroSff = resultado.getString("sff");
                String material = resultado.getString("material");
                int qtdMaterial = resultado.getInt("qtd_material");
                String ultimoAndamento = resultado.getString("ultimo_andamento");
                java.util.Date dataUltimoAndamento = resultado.getDate("data_ultimo_andamento");

                Usuario solicitatne = new Usuario();
                Tabela area = new Tabela();
                solicitatne.setMatricula(resultado.getString("solicitante.MATRICULA"));
                solicitatne.setNome(resultado.getString("solicitante.NOME"));
                solicitatne.setTelefone(resultado.getString("solicitante.TELEFONE"));
                area.setCodigo(resultado.getString("solicitante.AREA"));
                solicitatne.setArea(area);

                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setNumero(resultado.getString("osm"));

                Sff sff = new Sff(idSff, numeroSff, solicitatne, ultimoAndamento,
                        dataUltimoAndamento, material, qtdMaterial, ordemServico);
                sffs.add(sff);

            }
            resultado.close();
            stmt.close();
            return sffs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public OrdemServico buscarOSM(String numero) {
        OrdemServico osm = null;
        try {
            String sql = "select *"
                    + " from ((osm LEFT JOIN ESTACAO ON ESTACAO_FK = estacao.ESTACAO_CODIGO)"
                    + "left join local on local_fk = local.local_codigo)"
                    + " where numero = ? ";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, numero);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                osm = new OrdemServico();

                Tabela estacao = new Tabela();
                estacao.setCodigo(resultado.getString("estacao_fk"));
                estacao.setDescricao(resultado.getString("estacao.estacao_descricao"));
                Tabela local = new Tabela();
                local.setCodigo(resultado.getString("local_fk"));
                local.setDescricao(resultado.getString("local.local_descricao"));
                Equipamento equpamento = new Equipamento();
                equpamento.setDescricao(resultado.getString("descricao"));
                osm.setEstacao(estacao);
                osm.setLocal(local);
                osm.setEquipamento(equpamento);
                osm.setNumero(resultado.getString("numero"));

            }
            resultado.close();
            stmt.close();
            return osm;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Andamento> listarAndamentos(Long sff) {
        try {
            List<Andamento> andamentos = new ArrayList<>();
            String sql = "select *from andamento where sff_fk = ?";
            PreparedStatement preparedStatement = this.connection.prepareCall(sql);
            preparedStatement.setLong(1, sff);
            ResultSet resultado = preparedStatement.executeQuery();
            while (resultado.next()) {
                Andamento andamento = new Andamento();
                andamento.setData(resultado.getDate("data_modificacao"));
                andamento.setDescricaoAndamento(resultado.getString("andamento"));
                andamento.setId(resultado.getLong("andamento_id"));
                andamento.setSff(resultado.getLong("sff_fk"));
                andamentos.add(andamento);

            }
            return andamentos;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Sff buscar(long id) {
        try {

            String query = "SELECT *FROM (sff as s"
                    + "  inner join solicitante on s.solicitante = solicitante.MATRICULA)"
                    + "where sff_id = ? ";
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet resultado = stmt.executeQuery();

            Sff sff = null;
            while (resultado.next()) {

                //preencher a sff
                long idSff = resultado.getLong("sff_id");
                String numeroSff = resultado.getString("sff");
                String material = resultado.getString("material");
                int qtdMaterial = resultado.getInt("qtd_material");
                String ultimoAndamento = resultado.getString("ultimo_andamento");
                java.util.Date dataUltimoAndamento = resultado.getDate("data_ultimo_andamento");

                Usuario solicitatne = new Usuario();
                Tabela area = new Tabela();
                solicitatne.setMatricula(resultado.getString("solicitante.MATRICULA"));
                solicitatne.setNome(resultado.getString("solicitante.NOME"));
                solicitatne.setTelefone(resultado.getString("solicitante.TELEFONE"));
                area.setCodigo(resultado.getString("solicitante.AREA"));
                solicitatne.setArea(area);

                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setNumero(resultado.getString("osm"));

                sff = new Sff(idSff, numeroSff, solicitatne, ultimoAndamento,
                        dataUltimoAndamento, material, qtdMaterial, ordemServico);
            }
            resultado.close();
            stmt.close();
            return sff;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrdemServico> listarFaltando() {
        try {
            List<OrdemServico> ordens = new ArrayList<>();
            String query = "select numero, descricao, codigo_equipamento from osm where liberacao_fk ='2' "
                    + "and responsavel_fk = '920025366'";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                OrdemServico osm = new OrdemServico();
                Tabela local = new Tabela();
                Tabela estacao = new Tabela();
                osm.setNumero(resultado.getString("NUMERO"));
                osm.setDataAbertura(resultado.getDate("DATA_ABERTURA"));
                osm.getEquipamento().setCodigoEquipamento(resultado.getString("CODIGO_EQUIPAMENTO"));
                osm.getEquipamento().setDescricao(resultado.getString("DESCRICAO"));
                osm.getEquipamento().setPatrimonio(resultado.getString("PATRIMONIO"));
                osm.getEquipamento().setPlaca(resultado.getString("PLAQUETA"));
                osm.getEquipamento().setSerie(resultado.getString("SERIE"));
                osm.getResponsavel().setMatricula(resultado.getString("MATRICULA"));
                osm.getResponsavel().setNome(resultado.getString("NOME"));
                local.setCodigo(resultado.getString("LOCAL_FK"));
                estacao.setCodigo(resultado.getString("ESTACAO_FK"));
                osm.setEstacao(estacao);
                osm.setLocal(local);
                ordens.add(osm);
            }
            resultado.close();
            stmt.close();
            return ordens;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
