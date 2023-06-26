package viewer;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
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

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setBounds(53, 130, 117, 48);
		contentPane.add(btnCliente);
		btnCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		JButton btnBarbe = new JButton("Barbeiro");
		btnBarbe.setBounds(255, 130, 117, 48);
		contentPane.add(btnBarbe);

		JButton btnSalvarJP = new JButton("Salvar");
		btnSalvarJP.setBounds(304, 226, 117, 29);
		contentPane.add(btnSalvarJP);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
}
