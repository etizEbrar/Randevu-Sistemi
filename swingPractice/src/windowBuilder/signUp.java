package windowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUp frame = new signUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public signUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKaytOl = new JLabel("Kayıt Ol");
		lblKaytOl.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaytOl.setFont(new Font("Gurmukhi MN", Font.BOLD, 30));
		lblKaytOl.setBounds(6, 6, 788, 75);
		contentPane.add(lblKaytOl);
		
		JLabel lblNewLabel = new JLabel("Ad:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(90, 105, 61, 16);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 123, 266, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 198, 266, 37);
		contentPane.add(textField_1);
		
		JLabel lblSoyad = new JLabel("Soyad:");
		lblSoyad.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblSoyad.setBounds(90, 180, 61, 16);
		contentPane.add(lblSoyad);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 277, 266, 37);
		contentPane.add(textField_2);
		
		JLabel lblTcKimlikNumaras = new JLabel("T.C. Kimlik Numarası:");
		lblTcKimlikNumaras.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTcKimlikNumaras.setBounds(90, 259, 197, 16);
		contentPane.add(lblTcKimlikNumaras);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 419, 266, 37);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telefon Numarası:");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(90, 401, 197, 16);
		contentPane.add(lblNewLabel_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 344, 266, 37);
		contentPane.add(textField_4);
		
		JLabel lblifre = new JLabel("Şifre:");
		lblifre.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblifre.setBounds(90, 326, 61, 16);
		contentPane.add(lblifre);
		
		JButton btnKaydTamamla = new JButton("Kaydı Tamamla");
		btnKaydTamamla.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnKaydTamamla.setBounds(488, 374, 236, 122);
		contentPane.add(btnKaydTamamla);
		
		
	}
}
