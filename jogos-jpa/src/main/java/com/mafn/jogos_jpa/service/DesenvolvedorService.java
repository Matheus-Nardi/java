package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.impl.DesenvolvedorDaoImpl;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.utils.InputUtils;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class DesenvolvedorService {
	private EntityManager em;
	private DesenvolvedorDaoImpl desenDaoImpl;

	public DesenvolvedorService() {
		em = JpaUtil.getEntityManager();
		desenDaoImpl = new DesenvolvedorDaoImpl(em);
	}

	public void menuDesenvolvedor() {
		boolean continuar = true;
		while (continuar) {
			System.out.println("[1] Obter todos os desenvolvedores");
			System.out.println("[2] Inserir desenvolvedor");
			System.out.println("[3] Remover desenvolvedor");
			System.out.println("[4] Atualizar desenvolvedor");
			System.out.println("[9] Voltar");

			int opcao = InputUtils.lerInt();
			switch (opcao) {
			case 1 -> obterTodos().forEach(System.out::println);
			case 2 -> inserir();
			case 3 -> deletar();
			case 4 -> atualizar();
			case 9 -> continuar = false;
			default -> System.out.println("Escolha uma opção válida!");
			}
		}
	}

	public List<Desenvolvedor> obterTodos() {
		return desenDaoImpl.obterTodos();
	}

	public List<Desenvolvedor> obterByNome() {
		System.out.println("Informe o nome do desenvolvedor que será procurado: ");
		return desenDaoImpl.obterByNome(InputUtils.lerString());
	}

	public Desenvolvedor obterById() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do desenvolvedor que será procurado: ");
		return desenDaoImpl.obterById(InputUtils.lerLong()).get();
	}

	public Desenvolvedor obterById(Long id) {

		return desenDaoImpl.obterById(id).get();
	}

	public void inserir() {
		desenDaoImpl.inserir(InputUtils.lerDesenvolvedor());
	}

	public void deletar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do desenvolvedor que será deletado: ");
		desenDaoImpl.deletar(InputUtils.lerLong());
	}

	public void atualizar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do desenvolvedor que será atualizado:");
		Long id = InputUtils.lerLong();
		Desenvolvedor desenvolvedorFromDb = obterById(id);
		atualizarMenu(desenvolvedorFromDb);
		desenDaoImpl.atualizar(desenvolvedorFromDb, id);
	}

	private void atualizarMenu(Desenvolvedor desenvolvedor) {
		boolean editMenu = true;
		Integer escolha = 0;
		while (editMenu) {
			System.out.println("Escolha o que irá ser atualizado e confirme:");
			{
				System.out.println("[1] Nome");
				System.out.println("[2] Url do site");
				System.out.println("[3] Confirmar alterações");
				escolha = InputUtils.lerInt();
				switch (escolha) {
				case 1 -> desenvolvedor.setNome(InputUtils.lerString());
				case 2 -> desenvolvedor.setUrlSite(InputUtils.lerString());
				case 3 -> editMenu = false;
				default -> System.out.println("Escolha uma opção válida!");
				}

			}
		}
	}

	public void fechar() {
		desenDaoImpl.fechar();
	}
}
