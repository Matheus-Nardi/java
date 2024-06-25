package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.impl.JogoDaoImpl;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class JogoService {
	private EntityManager em;
	private JogoDaoImpl jogoDaoImpl;

	public JogoService() {
		this.em = JpaUtil.getEntityManager();
		this.jogoDaoImpl = new JogoDaoImpl(em);
	}

	public List<Jogo> obterTodos() {
		return jogoDaoImpl.obterTodos();
	}

	public Jogo obterById(Long id) {
		return jogoDaoImpl.obterById(id).get();
	}

	public void inserir(Jogo jogo) {
		jogoDaoImpl.inserir(jogo);
	}

	public void deletar(Long id) {
		jogoDaoImpl.deletar(id);
	}

	public void atualizar(Jogo jogo, Long id) {
		jogoDaoImpl.atualizar(jogo, id);
	}

	public void fechar() {
		jogoDaoImpl.fechar();
	}

}
