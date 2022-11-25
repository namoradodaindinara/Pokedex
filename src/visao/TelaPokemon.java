package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class TelaPokemon extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamePokemon;
	private JTextField txtPeso;
	private JTextField txtAltura;


	/**
	 * Create the frame.
	 */
	public TelaPokemon() {
		initialize();
		
		
	}
	
	private void initialize() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastre seu Pokemon");
		lblNewLabel.setBounds(147, 11, 128, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pokémon:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(20, 62, 100, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(90, 156, 30, 14);
		contentPane.add(lblNewLabel_2);
		
		txtNamePokemon = new JTextField();
		txtNamePokemon.setBounds(127, 59, 86, 20);
		contentPane.add(txtNamePokemon);
		txtNamePokemon.setColumns(10);
		
		JButton btnCadPokemon = new JButton("Cadastrar");
		btnCadPokemon.setBounds(297, 74, 89, 23);
		contentPane.add(btnCadPokemon);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setBounds(126, 183, 86, 22);
		contentPane.add(comboBox);
		
		JComboBox<String> comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(127, 152, 86, 22);
		contentPane.add(comboBoxTipo);
		
		String[] tipos = { "", "Fogo", "Planta", "Água" };
		
		String[] regiao = { "", "Kanto (KA)", "Johto (JO)", "Hoenn (HO)", "Sinnoh (SI)", "Unova (UN)", "Kalos (KL)", "Alola (AL)" };

		for (int i = 0; i < tipos.length; i++) {
			comboBoxTipo.addItem(tipos[i]);
		}
		
		for (int i = 0; i < regiao.length; i++) {
			comboBox.addItem(regiao[i]);
		}
		
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
		
		txtPeso = new JTextField();
		txtPeso.setBounds(127, 90, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Peso:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(20, 93, 100, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(127, 121, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(20, 124, 100, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Região:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(33, 187, 86, 14);
		contentPane.add(lblNewLabel_2_1);
		
		
	}
}
