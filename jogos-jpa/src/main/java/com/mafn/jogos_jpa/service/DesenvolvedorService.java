package com.mafn.jogos_jpa.service;

import java.util.List;

import com.mafn.jogos_jpa.dao.DAO;
import com.mafn.jogos_jpa.domain.Desenvolvedor;

public class DesenvolvedorService {

	private DAO<Desenvolvedor> daoDesenvolvedor;

	public DesenvolvedorService() {
		daoDesenvolvedor = new DAO<Desenvolvedor>(Desenvolvedor.class);
	}

	public void incluir(Desenvolvedor desenvolvedor) {
		daoDesenvolvedor.incluir(desenvolvedor);
	}

	public List<Desenvolvedor> obterTodos() {
		return daoDesenvolvedor.obterTodos(10, 0);
	}
	
	public void fechar() {
		daoDesenvolvedor.fechar();
	}
}
