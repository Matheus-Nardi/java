package com.mafn.jogos_jpa;

import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.service.DesenvolvedorService;

public class OneToManyTest {
	public static void main(String[] args) {
		DesenvolvedorService service = new DesenvolvedorService();
		
		Desenvolvedor desenvolvedora = service.obterById(5l);
		
		service.fechar();
		for (Jogo jogo : desenvolvedora.getJogos()) {
			System.out.println(jogo.getNome());
		}
		
	}
}
