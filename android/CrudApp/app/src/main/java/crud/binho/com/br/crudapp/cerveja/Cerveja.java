package crud.binho.com.br.crudapp.cerveja;

/**
 * Created by binho on 26/12/2015.
 */
public class Cerveja {

    private Integer id;
    private String nome;
    private int nota;
    private String foto;
    private double valor;

    public Cerveja() {
    }

    public Cerveja(String nome, int nota, String foto) {
        this.nome = nome;
        this.nota = nota;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
