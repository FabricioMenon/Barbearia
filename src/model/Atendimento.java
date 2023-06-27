package model;

public class Atendimento {
	private static String valor;

	public Atendimento() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getValor() throws ModelException {
		validarValor(null);
		return valor;
	}

	public void setValor(String valor) {
		Atendimento.valor = valor;
	}
	public static void validarValor(String valor) throws ModelException {
		if(valor == null)
			throw new ModelException("O valor não pode ser nula!");
		if(valor.length() < 0)
			throw new ModelException("O valor não pode ser menor que 0");

	}
}

