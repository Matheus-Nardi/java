package com.mafn.jogos_jpa.service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.mafn.jogos_jpa.dao.impl.DesenvolvedorDaoImpl;
import com.mafn.jogos_jpa.dao.impl.JogoDaoImpl;
import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.domain.Modo;
import com.mafn.jogos_jpa.utils.InputUtils;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class JogoService {
	private static final Scanner SCAN = new Scanner(System.in);
	private EntityManager em;
	private JogoDaoImpl jogoDaoImpl;
	private DesenvolvedorDaoImpl desenvolvedorDaoImpl;

	public JogoService() {
		this.em = JpaUtil.getEntityManager();
		this.jogoDaoImpl = new JogoDaoImpl(em);
		this.desenvolvedorDaoImpl = new DesenvolvedorDaoImpl(em);
	}

	public void menuJogo() {
		boolean continuar = true;
		while (continuar) {
			System.out.println("[1] Obter todos os jogos");
			System.out.println("[2] Obter jogo por nome");
			System.out.println("[3] Inserir jogo");
			System.out.println("[4] Remover jogo");
			System.out.println("[5] Atualizar jogo");
			System.out.println("[6] Filtros");
			System.out.println("[9] Voltar");

			int opcao = InputUtils.lerInt();
			switch (opcao) {
			case 1 -> obterTodos().forEach(System.out::println);
			case 2 -> obterByNome().forEach(System.out::println);
			case 3 -> inserir();
			case 4 -> deletar();
			case 5 -> atualizar();
			case 6 -> filtros();
			case 9 -> continuar = false;
			default -> System.out.println("Escolha uma opção válida");
			}
		}
	}

	public void filtros() {
		System.out.println("----------------");
		System.out.println("[1] Filtrar por genero");
		System.out.println("[2] Filtrar por modo");
		System.out.println("[3] Filtrar por desenvolvedor");
		Integer op = InputUtils.lerInt();
		switch (op) {
		case 1 -> filtrarJogoPorGenero().forEach(System.out::println);
		case 2 -> filtrarJogoPorModo().forEach(System.out::println);
		case 3 -> filtrarJogoPorDesenvolvedor().forEach(System.out::println);

		default -> System.out.println("Escolha uma opção válida");
		}

	}

	public List<Jogo> obterTodos() {
		return jogoDaoImpl.obterTodos();
	}

	public Jogo obterById() {
		System.out.println("Informe o id do jogo que a ser procurado:");
		Long id = InputUtils.lerLong();
		return jogoDaoImpl.obterById(id).get();
	}

	public Jogo obterById(Long id) {
		return jogoDaoImpl.obterById(id).get();
	}

	public List<Jogo> obterByNome() {
		System.out.println("Informe o nome do jogo a ser procurado: ");
		return jogoDaoImpl.oberByNome(InputUtils.lerString());
	}

	public List<Jogo> filtrarJogoPorGenero() {
		System.out.println("Informe o nome genero para o filtro: ");
		return jogoDaoImpl.filtrarJogoPorGenero(InputUtils.lerString());
	}

	public List<Jogo> filtrarJogoPorModo() {
		System.out.println("Informe o modo para o filtro: ");
		return jogoDaoImpl.filtrarJogoPorModo(InputUtils.lerEnumModo());
	}

	public List<Jogo> filtrarJogoPorDesenvolvedor() {
		System.out.println("Informe o nome do desenvolvedor a ser procurado: ");
		return jogoDaoImpl.filtrarJogoPorDesenvolvedor(InputUtils.lerString());
	}

	public void inserir() {
		jogoDaoImpl.inserir(InputUtils.lerJogo());
	}

	public void deletar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do jogo que será deletado: ");
		jogoDaoImpl.deletar(InputUtils.lerLong());
	}

	public void atualizar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do jogo que será atualizado:");
		Long id = InputUtils.lerLong();
		Jogo jogoFromDb = obterById(id);
		atualizarMenu(jogoFromDb);
		jogoDaoImpl.atualizar(jogoFromDb, id);
	}

	public void fechar() {
		jogoDaoImpl.fechar();
	}

	private void atualizarMenu(Jogo jogo) {
		boolean editMenu = true;
		Integer escolha = 0;
		while (editMenu) {
			System.out.println("Escolha o que irá ser atualizado e confirme!");
			{
				System.out.println("[1] Nome");
				System.out.println("[2] Preço");
				System.out.println("[3] Data de lancaçmento");
				System.out.println("[4] Desenvolvedor");
				System.out.println("[5] Modo");
				System.out.println("[6] Generos");
				System.out.println("[7] Confirmar alterações");
				escolha = InputUtils.lerInt();
				switch (escolha) {
				case 1 -> jogo.setNome(InputUtils.lerString());
				case 2 -> jogo.setPreco(InputUtils.lerDouble());
				case 3 -> jogo.setDataLancamento(InputUtils.lerData());
				case 4 -> jogo.setDesenvolvedor(InputUtils.lerDesenvolvedor());
				case 5 -> jogo.setModo(InputUtils.lerEnumModo());
				case 6 -> jogo.setGeneros(InputUtils.lerGeneros());
				case 7 -> editMenu = false;
				default -> System.out.println("Escolha uma opção válida!");
				}

			}
		}

		for (Genero genero : jogo.getGeneros())
			jogo.adiconarGenero(genero);
	}

}
