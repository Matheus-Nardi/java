package com.mafn.jogos_jpa.service;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.dao.JogoDaoImpl;
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
	
	public void inserir(Jogo jogo) {
		jogoDaoImpl.inserir(jogo);
	}
	public List<Jogo> obterTodos() {
		return jogoDaoImpl.obterTodos();
	}
	
	public Jogo obterById(Long id){
		return jogoDaoImpl.obterById(id).get();
	}
	
	
	public void fechar() {
		jogoDaoImpl.fechar();
	}
	
}
