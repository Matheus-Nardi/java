package com.mafn.jogos_jpa.dao;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Jogo;

public interface JogoDAO {
	
	public List<Jogo> obterTodos();
	public Optional<Jogo> obterById(Long id);
	public void inserir(Jogo jogo);
	public void deletar(Long id);
	public void atualizar(Jogo jogo , Long id);
	public void fechar();
}
