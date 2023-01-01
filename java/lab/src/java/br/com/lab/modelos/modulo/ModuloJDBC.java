package br.com.lab.modelos.modulo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.lab.modelos.material.Material;
import br.com.lab.modelos.movimentacao.Movimentacao;
import br.com.lab.modelos.tabela.Tabela;
import br.com.lab.modelos.usuario.Usuario;
import java.sql.Types;

/**
 *
 * @author fabiolu
 */
class ModuloJDBC implements ModuloDao {

    private Connection connection = null;

    public ModuloJDBC(Connection connection) {
        this.connection = connection;
    }
    //numero do modulo

    @Override
    public Integer carregarModulo(String osm) {
        Integer numero = 0;
        String pesquisar = "SELECT MAX(MODULO)AS M FROM MODULO WHERE OSM =?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(pesquisar);
            stmt.setString(1, osm);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                numero = resultado.getInt("M");
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero += 1;
    }

    //codigo do modulo
    @Override
    public Integer carregarNumero() {
        int numero = 0;
        String pesquisar = "SELECT MAX(CODIGO)AS M FROM MODULO";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(pesquisar);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                numero = resultado.getInt("M");
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero += 1;
    }

    //quantidade de equipamentos ate agora
    @Override
    public Integer quantidadeEquipamento(String osm) {
        Integer numero = 0;
        String pesquisar = "SELECT SUM(QUANTIDADE)AS M FROM MODULO WHERE OSM =?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(pesquisar);
            stmt.setString(1, osm);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                numero = resultado.getInt("M");
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero;
    }

