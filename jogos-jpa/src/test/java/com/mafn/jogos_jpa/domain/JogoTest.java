package com.mafn.jogos_jpa.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class JogoTest {
	private EntityManagerFactory emf;
	private EntityManager em;

	
	@BeforeEach
	void setUp() {
		emf = Persistence.createEntityManagerFactory("test_jogos_jpa");
		em = emf.createEntityManager();
	}
	
	@Test
	@DisplayName("Verificando a persistencia de um jogo")
	void verificarPersistenciaJogo_ReturnTrue() {
		em.getTransaction().begin();
		Jogo jogo = Jogo.builder()
		.nome("JOGO TEST")
		.preco(25.99)
		.dataLancamento(LocalDate.now())
		.build();
		em.persist(jogo);
		em.getTransaction().commit();
		assertNotNull(jogo.getId());
	}

}
