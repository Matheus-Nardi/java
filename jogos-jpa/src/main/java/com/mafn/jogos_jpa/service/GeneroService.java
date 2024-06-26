package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.impl.GeneroDaoImpl;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.utils.InputUtils;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class GeneroService {
	private EntityManager em;
	private GeneroDaoImpl generoDaoImpl;

	public GeneroService() {
		em = JpaUtil.getEntityManager();
		generoDaoImpl = new GeneroDaoImpl(em);
	}
	public void menuGenero() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("[1] Obter todos os generos");
            System.out.println("[2] Inserir genero");
            System.out.println("[3] Remover genero");
            System.out.println("[4] Atualizar genero");
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

	public List<Genero> obterTodos() {
		return generoDaoImpl.obterTodos();
	}

	public Genero obterById() {
		System.out.println("Informe o id do genero que será procurado:");
		return generoDaoImpl.obterById(InputUtils.lerLong()).get();
	}

	public Genero obterById(Long id) {
		return generoDaoImpl.obterById(id).get();
	}

	public void inserir() {
		generoDaoImpl.inserir(InputUtils.lerGenero());
	}

	public void deletar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do genero que será deletado:");
		generoDaoImpl.deletar(InputUtils.lerLong());
	}

	public void atualizar() {
		obterTodos().forEach(System.out::println);
		System.out.println("Informe o id do genero que será atualizado!");
		Long id = InputUtils.lerLong();
		Genero generoFromBd = obterById(id);
		atualizarMenu(generoFromBd);
		generoDaoImpl.atualizar(generoFromBd, id);
	}

	private void atualizarMenu(Genero genero) {
		boolean editMenu = true;
		Integer escolha = 0;
		while (editMenu) {
			System.out.println("Escolha o que irá ser atualizado e confirme!");
			System.out.println("[1] Nome");
			System.out.println("[2] Confirmar alterações");
			escolha = InputUtils.lerInt();
			switch (escolha) {
			case 1 -> genero.setNome(InputUtils.lerString());
			case 2 -> editMenu = false;
			default -> System.out.println("Escolha uma opção válida!");
			}

		}
	}

	public void fechar() {
		generoDaoImpl.fechar();
	}
}
