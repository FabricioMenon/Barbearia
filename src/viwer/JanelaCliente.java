package viwer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JanelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeClliente;
	private JTextField txtxxXxxxxxxxx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaCliente frame = new JanelaCliente();
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
	public JanelaCliente() {
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(18, 19, 61, 16);
		contentPane.add(lblNewLabel);
		
		tfNomeClliente = new JTextField();
		tfNomeClliente.setBounds(80, 14, 130, 26);
		contentPane.add(tfNomeClliente);
		tfNomeClliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone ");
		lblNewLabel_1.setBounds(18, 47, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtxxXxxxxxxxx = new JTextField();
		txtxxXxxxxxxxx.setForeground(new Color(220, 220, 220));
		txtxxXxxxxxxxx.setText("(xx) xxxxx-xxxx");
		txtxxXxxxxxxxx.setBounds(80, 42, 130, 26);
		contentPane.add(txtxxXxxxxxxxx);
		txtxxXxxxxxxxx.setColumns(10);
		
		JButton btnCancelarcli = new JButton("Cancelar");
		btnCancelarcli.setBounds(18, 158, 117, 29);
		contentPane.add(btnCancelarcli);
		
		JButton btnSalvarcli = new JButton("Salvar");
		btnSalvarcli.setBounds(145, 158, 117, 29);
		contentPane.add(btnSalvarcli);
		
		JLabel lblNewLabel_2 = new JLabel("Idade");
		lblNewLabel_2.setBounds(18, 75, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(100);
		comboBox.setBounds(80, 71, 55, 26);
		contentPane.add(comboBox);
	}
}
