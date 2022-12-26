package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class admin_doktorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtTcNo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_doktorLogin frame = new admin_doktorLogin();
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
	public admin_doktorLogin() {
		setBackground(UIManager.getColor("Button.darkShadow"));
		setTitle("HASTANE RANDEVU SİSTEMİ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel butonlar = new JPanel();
		butonlar.setBackground(Color.LIGHT_GRAY);
		butonlar.setBounds(38, 156, 236, 387);
		contentPane.add(butonlar);
		butonlar.setLayout(new GridLayout(3, 1, 0, 10));
		
		JButton btnNewButton_2 = new JButton("Hasta Girişi");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1 = new frame1();
				f1.setVisible(true);
			}
		});
		butonlar.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Doktor Girişi");
		btnNewButton_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		butonlar.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("admin");
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		butonlar.add(btnNewButton);
		
		JPanel login = new JPanel();
		login.setBackground(Color.LIGHT_GRAY);
		login.setBounds(356, 187, 416, 329);
		contentPane.add(login);
		login.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Parola:");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_1.setBounds(6, 146, 161, 40);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		login.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C. Numarası:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(6, 34, 161, 40);
		login.add(lblNewLabel_1_1);
		
		txtTcNo = new JTextField();
		txtTcNo.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtTcNo.setText("Parola");
		txtTcNo.setBounds(6, 185, 358, 48);
		login.add(txtTcNo);
		txtTcNo.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField.setText("TC NO");
		textField.setColumns(10);
		textField.setBounds(6, 71, 358, 48);
		login.add(textField);
		
		JButton btnNewButton_3_1 = new JButton("Giriş Yap");
		btnNewButton_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3_1.setBounds(216, 256, 173, 48);
		login.add(btnNewButton_3_1);
		
		JLabel lblNewLabel = new JLabel("Hastane Randevu Sistemine Hoşgeldiniz");
		lblNewLabel.setFont(new Font("Gurmukhi MN", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 28, 788, 75);
		contentPane.add(lblNewLabel);
	}
}
