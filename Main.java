import model.Aluno;
import controller.EscolaController;
import view.EscolaView;
import exception.FrequenciaInsuficienteException;
import persistence.Persistencia;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EscolaController ctrl = new EscolaController();
        EscolaView view = new EscolaView();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cadastro de Alunos - Escola de Musica Harmonia ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Novo Aluno ---");

            System.out.print("Nome: ");
            String nome = sc.nextLine();

            System.out.print("CPF: ");
            String cpf = sc.nextLine();

            System.out.print("Instrumento: ");
            String instrumento = sc.nextLine();

            System.out.print("Nivel (Basico/Intermediario/Avancado): ");
            String nivel = sc.nextLine();

            System.out.print("Frequencia (%): ");
            int frequencia = Integer.parseInt(sc.nextLine().trim());

            Aluno aluno = new Aluno(nome, cpf, instrumento, nivel, frequencia);
            ctrl.cadastrarAluno(aluno);

            System.out.print("\nDeseja cadastrar outro aluno? (s/n): ");
            String resposta = sc.nextLine().trim().toLowerCase();
            continuar = resposta.equals("s");
        }

        System.out.println("\n=== Escola de Musica Harmonia ===");
        for (Aluno aluno : ctrl.getAlunos()) {
            String situacao = ctrl.calcularSituacao(aluno);
            view.exibirAluno(aluno, situacao);
            if (!situacao.equals("APROVADO")) {
                try {
                    ctrl.emitirCertificado(aluno);
                } catch (FrequenciaInsuficienteException e) {
                    System.out.println("ERRO: Frequencia insuficiente - FrequenciaInsuficienteException");
                }
            }
        }

        Persistencia persistencia = new Persistencia();
        try {
            persistencia.salvar(ctrl.getAlunos());
            persistencia.carregar();
        } catch (Exception e) {
            System.out.println("Erro ao acessar arquivo: " + e.getMessage());
        }

        sc.close();
    }
}