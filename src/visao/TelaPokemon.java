package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.PokemonController;
import modelo.Pokemon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class TelaPokemon extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamePokemon;
	private JTextField txtPeso;
	private JTextField txtAltura;
	String text = "";
	String select = "";
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public TelaPokemon() {
		initialize();

	}

	private void initialize() {
		PokemonController instance = PokemonController.getInstancia();
		ArrayList<Pokemon> arrayPokemon = instance.listaPokemon();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastre seu Pokémon");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(160, 8, 203, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pokémon:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 76, 100, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(70, 170, 30, 14);
		contentPane.add(lblNewLabel_2);

		txtNamePokemon = new JTextField();
		txtNamePokemon.setBounds(107, 73, 139, 20);
		contentPane.add(txtNamePokemon);
		txtNamePokemon.setColumns(10);

		JComboBox<String> comboBoxRegiao = new JComboBox();
		comboBoxRegiao.setBounds(106, 197, 140, 22);
		contentPane.add(comboBoxRegiao);

		JComboBox<String> comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(107, 166, 139, 22);
		contentPane.add(comboBoxTipo);

		String[] tipos = { "Selecione o tipo", "Água", "Dragão", "Elétrico", "Fada", "Fantasma", "Ferro", "Fogo",
				"Gelo", "Grama", "Inseto", "Lutador", "Normal", "Pedra", "Psiquíco", "Terra", "Veneno", "Voador" };

		String[] regiao = { "Selecione a região", "Kanto (KA)", "Johto (JO)", "Hoenn (HO)", "Sinnoh (SI)", "Unova (UN)",
				"Kalos (KL)", "Alola (AL)" };

		for (int i = 0; i < tipos.length; i++) {
			comboBoxTipo.addItem(tipos[i]);
		}

		for (int i = 0; i < regiao.length; i++) {
			comboBoxRegiao.addItem(regiao[i]);
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
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBounds(10, 18, 41, 23);
		contentPane.add(btnBack);

		txtPeso = new JTextField();
		txtPeso.setBounds(107, 104, 139, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 256, 570, 128);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Pokémon");
		model.addColumn("Peso");
		model.addColumn("Altura");
		model.addColumn("Tipo");
		model.addColumn("Região");
		
		JLabel lblNewLabel_1_1 = new JLabel("Peso:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(0, 107, 100, 14);
		contentPane.add(lblNewLabel_1_1);

		
		txtAltura = new JTextField();
		txtAltura.setBounds(107, 135, 139, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(0, 138, 100, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Região:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(13, 201, 86, 14);
		contentPane.add(lblNewLabel_2_1);

		JButton btnCadPokemon = new JButton("Cadastrar");
		btnCadPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p = new Pokemon();

				PokemonController pc = new PokemonController();

				if (txtNamePokemon.getText().isEmpty() || txtNamePokemon.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Pokemon");
				} else if (txtPeso.getText().isEmpty() || txtAltura.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Peso");
				} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Altura");
				} else if (txtPeso.getText().isEmpty() || txtPeso.getText() == null) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Peso");
				} else if (comboBoxTipo.getSelectedItem().equals("Selecione o tipo")) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Tipo");
				} else if (comboBoxRegiao.getSelectedItem().equals("Selecione a região")) {
					JOptionPane.showMessageDialog(null, "Campo obrigatório: Região");
				} else {

					p.setNome(txtNamePokemon.getText().toString());
					p.setPeso(Double.valueOf(txtPeso.getText()));
					p.setAltura(Double.valueOf(txtAltura.getText()));
					p.setTipo(comboBoxTipo.getSelectedItem().toString());
					p.setRegiao(comboBoxRegiao.getSelectedItem().toString());

					PokemonController controller = PokemonController.getInstancia();
					boolean inserir = controller.inserir(p);

					for (Pokemon p1 : arrayPokemon) {
						Object[] pok = new Object[5];
						pok[0] = p1.getNome();
						pok[1] = p1.getPeso();
						pok[2] = p1.getAltura();
						pok[3] = p1.getTipo();
						pok[4] = p1.getRegiao();
						
						model.addRow(pok);
					}
					
					

				}

			}

		});

		btnCadPokemon.setBounds(271, 72, 187, 39);
		contentPane.add(btnCadPokemon);

	}
}
