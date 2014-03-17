package br.edu.ifpi.poo.prova.dao;

import java.util.List;

public interface GenericDAO<T> {
public void open();
	
	public void close();
	
	public void commit();
	
	public void commitAndClose();
	
	public void salvar(T entity);
	
	public void atualizar(T entity);
	
	public List<T> listarTodos();
	
	public T pesquisar(Object id);
	
	public void remover(T entity);


}
