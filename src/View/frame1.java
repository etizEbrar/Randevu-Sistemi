package View;

import Model.Hasta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
		
		JButton admin_butonu = new JButton("Admin Girişi");
		admin_butonu.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		butonlar.add(admin_butonu);

		admin_butonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_doktorLogin ad = new admin_doktorLogin();
				ad.setVisible(true);
				frame1.this.setVisible(false);
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
		
		txtTcNo = new JPasswordField();
		txtTcNo.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtTcNo.setText("");
		txtTcNo.setBounds(6, 185, 358, 48);
		login.add(txtTcNo);
		txtTcNo.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(6, 71, 358, 48);
		login.add(textField);
		
		JButton btnNewButton_3 = new JButton("Kayıt Ol");
		btnNewButton_3.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3.setBounds(6, 256, 173, 48);
		login.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			 signUp s=new signUp();
			 s.setVisible(true);
			 frame1.this.setVisible(false);
			}
		});
		
		JButton btnNewButton_3_1 = new JButton("Giriş Yap");
		btnNewButton_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hasta h=new Hasta();
				boolean key;
				key=h.login(textField.getText(),txtTcNo.getText());
				if(key){
					hastaPage ad = null;
					try {
						ad = new hastaPage();
					} catch (SQLException ex) {
						throw new RuntimeException(ex);
					}
					ad.setVisible(true);
					frame1.this.setVisible(false);

				}



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
