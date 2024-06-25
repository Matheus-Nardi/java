package com.mafn.jogos_jpa.dao.interfaces;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Genero;

public interface GeneroDAO {
	public List<Genero> obterTodos();
	public Optional<Genero> obterById(Long id);
	public void inserir(Genero genero);
	public void deletar(Long id);
	public void atualizar(Genero genero , Long id);
	public void fechar();
}
