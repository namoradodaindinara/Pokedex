package visao;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.PokemonController;
import controle.TreinadorController;
import modelo.Pokemon;
import modelo.Treinador;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class TelaTreinador extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeTreinador;
	private JTextField txtPeso;
	private JTextField txtAltura;
	String text = "";
	private JTable tableTreinadores;
	private DefaultTableModel model;
	private Treinador treinadorAEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTreinador frame = new TelaTreinador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaTreinador() throws ParseException {
		PokemonController instanciaPok = PokemonController.getInstancia();
		ArrayList<Pokemon> poks = instanciaPok.listaPokemon();
		TreinadorController instanciaTre = TreinadorController.getInstancia();
		ArrayList<Treinador> arrayTreinadores = instanciaTre.listaTreinador();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 454);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JComboBox<String> comboBoxPok = new JComboBox();
		comboBoxPok.setBounds(165, 221, 174, 22);
		contentPane.add(comboBoxPok);
		comboBoxPok.addItem("Selecione um pok�mon:");
		if (!(poks.size() == 0)) {
			for (int i = 0; i < poks.size(); i++) {
				comboBoxPok.addItem(instanciaPok.listaPokemon().get(i).getNome());
			}
		} else {
			comboBoxPok.addItem("(Sem pok�mon)");
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 265, 562, 128);
		contentPane.add(scrollPane);

		tableTreinadores = new JTable();
		scrollPane.setViewportView(tableTreinadores);

		model = new DefaultTableModel();
		tableTreinadores.setModel(model);
		model.addColumn("ID");
		model.addColumn("Treinador");
		model.addColumn("Peso");
		model.addColumn("Altura");
		model.addColumn("Data de Nasc.");
		model.addColumn("CPF");
		model.addColumn("Pok�mon fav.");

		for (Treinador t : arrayTreinadores) {
			Object[] pok = new Object[7];
			pok[0] = t.getId();
			pok[1] = t.getNome();
			pok[2] = t.getPeso();
			pok[3] = t.getAltura();
			pok[4] = t.getDateNasc();
			pok[5] = t.getCpf();
			pok[6] = t.getPokFav();

			model.addRow(pok);
		}

		JLabel lblNewLabel_2_1 = new JLabel("Data de nasc:");
		lblNewLabel_2_1.setBounds(27, 162, 126, 14);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_1.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(97, 193, 56, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Altura:");
		lblNewLabel_1_1_1.setBounds(88, 133, 65, 14);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1 = new JLabel("Peso:");
		lblNewLabel_1_1.setBounds(94, 102, 59, 14);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Treinador:");
		lblNewLabel_1.setBounds(60, 69, 93, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.YELLOW);
		contentPane.add(lblNewLabel_1);

		txtNomeTreinador = new JTextField();
		txtNomeTreinador.setBounds(165, 66, 174, 20);
		contentPane.add(txtNomeTreinador);
		txtNomeTreinador.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setBounds(165, 99, 174, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(165, 130, 174, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		JLabel lblNewLabel_2_2 = new JLabel("Pok\u00E9mon favorito:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2_2.setForeground(Color.YELLOW);
		lblNewLabel_2_2.setBounds(31, 225, 122, 14);
		contentPane.add(lblNewLabel_2_2);

		JButton btnNewButton = new JButton("<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolherTipoCadastro telacadastro = new TelaEscolherTipoCadastro();
				telacadastro.setLocationRelativeTo(null);
				telacadastro.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(17, 19, 41, 23);
		contentPane.add(btnNewButton);

		JFormattedTextField txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtData.setBounds(165, 159, 174, 20);
		contentPane.add(txtData);

		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(165, 190, 174, 20);
		contentPane.add(txtCpf);

		JButton btnCadTre = new JButton("Cadastrar treinador");
		btnCadTre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinador t = new Treinador();

				try {
					Double.parseDouble(txtPeso.getText());

					try {
						Double.parseDouble(txtAltura.getText());
						if (txtNomeTreinador.getText().isEmpty() || txtNomeTreinador.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Treinador");
						} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Altura");
						} else if (comboBoxPok.getSelectedItem().equals("Selecione um pok�mon:")) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Pok�mon favorito.");
						} else if (txtCpf.getText().equals("   .   .   -  ") || txtCpf.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: CPF");
						} else if (txtData.getText().equals("  /  /    ") || txtData.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Data de nasc");
						} else {

							for (int i = 0; i < arrayTreinadores.size(); i++) {
								text += arrayTreinadores.get(i).getCpf();
							}

							if (txtCpf.getText().length() != 14) {
								JOptionPane.showMessageDialog(null, "CPF inv�lido. Tente novamente.");
							} else if (!text.contains(txtCpf.getText())) {
								model.getDataVector().removeAllElements();
								t.setId(arrayTreinadores.size() + 1);
								t.setNome(txtNomeTreinador.getText());
								t.setPeso(Double.valueOf(txtPeso.getText()));
								t.setAltura(Double.valueOf(txtAltura.getText()));
								t.setCpf(txtCpf.getText());
								t.setDateNasc(txtData.getText());
								t.setPokFav(comboBoxPok.getSelectedItem().toString());

								boolean inserir = instanciaTre.inserir(t);

								JOptionPane.showMessageDialog(null, "Treinador cadastrado com sucesso!");

								for (Treinador t1 : arrayTreinadores) {
									Object[] tre = new Object[7];
									tre[0] = t1.getId();
									tre[1] = t1.getNome();
									tre[2] = t1.getPeso();
									tre[3] = t1.getAltura();
									tre[4] = t1.getDateNasc();
									tre[5] = t1.getCpf();
									tre[6] = t1.getPokFav();

									model.addRow(tre);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Esse treinador j� foi adicionado!");
							}

						}

					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro em campo: Altura. Voc� deve digitar um valor num�rico nesse campo.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,
							"Erro em campo: Peso. Voc� deve digitar um valor num�rico nesse campo.");
				}

			}
		});

		JButton btnDeletar = new JButton("Deletar cadastro");
		JButton btnAlt = new JButton("Alterar");
		JButton btnVoltaSalva = new JButton("<- Voltar");

		btnCadTre.setBounds(371, 65, 244, 51);
		contentPane.add(btnCadTre);
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valida = instanciaTre.alterar(treinadorAEditar, treinadorAEditar.getId());
				if (valida) {
					try {
						Double.parseDouble(txtPeso.getText());

						try {
							Double.parseDouble(txtAltura.getText());
							if (txtNomeTreinador.getText().isEmpty() || txtNomeTreinador.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Treinador");
							} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Altura");
							} else if (comboBoxPok.getSelectedItem().equals("Selecione um pok�mon:")) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Pok�mon favorito.");
							} else if (txtCpf.getText().equals("   .   .   -  ") || txtCpf.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: CPF");
							} else if (txtData.getText().equals("  /  /    ") || txtData.getText() == null) {
								JOptionPane.showMessageDialog(null, "Campo obrigat�rio: Data de nasc");
							} else {
								JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

								model.getDataVector().removeAllElements();

								treinadorAEditar.setId(treinadorAEditar.getId());
								treinadorAEditar.setNome(txtNomeTreinador.getText());
								treinadorAEditar.setPeso(Double.valueOf(txtPeso.getText()));
								treinadorAEditar.setAltura(Double.valueOf(txtAltura.getText()));
								treinadorAEditar.setCpf(txtCpf.getText());
								treinadorAEditar.setDateNasc(txtData.getText());
								treinadorAEditar.setPokFav(comboBoxPok.getSelectedItem().toString());

								for (Treinador t1 : arrayTreinadores) {
									Object[] tre = new Object[7];
									tre[0] = t1.getId();
									tre[1] = t1.getNome();
									tre[2] = t1.getPeso();
									tre[3] = t1.getAltura();
									tre[4] = t1.getDateNasc();
									tre[5] = t1.getCpf();
									tre[6] = t1.getPokFav();

									model.addRow(tre);
								}

								btnVoltaSalva.setVisible(false);
								btnSalvar.setVisible(false);
								btnDeletar.setVisible(true);
								btnAlt.setVisible(true);
								btnCadTre.setVisible(true);
								txtNomeTreinador.setText("");
								txtPeso.setText("");
								txtAltura.setText("");
								txtData.setText("");
								txtCpf.setText("");
								comboBoxPok.setSelectedIndex(0);
								
								txtNomeTreinador.setText("");
								txtPeso.setText("");
								txtAltura.setText("");
								txtData.setText("");
								txtCpf.setText("");
								comboBoxPok.setSelectedIndex(0);

							}

						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null,
									"Erro em campo: Altura. Voc� deve digitar um valor num�rico nesse campo.");
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null,
								"Erro em campo: Peso. Voc� deve digitar um valor num�rico nesse campo.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar.");
				}
			}
		});
		btnSalvar.setBounds(371, 110, 244, 61);
		contentPane.add(btnSalvar);

		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinador t = new Treinador();
				if (tableTreinadores.getSelectedRow() >= 0) {
						instanciaTre.deletar(t, String.valueOf(tableTreinadores
								.getValueAt(tableTreinadores.getSelectedRow(), tableTreinadores.getSelectedColumn())));
						model.removeRow(tableTreinadores.getSelectedRow());
						tableTreinadores.setModel(model);
				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar.");
				}
			}
		});
		btnDeletar.setBounds(371, 126, 244, 56);
		contentPane.add(btnDeletar);

		JLabel lblNewLabel = new JLabel("CADASTRAR TREINADOR");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(232, 20, 235, 14);
		contentPane.add(lblNewLabel);

		btnAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableTreinadores.getSelectedRow() >= 0) {
					btnDeletar.setVisible(false);
					btnAlt.setVisible(false);
					btnCadTre.setVisible(false);
					btnSalvar.setVisible(true);
					btnVoltaSalva.setVisible(true);

					int linha = tableTreinadores.getSelectedRow();
					Integer idTreinador = (Integer) tableTreinadores.getValueAt(linha, 0);
					treinadorAEditar = instanciaTre.buscarTreinadorPorId(idTreinador);

					txtNomeTreinador.setText(treinadorAEditar.getNome());
					txtPeso.setText(String.valueOf(treinadorAEditar.getPeso()));
					txtAltura.setText(String.valueOf(treinadorAEditar.getAltura()));
					txtData.setText(treinadorAEditar.getDateNasc());
					txtCpf.setText(treinadorAEditar.getCpf());
					comboBoxPok.setSelectedItem(treinadorAEditar.getPokFav());

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para alterar.");
				}
			}
		});
		btnAlt.setBounds(371, 193, 244, 50);
		contentPane.add(btnAlt);
		
		
		btnVoltaSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVoltaSalva.setVisible(false);
				btnSalvar.setVisible(false);
				btnCadTre.setVisible(true);
				btnDeletar.setVisible(true);
				btnAlt.setVisible(true);
				
				txtNomeTreinador.setText("");
				txtPeso.setText("");
				txtAltura.setText("");
				txtData.setText("");
				txtCpf.setText("");
				comboBoxPok.setSelectedIndex(0);
			}
		});
		btnVoltaSalva.setBounds(371, 182, 244, 23);
		contentPane.add(btnVoltaSalva);

		btnSalvar.setVisible(false);
		btnVoltaSalva.setVisible(false);

	}
}
