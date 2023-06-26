package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class JanelaAgendamento extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaAgendamento frame = new JanelaAgendamento();
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
	public JanelaAgendamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(10, 33, 46, 14);
		contentPane.add(lblCliente);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 29, 141, 22);
		contentPane.add(comboBox);

		JLabel lblBarbeiro = new JLabel("Barbeiro");
		lblBarbeiro.setBounds(10, 80, 46, 14);
		contentPane.add(lblBarbeiro);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 76, 141, 22);
		contentPane.add(comboBox_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(66, 129, 141, 22);
		contentPane.add(comboBox_1_1);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 133, 46, 14);
		contentPane.add(lblData);

		JLabel lblHora = new JLabel("Horário");
		lblHora.setBounds(10, 178, 46, 14);
		contentPane.add(lblHora);

		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setBounds(66, 174, 141, 22);
		contentPane.add(comboBox_1_1_1);
	}
}
