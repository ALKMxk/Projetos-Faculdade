package model;
public class Aluno extends Pessoa {
    private String nivel;
    private double frequencia;

    public Aluno(String nome, String cpf, String instrumento, String nivel, double frequencia) {
        super(nome, cpf, instrumento);
        this.nivel = nivel;
        this.frequencia = frequencia;
    }                           

    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public double getFrequencia() { return frequencia; }
    public void setFrequencia(double frequencia) { this.frequencia = frequencia; }

}                                  