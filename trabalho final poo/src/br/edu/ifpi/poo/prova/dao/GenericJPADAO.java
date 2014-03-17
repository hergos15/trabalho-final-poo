package br.edu.ifpi.poo.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericJPADAO<T> implements GenericDAO<T> {
	protected EntityManager em = JPAUtil.getEntityManager();
	protected Class<T> classe;
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		
		em.getTransaction().begin();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		em.close();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		em.getTransaction().commit();
	}

	@Override
	public void commitAndClose() {
		// TODO Auto-generated method stub
		commit();
		close();
	}

	@Override
	public void salvar(T entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
	}

	@Override
	public void atualizar(T entity) {
		// TODO Auto-generated method stub
		em.merge(entity);
	}

	@Override
	public List<T> listarTodos() {
		em.createNamedQuery(classe.getName() + ".buscarTodos").getResultList();
		return null;
	}

	@Override
	public T pesquisar(Object codigo) {
		return em.find(classe, codigo);

	}

	@Override
	public void remover(T entity) {
		// TODO Auto-generated method stub
		em.remove(entity);
	}


}
