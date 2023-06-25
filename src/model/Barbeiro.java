package model;

public class Barbeiro {
	final public static int TAM_CPF = 14;
	final public static int TAM_MIN_NOME = 6;
	final public static int TAM_MAX_NOME = 40;
	
	
	private String nomeBar;
	/**
	 * @param nomeBar= a
	 * @param cpfBar
	 */
	public Barbeiro(String nomeBar, String cpfBar) {
		super();
		this.nomeBar = nomeBar;
		this.cpfBar = cpfBar;
	}
	private String cpfBar;
	

	public Barbeiro() {
		// TODO Auto-generated constructor stub
	}


	public String getNomeBar() {
		
		return nomeBar;
	}


	public void setNomeBar(String nomeBar) throws Exception {
		validarNome(nomeBar);
		this.nomeBar = nomeBar;
	}


	public String getCpfBar() {
		return cpfBar;
	}


	public void setCpfBar(String cpfBar) throws Exception {
		validarCpf(cpfBar);
		this.cpfBar = cpfBar;
	}
	


	public static void validarNome(String nomeBar) throws Exception {
		if(nomeBar == null)
			throw new Exception("O nome não pode ser nulo!");
		if(nomeBar.length() < TAM_MIN_NOME || nomeBar.length() > TAM_MAX_NOME)
			throw new Exception("O nome deve ter entre " + TAM_MIN_NOME + " e " + TAM_MAX_NOME + " caracteres!");
		for(int i = 0; i < nomeBar.length(); i++) {
			char c = nomeBar.charAt(i);
			if( ! Character.isAlphabetic(c) && !Character.isSpaceChar(c))
				throw new Exception("O nome deve ter conter somentes letras e espaço em branco!");
		}
	}
public static void validarCpf(String cpfBar) throws Exception {
	if(cpfBar == null)
		throw new ModelException("O cpf não pode ser nulo!");
	if(cpfBar.length() != TAM_CPF)
		throw new Exception("O cpf deve ter " + TAM_CPF + " caracteres!");
	for(int i = 0; i < TAM_CPF; i++) {
		char c = cpfBar.charAt(i);
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

