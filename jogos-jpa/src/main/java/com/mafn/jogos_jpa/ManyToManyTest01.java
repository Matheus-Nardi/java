package com.mafn.jogos_jpa;

import java.util.ArrayList;
import java.util.List;

import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.service.JogoService;

public class ManyToManyTest01 {
	
	public static void main(String[] args) {
		JogoService service = new  JogoService();
		
		List<Jogo> jogos = new ArrayList<Jogo>();
		List<Genero> generos = new ArrayList<>();
		
		
		Jogo jogo1 = Jogo.builder().nome("JOGO ACAO e AVENTURA 1").build();
		Jogo jogo2 = Jogo.builder().nome("JOGO ACAO e AVENTURA 2").build();
		
		jogos.add(jogo1);
		jogos.add(jogo2);
		
		Genero genero1 = Genero.builder().nome("Ação").build();
		Genero genero2 = Genero.builder().nome("Aventura").build();
		generos.add(genero1);
		generos.add(genero2);
		
		jogo1.setGeneros(generos);
		jogo2.setGeneros(generos);
		
		genero1.setJogos(jogos);
		genero2.setJogos(jogos);
		
		service.inserir(jogo1);
		service.inserir(jogo2);
		
		System.out.println(jogo1);
		
		
		
		
		service.fechar();
		
		
		
	}
}
