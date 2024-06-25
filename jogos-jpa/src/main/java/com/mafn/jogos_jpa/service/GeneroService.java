package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.impl.GeneroDaoImpl;
import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class GeneroService {
	private EntityManager em;
	private GeneroDaoImpl generoDaoImpl;
	
	public GeneroService() {
		em = JpaUtil.getEntityManager();
		generoDaoImpl = new GeneroDaoImpl(em);
	}
	
	public List<Genero> obterTodos() {
		return generoDaoImpl.obterTodos();
	}

	public Genero obterById(Long id) {
		return generoDaoImpl.obterById(id).get();
	}

	public void inserir(Genero genero) {
		generoDaoImpl.inserir(genero);
	}

	public void deletar(Long id) {
		generoDaoImpl.deletar(id);
	}

	public void atualizar(Genero genero, Long id) {
		generoDaoImpl.atualizar(genero, id);
	}

	public void fechar() {
		generoDaoImpl.fechar();
	}
}
