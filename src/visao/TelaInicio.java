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
					frame.setLocationRelativeTo(null);				} catch (Exception e) {
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
		setBounds(100, 100, 482, 639);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 20, 60));
		contentPane.setForeground(new Color(220, 20, 60));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo(a) ao");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(153, 11, 136, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("POKEDEX");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 215, 0));
		lblNewLabel_1.setFont(new Font("Wide Latin", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(93, 49, 254, 56);
		contentPane.add(lblNewLabel_1);
	}
}
