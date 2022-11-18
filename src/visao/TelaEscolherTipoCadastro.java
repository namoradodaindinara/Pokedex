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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("O que deseja cadastrar?");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 37, 221, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnCadTreinador = new JButton("Treinador");
		btnCadTreinador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTreinador telacadtreinador = new TelaTreinador();
				telacadtreinador.setLocationRelativeTo(null);
				telacadtreinador.setVisible(true);
				dispose();
			}
		});
		btnCadTreinador.setBounds(79, 80, 166, 48);
		contentPane.add(btnCadTreinador);
		
		JButton btnCadPokemon = new JButton("Pok\u00E9mon");
		btnCadPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPokemon telacadpokemon = new TelaPokemon();
				telacadpokemon.setLocationRelativeTo(null);
				telacadpokemon.setVisible(true);
				dispose();
			}
		});
		btnCadPokemon.setBounds(79, 139, 166, 48);
		contentPane.add(btnCadPokemon);
	}
}