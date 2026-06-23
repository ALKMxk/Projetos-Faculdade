package model;
import  java.util.ArrayList;
public class Professor extends Pessoa {
    private String formacao;
    private ArrayList<String> turmas;

    public Professor(String nome, String cpf, String instrumento, String formacao) {
        super(nome, cpf, instrumento);
        this.formacao = formacao;
        this.turmas = new ArrayList<>();
    }
public String getFormacao() { return formacao; }
    public void setFormacao(String formacao) { this.formacao = formacao; }

    public ArrayList<String> getTurmas() { return turmas; }

    public void adicionarTurma(String turma) {
        turmas.add(turma);
    }
}
