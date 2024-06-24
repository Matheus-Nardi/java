package com.mafn.jogos_jpa;

import com.mafn.jogos_jpa.dao.DAO;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.service.DesenvolvedorService;

public class AppDesenvolvedor {
	public static void main(String[] args) {

		

		Desenvolvedor desenvolvedor = Desenvolvedor.builder().nome("Epic Games")
				.urlSite("https://www.epicgames.com/site/pt-BR/home").build();
		
		Desenvolvedor desenvolvedor2 = Desenvolvedor.builder().nome("Riot Games").urlSite("https://www.riotgames.com/pt-br").build();
		Desenvolvedor desenvolvedor3 = Desenvolvedor.builder().nome("Ubisoft").urlSite("https://www.ubisoft.com/pt-br/").build();
		Desenvolvedor desenvolvedor4 = Desenvolvedor.builder().nome("Electronic Arts").urlSite("https://www.ea.com/pt-br").build();
		
		DesenvolvedorService devService = new DesenvolvedorService();
		devService.incluir(desenvolvedor4);
		
		System.out.println(devService.obterTodos());
		
		devService.fechar();
	}
}
