package util;

import model.Aluno;
import model.ModelException;
import model.dao.DaoAluno;

public class MinhaLista {
    final public static int NAO_ACHEI = -1;
    final public static int FATOR_CRESCIMENTO = 3;
    //
    // ATRIBUTOS
    //
    private Object[]   listaObjs;
    private int        numElementos;

    //
    // MÉTODOS
    //
    public MinhaLista() {
        this.listaObjs = new Object[FATOR_CRESCIMENTO];
        this.numElementos = 0;
    }

    /**
     * Inclui um novo objeto na lista
     * @param novo
     */
    public void incluir(Object novo) {
        // Se o array listaObjs está lotado...
        if(this.numElementos == this.listaObjs.length) {
            // Crio um array novo e maior
            Object[]  novoArray = new Object[this.listaObjs.length + FATOR_CRESCIMENTO];
            // Copio os objetos do array antigo para novo
            for(int i = 0; i < this.listaObjs.length; i++)
                novoArray[i] = this.listaObjs[i];
            // Passo a usar o novo array
            this.listaObjs = novoArray;
        }
        // Adiciono o novo à listaObjs
        this.listaObjs[ this.numElementos++ ] = novo;
    }

    /**
     * Informa o número de elementos da lista
     * @return
     */
    public int getNumElementos() {
        return this.numElementos;
    }

    /**
     * Retorna uma copia da lista de elementos
     * @return
     */
    public Object[] obterElementos() {
        Object[] copia = new Object[this.numElementos];
        for(int i = 0; i < this.numElementos; i++)
            copia[i] = this.listaObjs[i];
        return copia;
    }

    /**
     * Informa o elemento da posição informada
     * @param pos
     * @return
     */
    public Object elementoPos(int pos) throws ArrayIndexOutOfBoundsException {
        if(pos < this.numElementos)
            return this.listaObjs[pos];
        throw new ArrayIndexOutOfBoundsException(pos);
    }

    /**
     * Retorna a posição do elemento informado
     * @param elem
     * @return
     */
    public int posicaoElemento(Object elem) {
        int pos = NAO_ACHEI ;
        for(int i = 0; i < this.numElementos; i++) {
            if(this.listaObjs[i] == elem) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    /**
     * Exclui um elemento da lista
     * @param elem
     * @return
     */
    public boolean excluir(Object elem) {
        int pos = this.posicaoElemento(elem);
        if(pos == NAO_ACHEI)
            return false;
        // tirando o obj da lista e não deixando um 'buraco' no array
        for(int i = pos; i < this.numElementos - 1; i++) {
            this.listaObjs[i] = this.listaObjs[i+1];
        }
        this.listaObjs[numElementos - 1] = null;
        this.numElementos--;
        return true;
    }
}
