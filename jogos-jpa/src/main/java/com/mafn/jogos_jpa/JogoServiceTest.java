package com.mafn.jogos_jpa;

import java.time.LocalDate;

import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.domain.Modo;
import com.mafn.jogos_jpa.service.DesenvolvedorService;
import com.mafn.jogos_jpa.service.GeneroService;
import com.mafn.jogos_jpa.service.JogoService;

public class JogoServiceTest {
	public static void main(String[] args) {
		
		
		JogoService jogoService = new JogoService();
		DesenvolvedorService desenvolvedorService = new DesenvolvedorService();
		GeneroService generoService = new GeneroService();
	
		
		Jogo jogoUpdate = Jogo.builder()
				.nome("FIFA 24")
				.preco(129.99)
				.dataLancamento(LocalDate.of(2024, 02, 15))
				.desenvolvedor(desenvolvedorService.obterById(4L))
				.modo(Modo.MULTIPLAYER)
				.build();
		
		Genero generoById = generoService.obterById(3L);
		
		jogoUpdate.adiconarGenero(generoById);
		
		jogoService.atualizar(jogoUpdate, 301L);
		
		jogoService.fechar();
		desenvolvedorService.fechar();
		generoService.fechar();
	}
	
	
}
