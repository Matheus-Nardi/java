package map.app;

import java.util.ArrayList;
import java.util.List;

import map.model.Aluno;
import map.model.GestaoNotas;

public class GestaoNotasApp {
	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		for (int i = 0; i < 3; i++) {
			alunos.add(GestaoNotas.adicionarNotas());
		}
		
		GestaoNotas.atualizarNotas(alunos.get(2));
		GestaoNotas.exibirNotas();
		GestaoNotas.calcularMediaAluno(alunos.get(2));
		GestaoNotas.exibirMediaTurma();
	}
}