    @Override
    public void saveModulo(Modulo modulo) {
        try {
            String sql = "INSERT INTO MODULO (OSM, MODULO, HORA_ABERTURA, ATUANTE_FK, "
                    + "DATA_ATUACAO, INICIO, FIM, FECHAMENTO_FK, LIBERACAO_FK, OBSERVACAO, QUANTIDADE, SERVICO, OBS_CAUSA, OBS_ATUACAO) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, modulo.getOrdemServico().getNumero());
            stmt.setInt(2, modulo.getModulo());
            stmt.setTime(3, new java.sql.Time(modulo.getHoraAbertura().getTime()));
            stmt.setString(4, modulo.getFuncionario().getMatricula());
            stmt.setDate(5, new java.sql.Date(modulo.getDataAtuacao().getTime()));
            stmt.setTime(6, new java.sql.Time(modulo.getInicio().getTime()));
            stmt.setTime(7, new java.sql.Time(modulo.getFim().getTime()));
            stmt.setString(8, modulo.getFechamento().getCodigo());
            stmt.setString(9, modulo.getLiberacao().getCodigo());
            stmt.setString(10, modulo.getObservacao());
            if (modulo.getQuantidade() == null) {
                stmt.setInt(11, 0);
            } else {
                stmt.setInt(11, modulo.getQuantidade());
            }
            stmt.setString(12, modulo.getServico());
            stmt.setString(13, modulo.getObservacaoCausa());
            stmt.setString(14, modulo.getObservacaoAtuacao());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFinalidade(ModuloFinalidade moduloFinalidade) {
        try {
            String sql = "INSERT INTO MODULO_FINALIDADES (MODULO_FK, ITEM, FINALIDADE, CAUSA_FK, ATUACAO_FK) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, moduloFinalidade.getModulo());
            if (moduloFinalidade.getItem() == null) {
                stmt.setNull(2, Types.INTEGER);
            } else {
                stmt.setInt(2, moduloFinalidade.getItem());
            }
            stmt.setString(3, moduloFinalidade.getFinalidade());
            stmt.setString(4, moduloFinalidade.getCausa().getCodigo());
            stmt.setString(5, moduloFinalidade.getAtuacao().getCodigo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveInstrumento(ModuloInstrumento moduloInstrumento) {
        try {
            String sql = "INSERT INTO MODULO_INSTRUMENTOS (MODULO_FK, INSTRUMENTO_FK, TEMPO_UTILIZACAO) VALUES(?,?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, moduloInstrumento.getModulo());
            stmt.setString(2, moduloInstrumento.getInstrumento().getCodigo());
            stmt.setTime(3, new java.sql.Time(moduloInstrumento.getTempoUtilizacao().getTime()));
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveMovimentacao(ModuloMovimentacao moduloMovimentacao) {
        try {
            String sql = "INSERT INTO MODULO_MOVIMENTACOES (MODULO_FK, MOVIMENTACAO_FK) VALUES(?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, moduloMovimentacao.getModulo());
            stmt.setInt(2, moduloMovimentacao.getMovimentacao().getNumero());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveFuncionario(ModuloUsuario moduloUsuario) {
        try {
            String sql = "INSERT INTO MODULO_USUARIOS (USUARIO_FK, MODULO_FK) VALUES(?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, moduloUsuario.getUsuario().getMatricula());
            stmt.setInt(2, moduloUsuario.getModulo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAtraso(ModuloAtraso moduloAtraso) {
        try {
            String sql = "INSERT INTO MODULO_ATRASOS (MODULO_FK, ATRASO_FK) VALUES(?,?)";
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, moduloAtraso.getModulo());
            stmt.setString(2, moduloAtraso.getCodigoAtraso());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //LISTAR MODULOS DA OSM
    @Override
    public List<Modulo> listarModulos(String osm) {
        Modulo modulo;
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        List<Modulo> modulos = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *FROM (((MODULO) LEFT JOIN FECHAMENTO ON MODULO.FECHAMENTO_FK = FECHAMENTO.FECHAMENTO_CODIGO) ");
        sql.append("LEFT JOIN LIBERACAO ON MODULO.LIBERACAO_FK = LIBERACAO.LIBERACAO_CODIGO) ");
        sql.append("INNER JOIN SOLICITANTE ON MODULO.ATUANTE_FK = SOLICITANTE.MATRICULA WHERE OSM = ? ORDER BY CODIGO");

        try {
            stmt = this.connection.prepareStatement(sql.toString());
            stmt.setString(1, osm);
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                modulo = new Modulo();
                Tabela fechamento = new Tabela();
                Tabela liberacao = new Tabela();
                Usuario usuario = new Usuario();
                modulo.setCodigo(resultado.getInt("CODIGO"));
                modulo.setModulo(resultado.getInt("MODULO"));
                modulo.setFim(resultado.getTime("FIM"));
                modulo.setInicio(resultado.getTime("INICIO"));
                modulo.setDataAtuacao(resultado.getDate("DATA_ATUACAO"));
                modulo.setHoraAbertura(resultado.getTime("HORA_ABERTURA"));
                usuario.setMatricula(resultado.getString("ATUANTE_FK"));
                usuario.setNome(resultado.getString("NOME"));
                fechamento.setCodigo(resultado.getString("FECHAMENTO_CODIGO"));
                fechamento.setDescricao(resultado.getString("FECHAMENTO_DESCRICAO"));
                liberacao.setCodigo(resultado.getString("LIBERACAO_CODIGO"));
                liberacao.setDescricao(resultado.getString("LIBERACAO_DESCRICAO"));
                modulo.setFechamento(fechamento);
                modulo.setLiberacao(liberacao);
                modulo.setFuncionario(usuario);
                modulo.setObservacao(resultado.getString("OBSERVACAO"));
                modulo.setServico(resultado.getString("SERVICO"));
                modulo.setQuantidade(resultado.getInt("QUANTIDADE"));
                modulo.setObservacaoCausa(resultado.getString("OBS_CAUSA"));
                modulo.setObservacaoAtuacao(resultado.getString("OBS_ATUACAO"));
                modulos.add(modulo);
            }
            resultado.close();
            stmt.close();
            return modulos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //LISTAR ATRASOS DO MODULO
    @Override
    public List<ModuloAtraso> listAtraso(Integer modulo) {
        String sql = "SELECT *FROM MODULO_ATRASOS, ATRASO WHERE ATRASO_FK = CODIGO_ATRASO AND MODULO_FK = ?";
        List<ModuloAtraso> atrasos = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modulo);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ModuloAtraso moduloAtraso = new ModuloAtraso();
                Tabela atraso = new Tabela();
                atraso.setCodigo(resultado.getString("ATRASO_DESCRICAO"));
                atraso.setDescricao(resultado.getString("ATRASO_CODIGO"));
                moduloAtraso.setTipo(resultado.getString("TIPO"));
                moduloAtraso.setAtraso(atraso);
                atrasos.add(moduloAtraso);
            }
            resultado.close();
            stmt.close();
            return atrasos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //LISTAR MOVIMENTACAO DO MODULO
    @Override
    public List<ModuloMovimentacao> listMovimentacao(Integer modulo) {
        String sql = "SELECT MODULO_FK, MOVIMENTACAO_FK, NUMERO, MATERIAL_FK, SITUACAO," + " "
                + "QUANTIDADE, CODIGO_MATERIAL, DESCRICAO, TIPO" + " "
                + "FROM MODULO_MOVIMENTACOES, MOVIMENTACAO, MATERIAL" + " "
                + "WHERE MOVIMENTACAO_FK = NUMERO AND MODULO_FK = ? AND MATERIAL_FK = CODIGO_MATERIAL";
        List<ModuloMovimentacao> movimentacoes = new ArrayList<>();

        PreparedStatement stmt = null;
        ResultSet resultado = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modulo);
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                Material material = new Material();
                Movimentacao movimentacao = new Movimentacao();
                ModuloMovimentacao moduloMovimentacao = new ModuloMovimentacao();
                movimentacao.setQuantidade(resultado.getDouble("QUANTIDADE"));
                material.setDescricao(resultado.getString("DESCRICAO"));
                material.setCodigoMaterial(resultado.getString("CODIGO_MATERIAL"));
                movimentacao.setTipo(resultado.getString("TIPO"));
                movimentacao.setMaterial(material);
                moduloMovimentacao.setMovimentacao(movimentacao);
                movimentacoes.add(moduloMovimentacao);
            }
            resultado.close();
            stmt.close();
            return movimentacoes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //LISTAR INSTRUMENTOS DO MODULO
    @Override
    public List<ModuloInstrumento> listInstrumentos(Integer modulo) {
        String sql = "SELECT *FROM MODULO_INSTRUMENTOS, INSTRUMENTO WHERE INSTRUMENTO_FK = INSTRUMENTO_CODIGO AND MODULO_FK = ?";

        List<ModuloInstrumento> instrumentos = new ArrayList<>();
        ModuloInstrumento moduloInstrumento;
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        Tabela instrumento;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modulo);
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                instrumento = new Tabela();
                moduloInstrumento = new ModuloInstrumento();
                moduloInstrumento.setModulo(resultado.getInt("MODULO_FK"));
                moduloInstrumento.setTempoUtilizacao(resultado.getTime("TEMPO_UTILIZACAO"));
                instrumento.setCodigo(resultado.getString("INSTRUMENTO_CODIGO"));
                instrumento.setDescricao(resultado.getString("INSTRUMENTO_DESCRICAO"));
                moduloInstrumento.setInstrumento(instrumento);
                instrumentos.add(moduloInstrumento);
            }
            resultado.close();
            stmt.close();
            return instrumentos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //LISTAR FINALIDADES DO MODULO
    @Override
    public List<ModuloFinalidade> listFinalidade(Integer modulo) {
        String sql = "SELECT *FROM MODULO_FINALIDADES, CAUSA, ATUACAO" + " "
                + "WHERE CAUSA_FK = CAUSA_CODIGO AND ATUACAO_FK = ATUACAO_CODIGO AND MODULO_FK = ?";

        Tabela causa;
        Tabela atuacao;
        List<ModuloFinalidade> finalidades = new ArrayList<>();
        ModuloFinalidade finalidade;
        PreparedStatement stmt = null;
        ResultSet resultado = null;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modulo);
            resultado = stmt.executeQuery();
            while (resultado.next()) {
                causa = new Tabela();
                atuacao = new Tabela();
                finalidade = new ModuloFinalidade();
                finalidade.setItem(resultado.getInt("ITEM"));
                finalidade.setFinalidade(resultado.getString("FINALIDADE"));
                causa.setCodigo(resultado.getString("CAUSA_CODIGO"));
                causa.setDescricao(resultado.getString("CAUSA_DESCRICAO"));
                atuacao.setCodigo(resultado.getString("ATUACAO_CODIGO"));
                atuacao.setDescricao(resultado.getString("ATUACAO_DESCRICAO"));
                finalidade.setCausa(causa);
                finalidade.setAtuacao(atuacao);
                finalidades.add(finalidade);
            }
            resultado.close();
            stmt.close();
            return finalidades;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ModuloUsuario> listUsuarios(Integer modulo) {

        try {
            String sql = "SELECT modulo_fk, usuario_fk, nome, matricula, cargo FROM MODULO_USUARIOS, SOLICITANTE WHERE usuario_fk = matricula AND MODULO_FK = ?";

            List<ModuloUsuario> usuarios = new ArrayList<>();

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, modulo);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                ModuloUsuario moduloUsuario = new ModuloUsuario();
                Usuario usuario = new Usuario();
                usuario.setNome(resultado.getString("NOME"));
                usuario.setMatricula(resultado.getString("MATRICULA"));
                usuario.setCargo(resultado.getString("CARGO"));
                moduloUsuario.setUsuario(usuario);
                usuarios.add(moduloUsuario);
            }
            resultado.close();
            stmt.close();
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getLastObservacao(int lastModulo, String osm) {
        String observacao = null;
        try {
            String sql = "select observacao from modulo where osm=? and modulo=?";
            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setString(1, osm);
            stmt.setInt(2, lastModulo);
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                observacao = resultado.getString("observacao");
            }
            resultado.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return observacao;
    }

}
