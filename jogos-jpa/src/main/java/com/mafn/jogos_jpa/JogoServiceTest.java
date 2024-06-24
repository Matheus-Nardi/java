package com.mafn.jogos_jpa;

import com.mafn.jogos_jpa.service.JogoService;

public class JogoServiceTest {
	public static void main(String[] args) {
		
		JogoService jogoService = new JogoService();
	
		System.out.println(jogoService.obterTodos());
		System.out.println(jogoService.obterById(201L));
		
		jogoService.fechar();
	}
}
