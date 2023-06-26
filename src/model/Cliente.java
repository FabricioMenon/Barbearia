package model;

public class Cliente {
	private String nome;
	private String telefone;
	private String cpf;

public Cliente(String nome, String telefone, String cpf) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}
	
	public Cliente (String nome, String telefone) {
		this.setNome(nome);
		this.setTelefone(telefone);
		
		
		
}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}