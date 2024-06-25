package com.mafn.jogos_jpa;

import java.time.LocalDate;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.service.DesenvolvedorService;
import com.mafn.jogos_jpa.service.JogoService;
import com.mafn.jogos_jpa.utils.JpaUtil;

import jakarta.persistence.EntityManager;

public class JogoServiceTest {
	public static void main(String[] args) {
		
		EntityManager em = JpaUtil.getEntityManager();
		JogoService jogoService = new JogoService();
		DesenvolvedorService desenvolvedorService = new DesenvolvedorService();
	
		
		Desenvolvedor desenvolvedor = Desenvolvedor.builder().nome("Mediatonic").urlSite("https://www.mediatonicgames.com/").build();
		
		jogoService.obterTodos().forEach(System.out::println);
		Jogo jogoToUpdate = Jogo.builder()
		.nome("Fall Guys")
		.dataLancamento(LocalDate.of(2020, 8, 04))
		.desenvolvedor(desenvolvedor)
		.preco(00.00)
		.build();
		
		jogoService.atualizar(jogoToUpdate, 251l);
		System.out.println(jogoService.obterById(251L));
		
		jogoService.fechar();
		desenvolvedorService.fechar();
	}
	
	
}
