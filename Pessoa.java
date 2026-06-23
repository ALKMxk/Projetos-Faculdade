package model;
public abstract class Pessoa {
    private String Nome;
    private String Cpf;
    private String Instrumento;

    public Pessoa(String Nome, String Cpf, String Instrumento){
        this.Nome = Nome;
        this.Cpf = Cpf;
        this.Instrumento = Instrumento;
    }

   public String getNome() { return Nome; }
    public void setNome(String nome) { this.Nome = nome; }

    public String getCpf() { return Cpf; }
    public void setCpf(String cpf) { this.Cpf = cpf; }

    public String getInstrumento() { return Instrumento; }
    public void setInstrumento(String instrumento) { this.Instrumento = instrumento; }
}
