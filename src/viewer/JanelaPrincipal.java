package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setTitle("Janela Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgenda = new JButton("Agendamento");
		btnAgenda.setBounds(53, 30, 117, 55);
		contentPane.add(btnAgenda);
		
		JButton btnAtend = new JButton("Atendimento");
		btnAtend.setBounds(255, 30, 117, 55);
		contentPane.add(btnAtend);
		
		JButton btnNewButton_2 = new JButton("Cliente");
		btnNewButton_2.setBounds(53, 130, 117, 48);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Barbeiro");
		btnNewButton_3.setBounds(255, 130, 117, 48);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(304, 226, 117, 29);
		contentPane.add(btnNewButton);
	}
}
