package model.dao;

import model.Barbeiro;
import model.ModelException;

import util.MinhaLista;

public class DaoBarbeiro<Barbeiro> extends AbstractDao {
    //
    // CONSTANTES
    //
    final public static int NUM_MAX_BarbeiroS = 10;

    //
    // ATRIBUTOS ESTÁTICOS
    //
    private static MinhaLista listaBarbeiro = new MinhaLista();

    //
    // MÉTODOS
    //

    /**
     * Método que determina qual é a lista de objetos que o DaoPessoa irá gerenciar.
     * Esse método deverá ser chamado pelo método recuperarObjetos presente na
     * classe Dao
     */
    public void incluirTodos(Object[] novaLista) throws ModelException {
        for (int i = 0; i < novaLista.length; i++) {
            if (novaLista[i] == null)
                break;
            if (!(novaLista[i] instanceof Barbeiro))
                throw new ModelException("Há a presença de um objeto que não é Pessoa na lista");
            DaoBarbeiro.listaBarbeiro.incluir(novaLista[i]);
        }
    }

    /**
     * Retorna o número de Pessoas presente na lista de persistência
     *
     * @return
     */
    public static int getNumBarbeiro() {
        return DaoBarbeiro.listaBarbeiro.getNumElementos();
    }

    /**
     * Operação que faz a inclusão de um novo objeto Pessoa e que garante sua
     * persistência
     */
    public void incluir(Object novo) throws ModelException {
        if (!(novo instanceof Barbeiro))
            throw new ModelException("Você solicitou a persistência de um objeto que não é Pessoa");
        DaoBarbeiro.listaBarbeiro.incluir(novo);
    }

    /**
     * Operação que faz a alteração do objeto Pessoa e que garante sua persistência
     */
    public void alterar(Object obj) throws ModelException {
        if (!(obj instanceof Barbeiro))
            throw new ModelException("Você solicitou a alteração de um objeto que não é Pessoa");
        // Verificando se o obj já fazia parte da lista de Pessoas
        if (DaoBarbeiro.listaBarbeiro.posicaoElemento(obj) == MinhaLista.NAO_ACHEI)
            throw new ModelException(
                    "Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");
    }

    /**
     * Operação que faz a exclusão do objeto Pessoa e que garante a persistência
     * desse estado
     */
    public void excluir(Object obj) throws ModelException {
        // Verificando se o objeto passado é, de fato, um Pessoa
        if (!(obj instanceof Barbeiro))
            throw new ModelException("Você solicitou a exclusão de um objeto que não é Pessoa");

        // Verificando se o obj já fazia parte da lista de Pessoas
        if (DaoBarbeiro.listaBarbeiro.excluir(obj) == false)
            throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de Pessoas");
    }

    /**
     * Método que retorna uma cópia da lista de todos os objetos Pessoa. Devolvo uma
     * cópia para garantir que ninguém irá trocar o estado do array oficial presente
     * no DaoPessoa sem que ele saiba.
     */
    public Object[] consultarTodos() throws ModelException {
        Object[] conj = DaoBarbeiro.listaBarbeiro.obterElementos();
        Barbeiro[] copia = new Barbeiro[conj.length];
        for (int i = 0; i < conj.length; i++)
            copia[i] = (Barbeiro) conj[i];
        return copia;
    }

    /**
     * Retorna o objeto Pessoa que tem o cpf informado
     *
     * @param matr
     * @return
     * @throws ModelException
     */
    public Barbeiro consultarPeloCpf(String cpf) throws ModelException {
        for (int i = 0; i < DaoBarbeiro.listaBarbeiro.getNumElementos(); i++) {
            Barbeiro p = (Barbeiro) DaoBarbeiro.listaBarbeiro.elementoPos(i);
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
}