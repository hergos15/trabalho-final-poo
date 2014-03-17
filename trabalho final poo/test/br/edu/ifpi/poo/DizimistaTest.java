package br.edu.ifpi.poo;

import org.junit.Assert;
import org.junit.Test;

import br.edu.ifpi.poo.prova.model.Dizimista;

public class DizimistaTest {
private static Dizimista d;
	
	@BeforeClass
	public static void inicializar(){
		d = new Dizimista();
	}
	
	@Test
	public void testValidarNome(){
		d.setNome("Antonio");
		Assert.assertTrue(d.validarNome());
		d.setNome("Chico");
		Assert.assertTrue(d.validarNome());
	}
	
	@Test
	public void testValidarTelefone(){
		d.setTelefone("9456-4910");
		Assert.assertTrue(d.testValidarTelefone());
	}
	
	@Test
	public void testValidarCPF(){
		d.setCpf("111.222.333-44");
		Assert.assertTrue(d.testValidarCPF());
	}
	
}
