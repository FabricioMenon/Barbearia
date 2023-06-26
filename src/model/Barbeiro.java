package model;

public class Barbeiro {
	final public static int TAM_CPF = 14;
	final public static int TAM_MIN_NOME = 6;
	final public static int TAM_MAX_NOME = 40;

	private String cpfBarbeiro;
	private String nomeBarbeiro;
	/**
	 * @param nomeBarbeiro= a
	 * @param cpfBarbeiro
	 */
	public Barbeiro(String nomeBarbeiro, String cpfBarbeiro) {
		this.setNomeBarbeiro = nomeBarbeiro;
		this.setCpfBarbeiro = cpfBarbeiro;
	}

	public String getnomeBarbeiro() {
		return nomeBarbeiro;
	}


	public void setNomeBarbeiro(String nomeBarbeiro) throws Exception {
		validarNome(nomeBarbeiro);
		this.nomeBarbeiro = nomeBarbeiro;
	}


	public String getcpfBarbeiro() {
		return cpfBarbeiro;
	}


	public void setCpfBarbeiro(String cpfBarbeiro) throws Exception {
		validarCpf(cpfBarbeiro);
		this.cpfBarbeiro = cpfBarbeiro;
	}
	


	public static void validarNome(String nomeBarbeiro) throws Exception {
		if(nomeBarbeiro == null)
			throw new Exception("O nome não pode ser nulo!");
		if(nomeBarbeiro.length() < TAM_MIN_NOME || nomeBarbeiro.length() > TAM_MAX_NOME)
			throw new Exception("O nome deve ter entre " + TAM_MIN_NOME + " e " + TAM_MAX_NOME + " caracteres!");
		for(int i = 0; i < nomeBarbeiro.length(); i++) {
			char c = nomeBarbeiro.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new Exception("O nome deve ter conter somentes letras e espaço em branco!");
		}
	}
public static void validarCpf(String cpfBarbeiro) throws Exception {
	if(cpfBarbeiro == null)
		throw new ModelException("O cpf não pode ser nulo!");
	if(cpfBarbeiro.length() != TAM_CPF)
		throw new Exception("O cpf deve ter " + TAM_CPF + " caracteres!");
	for(int i = 0; i < TAM_CPF; i++) {
		char c = cpfBarbeiro.charAt(i);
		switch(i) {
			case 3:
			case 7: 
				if(c != '.')
					throw new Exception("Na posição " + i + " deve aparecer um '.' no cpf!");
				break;
			case 11:
				if(c != '-')
					throw new Exception("Na posição " + i + " deve aparecer um '-' no cpf!");;
				break;
			default: 
				if(!Character.isDigit(c))
					throw new Exception("Na posição " + i + " deve aparecer dígito !");;
		}
	}
}
}

