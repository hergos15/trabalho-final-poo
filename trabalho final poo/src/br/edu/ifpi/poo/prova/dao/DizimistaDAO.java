package br.edu.ifpi.poo.prova.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.*;

import br.edu.ifpi.poo.prova.model.Dizimista;

public class DizimistaDAO {
private EntityManager em = Persistence.createEntityManagerFactory("pessoa-jpa").createEntityManager();
	
	public void fechar(){
		em.close();
	}
	
	public void commit(){
		em.getTransaction().commit();
	}
	
	public void iniciar(){
		em.getTransaction().begin();
	}
	
	public boolean salvar(Dizimista d){
		em.persist(d);
		return true; 
	}
	public void apagar(Dizimista d){
		em.remove(d);
	}
	
	public void atualizar(Dizimista d){
		em.merge(d);
	}
	
	public Dizimista procurar(Long id){
		return em.find(Dizimista.class, id);
	}
	
	public List<Dizimista> listarTodos(){
		Query query = em.createNamedQuery("Pessoa.buscarTodos");
		return query.getResultList();
	}
	
	public Dizimista procurarPorCpf(String cpf){
		Query query = em.createNamedQuery("Pessoa.buscarPorCpf");
		query.setParameter("cpf", cpf);
		return (Dizimista) query.getSingleResult();
	}

}
