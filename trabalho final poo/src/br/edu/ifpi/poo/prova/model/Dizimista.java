package br.edu.ifpi.poo.prova.model;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Dizimista.buscarTodos", query="select d from Dizimista d"),
	@NamedQuery(name="DIzimista.buscarPorCpf", query="select d from Dizimista d where d.cpf = :cpf")
})
public class Dizimista {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	public Dizimista() {
		super();
	}


	public Dizimista(String nome, String cpf) {
		super();
		this.nome = nome;
		this.cpf = cpf;
	}


	public Dizimista(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dizimista other = (Dizimista) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dizimista [id=" + id + ", nome=" + nome + ", cpf=" + cpf
				+ ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}


	public boolean validarNome() {
		// TODO Auto-generated method stub
		String regex = "[a-z]*";
		return this.nome.toLowerCase().matches(regex);
	}


	public boolean testValidarTelefone() {
		// TODO Auto-generated method stub
		String regex = "\\d{4,4}-\\d{4,4}";
		return this.telefone.toLowerCase().matches(regex);
	}


	public boolean testValidarCPF() {
		// TODO Auto-generated method stub
		String regex = "^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$";
		return this.cpf.toLowerCase().matches(regex);
	}
	
	

}
