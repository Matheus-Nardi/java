package com.mafn.jogos_jpa.dao.impl;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.dao.interfaces.GeneroDAO;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Genero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class GeneroDaoImpl implements GeneroDAO {

	private EntityManager em;
	
	
	public GeneroDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Genero> obterTodos() {
		String jpql = "SELECT g FROM Genero g";
		TypedQuery<Genero> query = em.createQuery(jpql, Genero.class);
		return query.setMaxResults(10).setFirstResult(0).getResultList();
	}

	@Override
	public Optional<Genero> obterById(Long id) {
		Genero generoById = null;
		try {
			generoById = em.find(Genero.class, id);
			if (generoById != null)
				log.info("Genero encontrado com o id '{}' : '{}'", id, generoById.getNome());
		} catch (Exception e) {
			log.error("Erro ao procurar pelo genero de id '{}' : {}", id, e);
		}

		if (generoById != null)
			return Optional.of(generoById);

		return Optional.empty();
	}

	@Override
	public void inserir(Genero genero) {
		log.info("Inserindo genero ao banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(genero);
			tx.commit();
			log.info("Genero '{}' inserido com sucesso!", genero.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao inserir o genero '{}' no banco de dados. {}", genero.getNome(),
					e.getMessage());
		}

		
	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando genero do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Genero generoFromDB = obterById(id).get();
			em.remove(generoFromDB);
			tx.commit();
			log.info("Genero '{}' deletado com sucesso!", generoFromDB.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao deletar o genero '{}' no banco de dados. {}", id, e.getMessage());
		}
		
	}

	@Override
	public void atualizar(Genero genero, Long id) {
		log.info("Atualizando genero do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(genero);
			tx.commit();
			log.info("Genero '{}' atualizado com sucesso!", genero.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao atualizar o genero '{}' no banco de dados. {}", id, e.getMessage());
		}
		
	}

	@Override
	public void fechar() {
		em.close();
	}
	
}
