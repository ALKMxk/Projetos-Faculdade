package persistence;

import model.Aluno;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistencia {

    private static final String ARQUIVO = "frequencia.txt";

    
    public void salvar(ArrayList<Aluno> alunos) throws IOException {
        FileWriter fw = new FileWriter(ARQUIVO);
        for (Aluno aluno : alunos) {
            fw.write(aluno.getNome() + ";" + aluno.getFrequencia() + "\n");
        }
        fw.close();
        System.out.println("frequencia.txt salvo ✓");
    }

    
    public void carregar() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(ARQUIVO));
        String linha;
        System.out.println("\n--- Recarregando frequencia.txt ---");
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            System.out.println("Nome: " + partes[0] + " | Frequência: " + partes[1] + "%");
        }
        br.close();
    }
}