/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lab.modelos.usuario;

import br.com.lab.modelos.tabela.Tabela;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author fabio julio
 */
public class Usuario {

    private String nome;
    private String matricula;
    private String telefone;
    private String cargo;
    private String login;
    private Tabela area;
    private boolean manutenedor;
    private Set<String> permissoes = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Tabela getArea() {
        return area;
    }

    public void setArea(Tabela area) {
        this.area = area;
    }

    public boolean isManutenedor() {
        return manutenedor;
    }

    public void setManutenedor(boolean manutenedor) {
        this.manutenedor = manutenedor;
    }

    public Set<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<String> permissoes) {
        this.permissoes = permissoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.matricula);
        hash = 67 * hash + Objects.hashCode(this.telefone);
        hash = 67 * hash + Objects.hashCode(this.cargo);
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.area);
        hash = 67 * hash + (this.manutenedor ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.permissoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (this.manutenedor != other.manutenedor) {
            return false;
        }
        if (!Objects.equals(this.permissoes, other.permissoes)) {
            return false;
        }
        return true;
    }

  
}
