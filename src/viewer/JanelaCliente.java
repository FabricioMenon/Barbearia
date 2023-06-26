package viewer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JanelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tftel;
	private JTextField tfCpf;
	
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
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(18, 19, 61, 16);
		contentPane.add(lblNewLabel);
		
		tfNome = new JTextField();
		tfNome.setBounds(92, 15, 130, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone :");
		lblNewLabel_1.setBounds(18, 73, 72, 16);
		contentPane.add(lblNewLabel_1);
		
		tftel = new JTextField();
		tftel.setForeground(new Color(220, 220, 220));
		tftel.setText("(xx) xxxxx-xxxx");
		tftel.setBounds(93, 69, 130, 26);
		contentPane.add(tftel);
		tftel.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Idade:");
		lblNewLabel_2.setBounds(21, 99, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setBounds(18, 47, 61, 16);
		contentPane.add(lblNewLabel_3);
		 
		tfCpf= new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(92, 43, 130, 26);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JComboBox<String> comboBox = extracted();
		comboBox.setMaximumRowCount(100);
		comboBox.setBounds(87, 95, 64, 26);
		contentPane.add(comboBox);
		
		
		comboBox.addItem("4");
		comboBox.addItem("5");
		comboBox.addItem("100");
	
		
		JButton btnCancelarcli = new JButton("Cancelar");
		btnCancelarcli.setBounds(18, 158, 117, 29);
		contentPane.add(btnCancelarcli);
		
		JButton btnSalvarcli = new JButton("Salvar");
		btnSalvarcli.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {}
		 	@SuppressWarnings("unused")
			String nome = tfNome.getText();
			@SuppressWarnings("unused")
			String cpf = tfCpf.getText();
			@SuppressWarnings("unused")
			String telefone = tftel.getText();
								
		});
		btnSalvarcli.setBounds(145, 158, 117, 29);
		contentPane.add(btnSalvarcli);
			
}

	private JComboBox<String> extracted() {
		return new JComboBox<String>();
	}
}
