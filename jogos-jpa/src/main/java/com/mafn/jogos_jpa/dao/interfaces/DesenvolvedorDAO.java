package com.mafn.jogos_jpa.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Desenvolvedor;

public interface DesenvolvedorDAO {
	public List<Desenvolvedor> obterTodos();
	public Optional<Desenvolvedor> obterById(Long id);
	public void inserir(Desenvolvedor desenvolvedor);
	public void deletar(Long id);
	public void atualizar(Desenvolvedor desenvolvedor , Long id);
	public void fechar();
}
