package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class TelaTreinador extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public TelaTreinador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastre o Treinador");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(137, 13, 180, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 73, 41, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("CPF");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 131, 41, 14);
		contentPane.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(55, 71, 131, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(55, 129, 131, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton btnCadTreinador = new JButton("Cadastrar");
		btnCadTreinador.setBackground(Color.WHITE);
		btnCadTreinador.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadTreinador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textField.getText().isEmpty() || textField.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Nome");
				} else if (textField_1.getText().isEmpty() || textField_1.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: CPF");
				}
			}
		});
		btnCadTreinador.setBounds(137, 214, 145, 23);
		contentPane.add(btnCadTreinador);

		JButton btnBack = new JButton("<");
		btnBack.setForeground(new Color(0, 0, 205));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolherTipoCadastro telacadastro = new TelaEscolherTipoCadastro();
				telacadastro.setLocationRelativeTo(null);
				telacadastro.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 11, 41, 23);
		contentPane.add(btnBack);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(218, 69, 206, 133);
		contentPane.add(textArea);
	}
}
