package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.PokemonController;
import modelo.Pokemon;

public class TelaPokemon extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamePokemon;
	private JTextField txtPeso;
	private JTextField txtAltura;
	String text = "";
	private JTable tablePokemons;
	private DefaultTableModel model;
	private Pokemon pokemonAEditar;

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
		setBounds(100, 100, 598, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CADASTRO POK\u00C9MON");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(190, 23, 203, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pok�mon:");
		lblNewLabel_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(25, 114, 100, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(95, 208, 30, 14);
		contentPane.add(lblNewLabel_2);

		txtNamePokemon = new JTextField();
		txtNamePokemon.setBounds(132, 111, 139, 20);
		contentPane.add(txtNamePokemon);
		txtNamePokemon.setColumns(10);

		JComboBox<String> comboBoxRegiao = new JComboBox();
		comboBoxRegiao.setBounds(132, 235, 139, 22);
		contentPane.add(comboBoxRegiao);

		JComboBox<String> comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(132, 204, 139, 22);
		contentPane.add(comboBoxTipo);

		String[] tipos = { "Selecione o tipo", "�gua", "Drag�o", "El�trico", "Fada", "Fantasma", "Ferro", "Fogo",
				"Gelo", "Grama", "Inseto", "Lutador", "Normal", "Pedra", "Planta", "Psiqu�co", "Terra", "Veneno",
				"Voador" };

		String[] regiao = { "Selecione a regi�o", "Kanto (KA)", "Johto (JO)", "Hoenn (HO)", "Sinnoh (SI)", "Unova (UN)",
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
		btnBack.setBounds(12, 12, 41, 23);
		contentPane.add(btnBack);

		txtPeso = new JTextField();
		txtPeso.setBounds(132, 142, 139, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 294, 473, 128);
		contentPane.add(scrollPane);

		tablePokemons = new JTable();
//		tablePokemons.setRowSelectionAllowed(false);
//		tablePokemons.setShowGrid(false);
//		tablePokemons.setShowHorizontalLines(false);
//		tablePokemons.setShowVerticalLines(false);
//		tablePokemons.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(tablePokemons);

		model = new DefaultTableModel();
		tablePokemons.setModel(model);
		model.addColumn("ID");
		model.addColumn("Pok�mon");
		model.addColumn("Peso");
		model.addColumn("Altura");
		model.addColumn("Tipo");
		model.addColumn("Regi�o");

		JLabel lblNewLabel_1_1 = new JLabel("Peso:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(25, 145, 100, 14);
		contentPane.add(lblNewLabel_1_1);

		txtAltura = new JTextField();
		txtAltura.setBounds(132, 173, 139, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(25, 176, 100, 14);
		contentPane.add(lblNewLabel_1_1_1);

		for (Pokemon p1 : arrayPokemon) {
			Object[] pok = new Object[6];
			pok[0] = p1.getId();
			pok[1] = p1.getNome();
			pok[2] = p1.getPeso();
			pok[3] = p1.getAltura();
			pok[4] = p1.getTipo();
			pok[5] = p1.getRegiao();

			model.addRow(pok);
		}

		JLabel lblNewLabel_2_1 = new JLabel("Regi�o:");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 0));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setBounds(38, 239, 86, 14);
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
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Pokemon");
						} else if (txtPeso.getText().isEmpty() || txtAltura.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Peso");
						} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Altura");
						} else if (txtPeso.getText().isEmpty() || txtPeso.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Peso");
						} else if (comboBoxTipo.getSelectedItem().equals("Selecione o tipo")) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Tipo");
						} else if (comboBoxRegiao.getSelectedItem().equals("Selecione a regi�o")) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Regi�o");
						} else {

							for (int i = 0; i < arrayPokemon.size(); i++) {
								text += arrayPokemon.get(i).getNome();
							}

							if (!text.contains(txtNamePokemon.getText())) {
								model.getDataVector().removeAllElements();
								p.setId(arrayPokemon.size() + 1);
								p.setNome(txtNamePokemon.getText().toString());
								p.setPeso(Double.valueOf(txtPeso.getText()));
								p.setAltura(Double.valueOf(txtAltura.getText()));
								p.setTipo(comboBoxTipo.getSelectedItem().toString());
								p.setRegiao(comboBoxRegiao.getSelectedItem().toString());

								boolean inserir = instance.inserir(p);

								JOptionPane.showMessageDialog(null, "Pok�mon cadastrado com sucesso!");

								for (Pokemon p1 : arrayPokemon) {
									Object[] pok = new Object[6];
									pok[0] = p1.getId();
									pok[1] = p1.getNome();
									pok[2] = p1.getPeso();
									pok[3] = p1.getAltura();
									pok[4] = p1.getTipo();
									pok[5] = p1.getRegiao();

									model.addRow(pok);
								}

								txtNamePokemon.setText("");
								txtPeso.setText("");
								txtAltura.setText("");
								comboBoxTipo.setSelectedIndex(0);
								comboBoxRegiao.setSelectedIndex(0);

							} else {
								JOptionPane.showMessageDialog(null, "Esse pok�mon j� foi adicionado na pok�dex!");
							}

						}

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro em campo: Altura. Voc� deve digitar um valor num�rico nesse campo.");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,
							"Erro em campo: Peso. Voc� deve digitar um valor num�rico nesse campo.");
				}

			}

		});

		btnCadPokemon.setBounds(300, 95, 187, 46);
		contentPane.add(btnCadPokemon);

		JButton btnDeletar = new JButton("Deletar cadastro");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pokemon p = new Pokemon();
				if (tablePokemons.getSelectedRow() >= 0) {
					
						instance.deletar(p, String.valueOf(tablePokemons.getValueAt(tablePokemons.getSelectedRow(),
								tablePokemons.getSelectedColumn())));
						model.removeRow(tablePokemons.getSelectedRow());
						tablePokemons.setModel(model);

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar.");
				}
			}
		});
		btnDeletar.setBounds(300, 153, 187, 49);
		contentPane.add(btnDeletar);

		JButton btnSalvar = new JButton("Salvar");
		JButton btnVoltaSalva = new JButton("<- Voltar");

		JButton btnAlt = new JButton("Alterar");
		btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tablePokemons.getSelectedRow() >= 0) {
					btnDeletar.setVisible(false);
					btnAlt.setVisible(false);
					btnCadPokemon.setVisible(false);
					btnSalvar.setVisible(true);
					btnVoltaSalva.setVisible(true);

					int linha = tablePokemons.getSelectedRow();
					Integer idPokemon = (Integer) tablePokemons.getValueAt(linha, 0);
					pokemonAEditar = instance.buscarPokemonPorId(idPokemon);

					txtNamePokemon.setText(pokemonAEditar.getNome());
					txtPeso.setText(String.valueOf(pokemonAEditar.getPeso()));
					txtAltura.setText(String.valueOf(pokemonAEditar.getAltura()));
					comboBoxTipo.setSelectedItem(pokemonAEditar.getTipo());
					comboBoxRegiao.setSelectedItem(pokemonAEditar.getRegiao());

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para alterar.");
				}

			}
		});
		btnAlt.setBounds(300, 217, 187, 46);
		contentPane.add(btnAlt);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valida = instance.alterar(pokemonAEditar, pokemonAEditar.getId());
				if (valida) {
					try {
						Double.parseDouble(txtPeso.getText());
						try {
							Double.parseDouble(txtAltura.getText());
							if (txtNamePokemon.getText().isEmpty() || txtNamePokemon.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Pokemon");
							} else if (txtPeso.getText().isEmpty() || txtAltura.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Peso");
							} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Altura");
							} else if (txtPeso.getText().isEmpty() || txtPeso.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Peso");
							} else if (comboBoxTipo.getSelectedItem().equals("Selecione o tipo")) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Tipo");
							} else if (comboBoxRegiao.getSelectedItem().equals("Selecione a regi�o")) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Regi�o");
							} else {

								JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

								model.getDataVector().removeAllElements();

								pokemonAEditar.setId(pokemonAEditar.getId());
								pokemonAEditar.setNome(txtNamePokemon.getText());
								pokemonAEditar.setPeso(Double.valueOf(txtPeso.getText()));
								pokemonAEditar.setAltura(Double.valueOf(txtAltura.getText()));
								pokemonAEditar.setTipo(comboBoxTipo.getSelectedItem().toString());
								pokemonAEditar.setRegiao(comboBoxRegiao.getSelectedItem().toString());

								for (Pokemon p1 : arrayPokemon) {
									Object[] pok = new Object[6];
									pok[0] = p1.getId();
									pok[1] = p1.getNome();
									pok[2] = p1.getPeso();
									pok[3] = p1.getAltura();
									pok[4] = p1.getTipo();
									pok[5] = p1.getRegiao();

									model.addRow(pok);
								}

								btnSalvar.setVisible(false);
								btnDeletar.setVisible(true);
								btnAlt.setVisible(true);
								btnCadPokemon.setVisible(true);
								txtNamePokemon.setText("");
								txtPeso.setText("");
								txtAltura.setText("");
								comboBoxTipo.setSelectedIndex(0);
								comboBoxRegiao.setSelectedIndex(0);

								txtNamePokemon.setText("");
								txtPeso.setText("");
								txtAltura.setText("");
								comboBoxTipo.setSelectedIndex(0);
								comboBoxRegiao.setSelectedIndex(0);

							}

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,
									"Erro em campo: Altura. Voc� deve digitar um valor num�rico nesse campo.");
						}
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null,
								"Erro em campo: Peso. Voc� deve digitar um valor num�rico nesse campo.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar.");
				}
			}
		});

		btnSalvar.setVisible(false);
		btnSalvar.setBounds(300, 142, 187, 55);
		contentPane.add(btnSalvar);
		
		
		btnVoltaSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltaSalva.setVisible(false);
				btnSalvar.setVisible(false);
				btnCadPokemon.setVisible(true);
				btnAlt.setVisible(true);
				btnDeletar.setVisible(true);
				
				txtNamePokemon.setText("");
				txtPeso.setText("");
				txtAltura.setText("");
				comboBoxTipo.setSelectedIndex(0);
				comboBoxRegiao.setSelectedIndex(0);
			}
		});
		btnVoltaSalva.setBounds(300, 204, 187, 23);
		contentPane.add(btnVoltaSalva);
		
		btnVoltaSalva.setVisible(false);

	}
}