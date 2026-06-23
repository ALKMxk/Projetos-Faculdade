package view;

import model.Aluno;
import java.util.ArrayList;
import controller.EscolaController;

public class EscolaView {

   public void exibirAluno(Aluno aluno, String situacao) {
    String linha = aluno.getNome() + ": " + aluno.getFrequencia() + "% freq. - " + situacao;
    if (situacao.equals("APROVADO")) {
        linha += " | Certificado emitido OK";
    }
    System.out.println(linha);
}
    public void exibirRelatorio(ArrayList<Aluno> alunos, EscolaController ctrl) {
        System.out.println("\n=== Escola de Música Harmonia ===");
        for (Aluno aluno : alunos) {
            exibirAluno(aluno, ctrl.calcularSituacao(aluno));
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}