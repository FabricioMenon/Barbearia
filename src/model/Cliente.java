package model;

public class Cliente {
	private String nome;
	private int telefone;


	public Cliente() {
	}

	public Cliente (String nome, int telefone) {
		this.setNome(nome);
		this.setTelefone(telefone);
		
		
		
}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
}