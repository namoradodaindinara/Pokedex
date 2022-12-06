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
		setBounds(100, 100, 369, 511);
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
		lblNewLabel_1.setBounds(49, 25, 254, 56);
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
		btnTelaEscolherCad.setBounds(49, 400, 256, 47);
		contentPane.add(btnTelaEscolherCad);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\images.jpg"));
		lblNewLabel.setBounds(44, 77, 270, 217);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Design sem nome (2).png"));
		lblNewLabel_2.setBounds(-352, 249, 537, 166);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Design sem nome (4).png"));
		lblNewLabel_3.setBounds(-171, 217, 485, 230);
		contentPane.add(lblNewLabel_3);
	}
}
