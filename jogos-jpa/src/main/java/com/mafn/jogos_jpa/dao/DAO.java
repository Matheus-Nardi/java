package com.mafn.jogos_jpa.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import lombok.extern.log4j.Log4j2;
@Log4j2
public class DAO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("jogos_jpa");
			log.info("Entity Maneger Factory criado com sucesso!");
		} catch (Exception e) {
			log.error("Erro ao criar o Entity Maneger Factory , '{}'" , e.getMessage());
		}
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		try {
			abrirTransacao().em.persist(entidade);
			fecharTransacao();
			log.info("Entidade '{}' inserida com sucesso", entidade.getClass().getName());
		}catch(Exception e) {
			em.getTransaction().rollback();
			log.error("Erro ao inserir a entidade '{}'" , entidade.getClass().getName());
		}
		return this;
	}
	public List<E> obterTodos(int qtdRegistros , int deslocamento){
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		log.info("Obtendo os registros da tabela", classe.getSimpleName());
		String jpql =  "SELECT e FROM " + classe.getSimpleName()+ " e";
		TypedQuery<E> query = em.createQuery(jpql , classe);
		return query
				.setMaxResults(qtdRegistros)
				.setFirstResult(deslocamento).getResultList();
	}
	
	public void fechar(){
		em.close();
	}
}
