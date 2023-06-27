package controller;

import controller.aluno.CtrlManterCadastroDeAlunos;
import model.dao.AbstractDao;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends AbstractCtrl {

    //----------------------------------------------------------------------//

    public CtrlPrograma() {
        super(null);
    }

    //----------------------------------------------------------------------//

    public void iniciar() {
        AbstractDao.recuperarObjetos();
        // Abro a janela principal
        JanelaPrincipal janela = new JanelaPrincipal(this);
        janela.setVisible(true);
    }

    //----------------------------------------------------------------------//

    public void encerrar() {
        System.exit(0);
    }

    //----------------------------------------------------------------------//

    public void iniciarIncluirPessoa() {
        new CtrlIncluirPessoa(this);
    }

    //----------------------------------------------------------------------//

    public void iniciarManterCadastroDeAlunos() {
        new CtrlManterCadastroDeAlunos(this);
    }

    //----------------------------------------------------------------------//

    public void iniciarIncluirCurso() {
        new CtrlIncluirCurso(this);
    }

    //----------------------------------------------------------------------//

    public static void main(String[] args) {
        new CtrlPrograma();
    }

    //----------------------------------------------------------------------//
}

