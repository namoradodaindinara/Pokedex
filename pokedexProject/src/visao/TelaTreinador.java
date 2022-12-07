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
	private JTable table;
	private DefaultTableModel model;

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
		comboBoxPok.addItem("Selecione um pokémon:");

		if (!(poks.size() == 0)) {
			for (int i = 0; i < poks.size(); i++) {
				comboBoxPok.addItem(instanciaPok.listaPokemon().get(i).getNome());
			}
		} else {
			comboBoxPok.addItem("(Sem pokémon)");
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 265, 562, 128);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Treinador");
		model.addColumn("Peso");
		model.addColumn("Altura");
		model.addColumn("Data de Nasc.");
		model.addColumn("CPF");
		model.addColumn("Pokémon fav.");

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
							JOptionPane.showMessageDialog(null, "Campo obrigatório: Treinador");
						} else if (txtAltura.getText().isEmpty() || txtPeso.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigatório: Altura");
						} else if (comboBoxPok.getSelectedItem().equals("Selecione um pokémon:")) {
							JOptionPane.showMessageDialog(null, "Campo obrigatório: Pokémon favorito.");
						} else if (txtCpf.getText().equals("   .   .   -  ") || txtCpf.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigatório: CPF");
						} else if (txtData.getText().equals("  /  /    ") || txtData.getText() == null) {
							JOptionPane.showMessageDialog(null, "Campo obrigatório: Data de nasc");
						} else {

							for (int i = 0; i < arrayTreinadores.size(); i++) {
								text += arrayTreinadores.get(i).getCpf();
							}

							if (txtCpf.getText().length() != 14) {
								JOptionPane.showMessageDialog(null, "CPF inválido. Tente novamente.");
							} else if (!text.contains(txtCpf.getText())) {
								model.getDataVector().removeAllElements();
								t.setNome(txtNomeTreinador.getText());
								t.setPeso(Double.valueOf(txtPeso.getText()));
								t.setAltura(Double.valueOf(txtAltura.getText()));
								t.setCpf(txtCpf.getText());
								t.setDateNasc(txtData.getText());
								t.setPokFav(comboBoxPok.getSelectedItem().toString());

								boolean inserir = instanciaTre.inserir(t);

								JOptionPane.showMessageDialog(null, "Treinador cadastrado com sucesso!");

								for (Treinador t1 : arrayTreinadores) {
									Object[] tre = new Object[6];
									tre[0] = t1.getNome();
									tre[1] = t1.getPeso();
									tre[2] = t1.getAltura();
									tre[3] = t1.getDateNasc();
									tre[4] = t1.getCpf();
									tre[5] = t1.getPokFav();

									model.addRow(tre);
								}
							} else {
								JOptionPane.showMessageDialog(null, "Esse treinador já foi adicionado!");
							}

						}
						
						
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "Erro em campo: Altura. Você deve digitar um valor numérico nesse campo.");
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Erro em campo: Peso. Você deve digitar um valor numérico nesse campo.");
				}

			}
		});
		btnCadTre.setBounds(371, 65, 244, 51);
		contentPane.add(btnCadTre);

		JButton btnMostrar = new JButton("Mostrar cadastros");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!arrayTreinadores.isEmpty()) {
					model.getDataVector().removeAllElements();
					for (Treinador t1 : arrayTreinadores) {
						Object[] tre = new Object[6];
						tre[0] = t1.getNome();
						tre[1] = t1.getPeso();
						tre[2] = t1.getAltura();
						tre[3] = t1.getDateNasc();
						tre[4] = t1.getCpf();
						tre[5] = t1.getPokFav();

						model.addRow(tre);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum treinador cadastrado.");
				}
			}
		});
		btnMostrar.setBounds(371, 125, 244, 51);
		contentPane.add(btnMostrar);

		JButton btnNewButton_1 = new JButton("Deletar cadastro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinador t = new Treinador();
				if (table.getSelectedRow() >= 0) {
					if (table.getSelectedColumn() == 4) {
						instanciaTre.deletar(t,
								String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn())));
						model.removeRow(table.getSelectedRow());
						table.setModel(model);
					} else {
						JOptionPane.showMessageDialog(null, "Selecione uma célula da coluna 'CPF'.");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para deletar.");
				}
			}
		});
		btnNewButton_1.setBounds(371, 187, 244, 56);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("CADASTRAR TREINADOR");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(232, 20, 235, 14);
		contentPane.add(lblNewLabel);

	}
}
