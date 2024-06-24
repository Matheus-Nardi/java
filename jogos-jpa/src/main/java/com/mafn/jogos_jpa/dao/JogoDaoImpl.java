package com.mafn.jogos_jpa.dao;

import java.util.List;
import java.util.Optional;

import com.mafn.jogos_jpa.domain.Jogo;

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
	
	@Override
	public void inserir(Jogo jogo) {
		log.info("Inserindo jogo ao banco de dados.");
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(jogo);
			tx.commit();
			log.info("Jogo '{}' inserido com sucesso!" , jogo.getNome());
		}catch(Exception e){
			em.getTransaction().rollback();
			log.info("Erro ao inserir o jogo '{}' no banco de dados. {}" , jogo.getNome() , e.getMessage());
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Jogo jogo, Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void fechar() {
		em.close();
	}


}
