package br.com.caelum.task;

import org.apache.tools.ant.Task;

public class MensagemTask extends Task {

    private int prioridade;
    private String mensagem;

    @Override
    public void execute() {
        if(this.prioridade > 1) {
            this.mensagem = this.mensagem.toUpperCase();
            
            System.out.println(this.mensagem);
        }
    }

    public void addText(String mensagem) {
        this.mensagem = mensagem == null ? "" : mensagem.trim();
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
