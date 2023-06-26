package viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.ModelException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaBarbeiro extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeBar;
	private JTextField tfCpfBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaBarbeiro frame = new JanelaBarbeiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaBarbeiro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome Barbeiro");
		lblNewLabel.setBounds(25, 17, 110, 16);
		contentPane.add(lblNewLabel);

		tfNomeBar = new JTextField();
		tfNomeBar.setBounds(147, 12, 130, 26);
		contentPane.add(tfNomeBar);
		tfNomeBar.setColumns(10);

		JLabel lblCpfBarbeiro = new JLabel("Cpf Barbeiro");
		lblCpfBarbeiro.setBounds(25, 58, 110, 16);
		contentPane.add(lblCpfBarbeiro);

		tfCpfBar = new JTextField();
		tfCpfBar.setColumns(10);
		tfCpfBar.addFocusListener((FocusListener) new FocusListener() {
			public void focusLost1(final FocusEvent e) throws ModelException {
				if (!isVisible())
					return;
				tfCpfBar.setBackground(Color.WHITE);
				String cpf = tfCpfBar.getText();
				if (cpf.equals("Digite o cpf aqui"))
					return;
				Cliente.validarCpf(cpf);
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		tfCpfBar.setBounds(147, 53, 130, 26);
		contentPane.add(tfCpfBar);

		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.setBounds(25, 126, 117, 29);
		contentPane.add(btnCancelar);

		JButton btnNewButton_1 = new JButton("Salvar ");
		btnNewButton_1.setBounds(147, 126, 117, 29);
		contentPane.add(btnNewButton_1);
	}
}
