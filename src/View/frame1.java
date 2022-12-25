package windowBuilder;

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
import javax.swing.AbstractAction;
import javax.swing.Action;

public class frame1 extends JFrame   {

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
					frame1 frame = new frame1();
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
	
	JButton doktorButonu;
	
	
	public frame1() {
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
		
		JButton hasta_butonu = new JButton("Hasta Girişi");
		hasta_butonu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		butonlar.add(hasta_butonu);
		
		JButton doktor_butonu = new JButton("Doktor Girişi");
		doktor_butonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_doktorLogin ad = new admin_doktorLogin();
				ad.setVisible(true);
				
			}
		});
		doktor_butonu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		butonlar.add(doktor_butonu);
		
		JButton admin_butonu = new JButton("admin");
		admin_butonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_doktorLogin ad = new admin_doktorLogin();
				ad.setVisible(true);
			}
		});
		admin_butonu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		butonlar.add(admin_butonu);
		
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
		
		JButton btnNewButton_3 = new JButton("Kayıt Ol");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setBounds(6, 256, 173, 48);
		login.add(btnNewButton_3);
		
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
