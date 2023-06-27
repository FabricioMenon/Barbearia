package viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JanelaAtendimento extends JFrame {

    private JPanel contentPane;
    private JTextField tfValor;
    private JTextField tfData;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JanelaAtendimento frame = new JanelaAtendimento();
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
    public JanelaAtendimento() {
        setTitle("Atendimento ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 311, 300);
        contentPane = new JPanel();
        contentPane.setToolTipText("");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cliente");
        lblNewLabel.setBounds(45, 37, 61, 16);
        contentPane.add(lblNewLabel);

        JComboBox comboBoxAtCli = new JComboBox();
        comboBoxAtCli.setBounds(118, 33, 147, 27);
        contentPane.add(comboBoxAtCli);

        JLabel lblBarbeiro = new JLabel("Barbeiro");
        lblBarbeiro.setBounds(45, 76, 61, 16);
        contentPane.add(lblBarbeiro);

        JComboBox comboBoxAtBar = new JComboBox();
        comboBoxAtBar.setBounds(118, 72, 147, 27);
        contentPane.add(comboBoxAtBar);

        JLabel lblNewLabel_1 = new JLabel("Valor:");
        lblNewLabel_1.setBounds(45, 116, 61, 16);
        contentPane.add(lblNewLabel_1);

        tfValor = new JTextField();
        tfValor.setText("R$:");
        tfValor.setToolTipText("R$");
        tfValor.setBounds(118, 111, 76, 26);
        contentPane.add(tfValor);
        tfValor.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Data");
        lblNewLabel_2.setBounds(45, 154, 61, 16);
        contentPane.add(lblNewLabel_2);

        tfData = new JTextField();
        tfData.setText("XX/XX/XX");
        tfData.setBounds(118, 149, 76, 26);
        contentPane.add(tfData);
        tfData.setColumns(10);

        JButton btCancelar = new JButton("Cancelar ");
        btCancelar.setBounds(18, 218, 117, 29);
        contentPane.add(btCancelar);

        JButton btSalvar = new JButton("Salvar");
        btSalvar.setBounds(165, 218, 117, 29);
        contentPane.add(btSalvar);
    }
}
