package model;

public class Cliente {

	final public static int TAM_MIN_NOME = 3;
	final public static int TAM_MAX_NOME = 20;
	final public static int NUM_DIGITOS_telefone = 14;
	final public static int TAM_CPF = 14;

	private String nome;
	private String telefone;
	private String cpf;

	public Cliente(String nome, String telefone, String cpf) {
		this.setNome = nome;
		this.setTelefone = telefone;
		this.setCpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException {
		validarNome(nome);
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws ModelException {
		validarTelefone(telefone);
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ModelException {
		validarCpf(cpf);
		this.cpf = cpf;
	}
	public static void validarNome(String nome) throws ModelException {
		if(nome == null || nome.length() == 0)
			throw new ModelException("O nome não pode ser nulo!");
		if(nome.length() < TAM_MIN_NOME || nome.length() > TAM_MAX_NOME)
			throw new ModelException("O nome deve ter de " + TAM_MIN_NOME +
					" a " + TAM_MAX_NOME + " caracteres!");
		for(int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if(!Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new ModelException("O nome só pode conter letras e espaço em branco!");
		}
	}
	public static void validarTelefone(String telefone) throws ModelException {
		if(telefone == null)
			throw new ModelException("O telefone não pode ser nulo!");
		if(telefone.length() != NUM_DIGITOS_telefone)
			throw new ModelException("O telefone deve conter 14 dígitos!");
	}
	public static void validarCpf(String cpf) throws ModelException {
		if(cpf == null)
			throw new ModelException("O cpf não pode ser nulo!");
		if(cpf.length() != TAM_CPF)
			throw new ModelException("O cpf deve ter " + TAM_CPF + " caracteres!");
		for(int i = 0; i < TAM_CPF; i++) {
			char c = cpf.charAt(i);
			switch(i) {
				case 3:
				case 7:
					if(c != '.')
						throw new ModelException("Na posição " + i + " deve aparecer um '.' no cpf!");
					break;
				case 11:
					if(c != '-')
						throw new ModelException("Na posição " + i + " deve aparecer um '-' no cpf!");;
					break;
				default:
					if(!Character.isDigit(c))
						throw new ModelException("Na posição " + i + " deve aparecer dígito !");;
			}
		}
	}

}