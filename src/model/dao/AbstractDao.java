package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Aluno;
import model.Curso;
import model.ModelException;
import model.Pessoa;

abstract public class AbstractDao {

	public static boolean objetosRecuperados = false;

	/**
	 * Realiza a persistência dos objetos através da estratégia de serialização
	 */
	final public void commit() {
		try {
			FileOutputStream arquivo = new FileOutputStream("C:/Temp/Objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);
			// instanciamos um dao para cada classe para pegar a lista de objetos deles
			// e promover a serialização.
			DaoPessoa daoPessoa = new DaoPessoa();
			oos.writeObject( daoPessoa.consultarTodos() );

			DaoAluno daoAluno = new DaoAluno();
			oos.writeObject( daoAluno.consultarTodos() );

			DaoCurso daoCurso = new DaoCurso();
			oos.writeObject( daoCurso.consultarTodos() );

			oos.close();
		}
		catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		}
	}

	/**
	 * Realiza a recuperação dos objetos persistidos através da estratégia de serialização
	 */
	public static void recuperarObjetos() {
		if(AbstractDao.objetosRecuperados)
			return;
		try {
			FileInputStream arquivo = new FileInputStream("C:/Temp/Objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);
			// instanciamos um dao para cada classe para determinar a lista de objetos
			// que eles irão gerenciar a partir da serialização.
			DaoPessoa daoPessoa = new DaoPessoa();
			daoPessoa.incluirTodos( (Pessoa[]) ois.readObject() );

			DaoAluno daoAluno = new DaoAluno();
			daoAluno.incluirTodos( (Aluno[]) ois.readObject() );

			DaoCurso daoCurso = new DaoCurso();
			Object obj = ois.readObject();
			daoCurso.incluirTodos(  (Curso[])obj );

			ois.close();
			AbstractDao.objetosRecuperados = true;
		}
		catch (ModelException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Deu Ruim: " + e.getMessage());
		}
	}

	/**
	 * O método 'incluirTodos' (antes chamava-se 'setLista') é o método que
	 * determinará os objetos que estarão presentes na lista dos DAOs.
	 * Definimos como 'abstract' para garantir que as especializações de Dao
	 * vão implementar o método incluir.
	 * @param novo
	 */
	abstract public void incluirTodos(Object[] lista) throws ModelException;

	/**
	 * O método 'incluir' é o método que fará a persistência do objeto passado.
	 * Definimos como 'abstract' para garantir que as especializações de Dao
	 * vão implementar o método incluir.
	 * @param novo
	 */
	abstract public void incluir(Object novo) throws ModelException;

	/**
	 * O método 'alterar' é o método que fará a alteração e persistência do objeto passado.
	 * Definimos como 'abstract' para garantir que as especializações de Dao
	 * vão implementar o método alterar.
	 * @param novo
	 */
	abstract public void alterar(Object obj) throws ModelException;

	/**
	 * O método 'excluir' é o método que fará a remoção do objeto passado.
	 * Definimos como 'abstract' para garantir que as especializações de Dao
	 * vão implementar o método excluir.
	 * @param novo
	 */
	abstract public void excluir(Object obj) throws ModelException;

	/**
	 * O método 'consultarTodos' é o método que devolverá todos os objetos vinculados ao Dao.
	 * Definimos como 'abstract' para garantir que as especializações de Dao
	 * vão implementar o método consultarTodos.
	 * @param novo
	 */
	abstract public Object[] consultarTodos() throws ModelException;
}
