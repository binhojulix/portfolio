package model;

import java.security.PublicKey;

/**
 * Created by rm40246 on 19/11/2015.
 */
public class Carro {
    private String nome;
    private String descricao;
    private String foto;

    public Carro(){

    }

    public Carro(String foto, String nome, String descricao) {
        this.foto = foto;
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carro carro = (Carro) o;

        if (!nome.equals(carro.nome)) return false;
        if (!descricao.equals(carro.descricao)) return false;
        return foto.equals(carro.foto);

    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + descricao.hashCode();
        result = 31 * result + foto.hashCode();
        return result;
    }
}
