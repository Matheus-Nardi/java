package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.impl.DesenvolvedorDaoImpl;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class DesenvolvedorService {
	private EntityManager em;
	private DesenvolvedorDaoImpl desenDaoImpl;
	
	public DesenvolvedorService() {
		em = JpaUtil.getEntityManager();
		desenDaoImpl = new DesenvolvedorDaoImpl(em);
	}
	
	public List<Desenvolvedor> obterTodos() {
		return desenDaoImpl.obterTodos();
	}

	public Desenvolvedor obterById(Long id) {
		return desenDaoImpl.obterById(id).get();
	}

	public void inserir(Desenvolvedor desenvolvedor) {
		desenDaoImpl.inserir(desenvolvedor);
	}

	public void deletar(Long id) {
		desenDaoImpl.deletar(id);
	}

	public void atualizar(Desenvolvedor desenvolvedor, Long id) {
		desenDaoImpl.atualizar(desenvolvedor, id);
	}

	public void fechar() {
		desenDaoImpl.fechar();
	}
}
