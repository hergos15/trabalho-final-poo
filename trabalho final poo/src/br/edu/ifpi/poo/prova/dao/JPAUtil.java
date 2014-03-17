package br.edu.ifpi.poo.prova.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
private static EntityManager em;
	
	
	public static EntityManager getEntityManager(){
		if(em == null){
			em = Persistence.createEntityManagerFactory("pessoa-jpa").createEntityManager();
		}
		return em;
	}
}
