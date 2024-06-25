package com.mafn.jogos_jpa.dao.impl;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.dao.interfaces.DesenvolvedorDAO;
import com.mafn.jogos_jpa.domain.Desenvolvedor;
import com.mafn.jogos_jpa.domain.Jogo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class DesenvolvedorDaoImpl implements DesenvolvedorDAO {

	private EntityManager em;

	public DesenvolvedorDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Desenvolvedor> obterTodos() {
		String jpql = "SELECT d FROM Desenvolvedor d";
		TypedQuery<Desenvolvedor> query = em.createQuery(jpql, Desenvolvedor.class);
		return query.setMaxResults(10).setFirstResult(0).getResultList();
	}

	@Override
	public Optional<Desenvolvedor> obterById(Long id) {
		Desenvolvedor desenvolvedorById = null;
		try {
			desenvolvedorById = em.find(Desenvolvedor.class, id);
			if (desenvolvedorById != null)
				log.info("Desenvolvedor encontrado com o id '{}' : '{}'", id, desenvolvedorById.getNome());
		} catch (Exception e) {
			log.error("Erro ao procurar pelo desenvolvedor de id '{}' : {}", id, e);
		}

		if (desenvolvedorById != null)
			return Optional.of(desenvolvedorById);

		return Optional.empty();
	}

	@Override
	public void inserir(Desenvolvedor desenvolvedor) {
		log.info("Inserindo desenvolvedor ao banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(desenvolvedor);
			tx.commit();
			log.info("Desenvolvedor '{}' inserido com sucesso!", desenvolvedor.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao inserir o desenvolvedor '{}' no banco de dados. {}", desenvolvedor.getNome(),
					e.getMessage());
		}

	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando desenvolvedor do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Desenvolvedor desenvolvedorFromDB = obterById(id).get();
			em.remove(desenvolvedorFromDB);
			tx.commit();
			log.info("Desenvolvedor '{}' deletado com sucesso!", desenvolvedorFromDB.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao deletar o desenvolvedor '{}' no banco de dados. {}", id, e.getMessage());
		}

	}

	@Override
	public void atualizar(Desenvolvedor desenvolvedor, Long id) {
		log.info("Atualizando desenvolvedor do banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Desenvolvedor desenvolvedorFromDB = obterById(id).get();
			Desenvolvedor desenvolvedorToUpdate = Desenvolvedor.builder().id(desenvolvedorFromDB.getId())
					.nome(desenvolvedor.getNome()).urlSite(desenvolvedor.getUrlSite()).build();
			em.merge(desenvolvedorToUpdate);
			tx.commit();
			log.info("Desenvolvedor '{}' atualizado com sucesso!", desenvolvedorToUpdate.getNome());
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.info("Erro ao atualizar o desenvolvedor '{}' no banco de dados. {}", id, e.getMessage());
		}

	}

	@Override
	public void fechar() {
		em.close();

	}

}
