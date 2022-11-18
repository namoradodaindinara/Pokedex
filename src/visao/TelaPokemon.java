package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPokemon extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the frame.
	 */
	public TelaPokemon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastre seu Pokemon");
		lblNewLabel.setBounds(147, 11, 128, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome do Pokemon");
		lblNewLabel_1.setBounds(67, 62, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(276, 62, 30, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(71, 87, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(250, 87, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnCadPokemon = new JButton("Cadastrar");
		btnCadPokemon.setBounds(157, 166, 89, 23);
		contentPane.add(btnCadPokemon);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolherTipoCadastro telacadastro = new TelaEscolherTipoCadastro();
				telacadastro.setLocationRelativeTo(null);
				telacadastro.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(0, 0, 205));
		btnBack.setBounds(10, 18, 41, 23);
		contentPane.add(btnBack);
	}
}
