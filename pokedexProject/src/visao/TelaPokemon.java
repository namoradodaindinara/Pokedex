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
		setBounds(100, 100, 528, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO POK\u00C9MON");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(156, 8, 203, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pokémon:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-11, 68, 100, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(59, 162, 30, 14);
		contentPane.add(lblNewLabel_2);

		txtNamePokemon = new JTextField();
		txtNamePokemon.setBounds(96, 65, 139, 20);
		contentPane.add(txtNamePokemon);
		txtNamePokemon.setColumns(10);

		JComboBox<String> comboBoxRegiao = new JComboBox();
		comboBoxRegiao.setBounds(96, 189, 139, 22);
		contentPane.add(comboBoxRegiao);

		JComboBox<String> comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(96, 158, 139, 22);
		contentPane.add(comboBoxTipo);

		String[] tipos = { "Selecione o tipo", "Água", "Dragão", "Elétrico", "Fada", "Fantasma", "Ferro", "Fogo",
				"Gelo", "Grama", "Inseto", "Lutador", "Normal", "Pedra", "Planta", "Psiquíco", "Terra", "Veneno",
				"Voador" };

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
		txtPeso.setBounds(96, 96, 139, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 245, 407, 128);
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
		lblNewLabel_1_1.setBounds(-11, 99, 100, 14);
		contentPane.add(lblNewLabel_1_1);

		txtAltura = new JTextField();
		txtAltura.setBounds(96, 127, 139, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(-11, 130, 100, 14);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Região:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(2, 193, 86, 14);
		contentPane.add(lblNewLabel_2_1);

		JButton btnCadPokemon = new JButton("Cadastrar pok\u00E9mon");
		btnCadPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p = new Pokemon();

				try {
					Double.parseDouble(txtPeso.getText());
					try {
						Double.parseDouble(txtAltura.getText());
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

							for (int i = 0; i < arrayPokemon.size(); i++) {
								text += arrayPokemon.get(i).getNome();
							}

							if (!text.contains(txtNamePokemon.getText())) {
								model.getDataVector().removeAllElements();
								p.setNome(txtNamePokemon.getText().toString());
								p.setPeso(Double.valueOf(txtPeso.getText()));
								p.setAltura(Double.valueOf(txtAltura.getText()));
								p.setTipo(comboBoxTipo.getSelectedItem().toString());
								p.setRegiao(comboBoxRegiao.getSelectedItem().toString());

								boolean inserir = instance.inserir(p);

								JOptionPane.showMessageDialog(null, "Pokémon cadastrado com sucesso!");

								for (Pokemon p1 : arrayPokemon) {
									Object[] pok = new Object[5];
									pok[0] = p1.getNome();
									pok[1] = p1.getPeso();
									pok[2] = p1.getAltura();
									pok[3] = p1.getTipo();
									pok[4] = p1.getRegiao();

									model.addRow(pok);
								}

							} else {
								JOptionPane.showMessageDialog(null, "Esse pokémon já foi adicionado na pokédex!");
							}

						}

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro em campo: Altura. Você deve digitar um valor numérico nesse campo.");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Erro em campo: Peso. Você deve digitar um valor numérico nesse campo.");
				}

			}

		});

		btnCadPokemon.setBounds(264, 59, 187, 46);
		contentPane.add(btnCadPokemon);

		JButton btnMostrar = new JButton("Mostrar cadastros");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!arrayPokemon.isEmpty()) {
					model.getDataVector().removeAllElements();
					for (Pokemon p1 : arrayPokemon) {
						Object[] pok = new Object[5];
						pok[0] = p1.getNome();
						pok[1] = p1.getPeso();
						pok[2] = p1.getAltura();
						pok[3] = p1.getTipo();
						pok[4] = p1.getRegiao();

						model.addRow(pok);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum pokémon cadastrado.");
				}

			}
		});
		btnMostrar.setBounds(265, 109, 187, 49);
		contentPane.add(btnMostrar);

		JButton btnDeletar = new JButton("Deletar cadastro");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p = new Pokemon();
				if (table.getSelectedRow() >= 0) {
					if (table.getSelectedColumn() == 0) {
						instance.deletar(p,
								String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())));
						model.removeRow(table.getSelectedRow());
						table.setModel(model);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma célula da coluna 'Pokémon'.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar.");
				}
			}
		});
		btnDeletar.setBounds(265, 162, 187, 49);
		contentPane.add(btnDeletar);

	}
}