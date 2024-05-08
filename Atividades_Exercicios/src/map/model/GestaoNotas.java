package map.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestaoNotas {

	private static Map<Integer, Double[]> alunos = new HashMap<Integer, Double[]>();

	public static Map<Integer, Double[]> getAlunos() {
		return alunos;
	}

	public static Aluno adicionarNotas() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o numero de matricula do aluno: ");
		int matricula = scan.nextInt();
		Double[] notas = new Double[3];
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Informe a " + (i + 1) + "° nota: ");
			notas[i] = scan.nextDouble();
		}

		Aluno a = new Aluno(matricula, notas);
		alunos.put(a.getNumeroMatricula(), a.getNotas());
		System.out.println("As notas foram adicionadas");
		return a;
	}

	public static void atualizarNotas(Aluno aluno) {
		Scanner scan = new Scanner(System.in);
		if (alunos.containsKey(aluno.getNumeroMatricula())) {
			for (int i = 0; i < aluno.getNotas().length; i++) {
				System.out.println("Informe a nova " + (i + 1) + "° nota: ");
				aluno.getNotas()[i] = scan.nextDouble();
			}
		} else
			throw new IllegalArgumentException("Matricula não encontrada!");

	}

	public static void exibirNotas() {
		for (Map.Entry<Integer, Double[]> entry : alunos.entrySet()) {
			System.out.println(entry.getKey());
			for (Double notas : entry.getValue()) {
				System.out.println(notas);
			}
		}
	}

	public static void calcularMediaAluno(Aluno aluno) {
		Double total = 0.0;
		if (alunos.containsKey(aluno.getNumeroMatricula())) {
			for (Double notas : aluno.getNotas()) {
				total += notas;
			}
		}

		System.out.println("Media do aluno: " + total / aluno.getNotas().length);
	}

	public static void exibirMediaTurma() {
		Double total = 0.0;

		for (Map.Entry<Integer, Double[]> entry : alunos.entrySet()) {
			for (Double notas : entry.getValue()) {
				total += notas;
			}
		}

		System.out.println("A média da turma é: " + total / alunos.size());
	}
}
