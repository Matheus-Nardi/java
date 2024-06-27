package com.mafn.jogos_jpa.dao.impl;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.dao.interfaces.JogoDAO;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Jogo;
import com.mafn.jogos_jpa.domain.Modo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JogoDaoImpl implements JogoDAO {

	private EntityManager em;

	public JogoDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Jogo> obterTodos() {
		String jpql = "SELECT j FROM Jogo j";
		TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class);
		return query.setMaxResults(10).setFirstResult(0).getResultList();
	}
	
	public List<Jogo> filtrarJogoPorGenero(String generoNome) {
		  String jpql = "SELECT j FROM Jogo j JOIN j.generos g WHERE g.nome LIKE :generoNome";
		    return em.createQuery(jpql, Jogo.class)
		             .setParameter("generoNome", "%" + generoNome + "%")
		             .getResultList();
	}
	
	public List<Jogo> filtrarJogoPorModo(Modo modo) {
		String jpql = "SELECT j FROM Jogo j WHERE j.modo = :modo";
		return em.createQuery(jpql, Jogo.class)
				.setParameter("modo", modo)
				.getResultList();
	}
	public List<Jogo> filtrarJogoPorDesenvolvedor(String desenvolvedorNome) {
		String jpql = "SELECT j FROM Jogo j JOIN j.desenvolvedor d WHERE d.nome = :nome";
		return em.createQuery(jpql, Jogo.class)
				.setParameter("nome", "%"+desenvolvedorNome+"%")
				.getResultList();
	}

	@Override
	public Optional<Jogo> obterById(Long id) {
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

	public List<Jogo> oberByNome(String nome) {
		String jpql = "SELECT j FROM Jogo j WHERE j.nome LIKE :nome";
		TypedQuery<Jogo> query = em.createQuery(jpql, Jogo.class);
		query.setParameter("nome", "%" + nome + "%");
		return query.setMaxResults(10).setFirstResult(0).getResultList();
	}

	@Override
	public void inserir(Jogo jogo) {
		log.info("Inserindo jogo ao banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(jogo);
			tx.commit();
			log.info("Jogo '{}' inserido com sucesso!", jogo.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao inserir o jogo '{}' no banco de dados. {}", jogo.getNome(), e.getMessage());
		}
	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando jogo do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Jogo jogoFromDB = obterById(id).get();
			em.remove(jogoFromDB);
			tx.commit();
			log.info("Jogo '{}' deletado com sucesso!", jogoFromDB.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao deletar o jogo '{}' no banco de dados. {}", id, e.getMessage());
		}

	}

	@Override
	public void atualizar(Jogo jogo, Long id) {
		log.info("Atualizando jogo do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(jogo);
			tx.commit();
			log.info("Jogo '{}' atualizado com sucesso!", jogo.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao atualizar o jogo '{}' no banco de dados. {}", id, e.getMessage());
		}
	}

	@Override
	public void fechar() {
		em.close();
	}

	@Override
	public List<Jogo> consultarPreco(String nomeConsulta, Object... params) {
		TypedQuery<Jogo> query = em.createNamedQuery(nomeConsulta, Jogo.class);
		for (int i = 0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		return query.getResultList();
	}

}
