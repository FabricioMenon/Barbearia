package model.dao;

import model.Cliente;
import model.ModelException;

import util.MinhaLista;

public class DaoCliente<cliente> extends AbstractDao {
    //
    // CONSTANTES
    //
    final public static int NUM_MAX_CLIENTES = 10;

    //
    // ATRIBUTOS ESTÁTICOS
    //
    private static MinhaLista listaCliente = new MinhaLista();

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
            if (!(novaLista[i] instanceof Cliente))
                throw new ModelException("Há a presença de um objeto que não é um Cliente na lista");
            DaoCliente.listaCliente.incluir(novaLista[i]);
        }
    }


     *
     * @return
     */
    public static int getNumCliente() {
        return DaoCliente.listaCliente.getNumElementos();
    }

    /**
     * Operação que faz a inclusão de um novo objeto Pessoa e que garante sua
     * persistência
     */
    public void incluir(Object novo) throws ModelException {
        if (!(novo instanceof Cliente))
            throw new ModelException("Você solicitou a persistência de um objeto que não é um CLiente");
        DaoCliente.listaCliente.incluir(novo);
    }

    /**
     * Operação que faz a alteração do objeto Pessoa e que garante sua persistência
     */
    public void alterar(Object obj) throws ModelException {
        if (!(obj instanceof Cliente))
            throw new ModelException("Você solicitou a alteração de um objeto que não é um cliente");
        // Verificando se o obj já fazia parte da lista de Pessoas
        if (DaoCliente.listaCliente.posicaoElemento(obj) == MinhaLista.NAO_ACHEI)
            throw new ModelException(
                    "Você solicitou a alteração de um objeto que não existia. Chame o método incluir primeiro!");
    }

    /**
     * Operação que faz a exclusão do objeto Pessoa e que garante a persistência
     * desse estado
     */
    public void excluir(Object obj) throws ModelException {
        // Verificando se o objeto passado é, de fato, um Pessoa
        if (!(obj instanceof Cliente))
            throw new ModelException("Você solicitou a exclusão de um objeto que não é um cliente");

        // Verificando se o obj já fazia parte da lista de Pessoas
        if (DaoCliente.listaCliente.excluir(obj) == false)
            throw new ModelException("Você solicitou a exclusão de um objeto que não faz parte da lista de Pessoas");
    }

    /**
     * Método que retorna uma cópia da lista de todos os objetos Pessoa. Devolvo uma
     * cópia para garantir que ninguém irá trocar o estado do array oficial presente
     * no DaoPessoa sem que ele saiba.
     */
    public Object[] consultarTodos() throws ModelException {
        Object[] conj = DaoCliente.listaCliente.obterElementos();
        Cliente[] copia = new Cliente[conj.length];
        for (int i = 0; i < conj.length; i++)
            copia[i] = (Cliente) conj[i];
        return copia;
    }

    /**
     * Retorna o objeto Pessoa que tem o cpf informado
     *
     * @param matr
     * @return
     * @throws ModelException
     */
    public Cliente consultarPeloCpf(String cpf) throws ModelException {
        for (int i = 0; i < DaoCliente.listaCliente.getNumElementos(); i++) {
            Cliente p = (Cliente) DaoCliente.listaCliente.elementoPos(i);
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
}