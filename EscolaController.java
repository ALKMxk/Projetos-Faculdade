package controller;
import java.util.ArrayList;
import exception.FrequenciaInsuficienteException;
import model.Aluno;

public class EscolaController {
    private ArrayList<Aluno> alunos;

    public EscolaController() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    public String calcularSituacao(Aluno aluno) {
    double freq = aluno.getFrequencia();
    if (freq >= 75) {
        return "APROVADO";
    } else if (freq >= 60) {
        return "ALERTA";
    } else {
        return "REPROVADO";
    }
}

public String emitirCertificado(Aluno aluno) throws FrequenciaInsuficienteException {
    if (aluno.getFrequencia() < 75) {
        throw new FrequenciaInsuficienteException(
            "Frequência insuficiente: " + aluno.getFrequencia() + "%"
        );
    }
    return "Certificado emitido para " + aluno.getNome();
}
}
