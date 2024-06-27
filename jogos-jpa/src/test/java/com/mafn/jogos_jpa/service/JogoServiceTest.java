package com.mafn.jogos_jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mafn.jogos_jpa.dao.impl.JogoDaoImpl;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Genero;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.domain.Modo;

@ExtendWith(MockitoExtension.class)
class JogoServiceTest {

	@Mock
	private JogoDaoImpl jogoDaoImpl;

	@InjectMocks
	private JogoService jogoService;

	private Jogo jogo;

	@BeforeEach
	void setUp() {
		jogo = new Jogo(12L, "JogoTest", 20.99, LocalDate.now(), null, null, Modo.MULTIPLAYER);
		Genero genero = new Genero(1L, "Ação", List.of(jogo));
		Desenvolvedor desenvolvedor = new Desenvolvedor(1L, "Desenvolvedora Teste", "www.site.com", List.of(jogo));
		jogo.setGeneros(List.of(genero));
		jogo.setDesenvolvedor(desenvolvedor);
	}

	@Test
	@DisplayName("Deve retornar uma lista com 1 jogo")
	void deveRetornarUmaListaComUmJogo() {
		// Configurando o comportamento do mock
		when(jogoService.obterTodos()).thenReturn(Collections.singletonList(jogo));

		List<Jogo> jogos = jogoService.obterTodos();

		assertEquals(1, jogos.size());
		assertEquals(jogo, jogos.get(0));
		assertEquals("JogoTest", jogos.get(0).getNome());
	}

	@Test
	@DisplayName("Deve verificar se o método inserir foi chamado apenas uma vez")
	void deveVerificarSeOMetodoInserirFoiChamadoUmaVez() {
		jogoDaoImpl.inserir(jogo);
		verify(jogoDaoImpl, times(1)).inserir(jogo);
	}

	@Test
	@DisplayName("Deve retornar um jogo pelo ID")
	void deveRetornarUmJogoPeloId() {
		Mockito.when(jogoDaoImpl.obterById(jogo.getId())).thenReturn(Optional.of(jogo));
		Jogo jogoById = jogoDaoImpl.obterById(jogo.getId()).get();

		Assertions.assertEquals(12L, jogoById.getId());
	}

}
