package com.mafn.jogos_jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Jogo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;

/**
 * Hello world!
 *
 */
@Log4j2
public class App {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jogos_jpa");
	private static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) {
		Jogo jogo = Jogo.builder().nome("Minecraft").dataLancamento(LocalDate.of(2006, 10, 10)).preco(120.99).build();
		// persistirJogo(em, jogo);
		// atualizarJogo(em, 301L);
		//deletar(em, 101L);
		obterJogos(em).forEach(System.out::println);

	}

	private static void persistirJogo(EntityManager em, Jogo jogo) {
		boolean persistiuSucesso = false;
		try {
			em.getTransaction().begin();
			em.persist(jogo);
			em.getTransaction().commit();
			persistiuSucesso = true;

		} catch (IllegalStateException | RollbackException e) {
			log.info("Erro ao persisitir um jogo no banco de dados ,  '{}'", e);
		} finally {
			em.close();
		}

		if (persistiuSucesso)
			log.info("Jogo persistido no banco de dados!");

	}

	private static Optional<Jogo> obterJogoById(EntityManager em, Long id) {
		Jogo jogoById = null;
		try {
			jogoById = em.find(Jogo.class, id);
			if (jogoById != null)
				log.info("Jogo encontrado com o id '{}' : '{}'", id, jogoById.getNome());
		} catch (Exception e) {
			log.error("Erro ao procurar pelo jogo de id '{}' : {}", id, e);
		}

		if (jogoById != null)
			return Optional.of(jogoById);

		return Optional.empty();
	}

	private static List<Jogo> obterJogos(EntityManager em) {
		String jpql = "SELECT j FROM Jogo j";
		TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class);
		return query.getResultList();
	}

	private static void atualizarJogo(EntityManager em, Long id) {
		boolean mergeSucesso = false;
		try {
			em.getTransaction().begin();
			Jogo jogoFromDB = obterJogoById(em, id).get();
			Jogo jogoToUpdate = Jogo.builder().nome("Fifa 2024").dataLancamento(jogoFromDB.getDataLancamento())
					.preco(120.99).build();
			em.merge(jogoToUpdate);
			em.getTransaction().commit();
			mergeSucesso = true;
		} catch (IllegalStateException | RollbackException e) {
			log.info("Erro ao atualizar um jogo no banco de dados ,  '{}'", e);
		} finally {
			em.close();
		}

		if (mergeSucesso)
			log.info("Jogo atualizado no banco de dados!");

	}

	private static void deletar(EntityManager em, Long id) {
		boolean mergeSucesso = false;
		try {
			em.getTransaction().begin();
			Jogo jogoFromDBToDelete = obterJogoById(em, id).get();
			em.remove(jogoFromDBToDelete);
			em.getTransaction().commit();
			mergeSucesso = true;
		} catch (IllegalStateException | RollbackException e) {
			log.info("Erro ao deletar um jogo no banco de dados ,  '{}'", e);
		} finally {
			em.close();
		}

		if (mergeSucesso)
			log.info("Jogo '{}' removido no banco de dados!" , id);
	}

}
