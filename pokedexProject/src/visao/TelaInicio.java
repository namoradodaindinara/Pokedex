package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class TelaInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 552);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setForeground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("POKEDEX");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(51, 7, 254, 56);
		contentPane.add(lblNewLabel_1);

		JButton btnTelaEscolherCad = new JButton("Iniciar");
		btnTelaEscolherCad.setFont(new Font("Segoe UI", Font.PLAIN, 33));
		btnTelaEscolherCad.setBackground(Color.YELLOW);
		btnTelaEscolherCad.setForeground(Color.RED);
		btnTelaEscolherCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolherTipoCadastro tipoCadastro = new TelaEscolherTipoCadastro();
				tipoCadastro.setVisible(true);
				tipoCadastro.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnTelaEscolherCad.setBounds(51, 434, 256, 47);
		contentPane.add(btnTelaEscolherCad);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(TelaInicio.class.getResource("/assets/pokemon-red-blue-battle.png")));
		lblNewLabel.setBounds(43, 68, 275, 234);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(TelaInicio.class.getResource("/assets/Sem nome (220\u00A0\u00D7\u00A0220\u00A0px).png")));
		lblNewLabel_4.setBounds(58, 313, 247, 110);
		contentPane.add(lblNewLabel_4);
	}
}

////