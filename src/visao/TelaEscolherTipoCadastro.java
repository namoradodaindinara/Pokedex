package visao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaEscolherTipoCadastro extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaEscolherTipoCadastro() {
		setForeground(Color.RED);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O que deseja cadastrar?");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 37, 221, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnCadTreinador = new JButton("Treinador");
		btnCadTreinador.setForeground(Color.RED);
		btnCadTreinador.setBackground(Color.YELLOW);
		btnCadTreinador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTreinador telacadtreinador = new TelaTreinador();
				telacadtreinador.setLocationRelativeTo(null);
				telacadtreinador.setVisible(true);
				dispose();
			}
		});
		btnCadTreinador.setBounds(80, 93, 166, 48);
		contentPane.add(btnCadTreinador);
		
		JButton btnCadPokemon = new JButton("Pok\u00E9mon");
		btnCadPokemon.setForeground(Color.RED);
		btnCadPokemon.setBackground(Color.YELLOW);
		btnCadPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPokemon telacadpokemon = new TelaPokemon();
				telacadpokemon.setLocationRelativeTo(null);
				telacadpokemon.setVisible(true);
				dispose();
			}
		});
		btnCadPokemon.setBounds(80, 152, 166, 48);
		contentPane.add(btnCadPokemon);
	}
}