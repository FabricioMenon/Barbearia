package viewer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Barbeiro;
import model.Cliente;
import model.ModelException;

public class JanelaBarbeiro extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomeBar;
	private JTextField tfCpfBar;
	private JLabel lblCpf;

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
		setTitle("Barbeiro");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(25, 17, 110, 16);
		contentPane.add(lblNewLabel);


		tfNomeBar = new JTextField();
		tfNomeBar.setForeground(Color.GRAY);
		tfNomeBar.setText("Digite o nome aqui");

		tfNomeBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfNomeBar.getText().equals("Digite o nome aqui")) {
					tfNomeBar.setText("");
					tfNomeBar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfNomeBar.getText().isEmpty()) {
					tfNomeBar.setForeground(Color.GRAY);
					tfNomeBar.setText("Digite o nome aqui");
				}
			}
		});

		tfNomeBar.setBounds(145, 12, 130, 26);
		contentPane.add(tfNomeBar);
		tfNomeBar.setColumns(10);

		tfNomeBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!isVisible())
					return;
				tfNomeBar.setBackground(Color.WHITE);
				String nomeBar = tfNomeBar.getText();
				if (nomeBar.equals("Digite o nome aqui"))
					return;
				try {
					Barbeiro.validarNome(nomeBar);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(lblNewLabel, "Erro: " + e1);
					tfNomeBar.requestFocus();
				}
			}
		});


		tfCpfBar = new JTextField();
		tfCpfBar.setForeground(Color.GRAY);
		tfCpfBar.setText("Digite o cpf aqui");

		tfCpfBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfCpfBar.getText().equals("Digite o cpf aqui")) {
					tfCpfBar.setText("");
					tfCpfBar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfCpfBar.getText().isEmpty()) {
					tfCpfBar.setForeground(Color.GRAY);
					tfCpfBar.setText("Digite o cpf aqui");
				}
			}
		});

		tfCpfBar.setBounds(10, 54, 130, 26);
		contentPane.add(tfCpfBar);
		tfCpfBar.setColumns(10);

		tfCpfBar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!isVisible())
					return;
				tfCpfBar.setBackground(Color.WHITE);
				String cpfBar = tfCpfBar.getText();
				if (cpfBar.equals("Digite o cpf aqui"))
					return;
				try {
					Barbeiro.validarCpf(cpfBar);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(lblNewLabel, "Erro: " + e1);
					tfCpfBar.requestFocus();
				}
			}
		});



		tfCpfBar.setBounds(144, 53, 130, 26);
		contentPane.add(tfCpfBar);

		JButton btnCancelar = new JButton("Cancelar ");
		btnCancelar.setBounds(25, 126, 117, 29);
		contentPane.add(btnCancelar);

		JButton btnNewButton_1 = new JButton("Salvar ");
		btnNewButton_1.setBounds(147, 126, 117, 29);
		contentPane.add(btnNewButton_1);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(25, 59, 110, 16);
		contentPane.add(lblCpf);
	}
}
