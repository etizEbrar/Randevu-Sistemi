package View;

import Model.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
		butonlar.setBounds(38, 187, 236, 329);
		contentPane.add(butonlar);

		GridBagLayout gbl_butonlar = new GridBagLayout();
		gbl_butonlar.columnWidths = new int[]{236, 0};
		gbl_butonlar.rowHeights = new int[]{37, 122, 122, 0};
		gbl_butonlar.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_butonlar.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		butonlar.setLayout(gbl_butonlar);
		butonlar.setLayout(new GridLayout(3, 1, 0, 10));
		
		JButton btnNewButton_2 = new JButton("Hasta Girişi");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1 = new frame1();
				f1.setVisible(true);
				admin_doktorLogin.this.setVisible(false);
			}
		});
		butonlar.add(btnNewButton_2);

		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		butonlar.add(btnNewButton_2, gbc_btnNewButton_2);



		
		JPanel login = new JPanel();
		login.setBackground(Color.LIGHT_GRAY);
		login.setBounds(356, 187, 416, 329);
		contentPane.add(login);
		login.setLayout(null);
		
		JLabel label_parola = new JLabel("Parola:");
		label_parola.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		label_parola.setBounds(6, 146, 161, 40);
		label_parola.setHorizontalAlignment(SwingConstants.LEFT);
		login.add(label_parola);
		
		JLabel label_tc = new JLabel("T.C. Numarası:");
		label_tc.setHorizontalAlignment(SwingConstants.LEFT);
		label_tc.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		label_tc.setBounds(6, 34, 161, 40);
		login.add(label_tc);
		//PAROLA
		txtTcNo =new JPasswordField();
		txtTcNo.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtTcNo.setText("");
		txtTcNo.setBounds(6, 185, 358, 48);
		login.add(txtTcNo);
		txtTcNo.setColumns(10);
		//TCNO
		textField = new JTextField();
		textField.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField.setText("");
		textField.setColumns(10);
		textField.setBounds(6, 71, 358, 48);
		login.add(textField);
		
		JButton btnNewButton_3_1 = new JButton("Giriş Yap");
		btnNewButton_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User h=new User();
				boolean key;
				key=h.login(textField.getText(),txtTcNo.getText());
				if(key){
					adminPage ad = null;
					try {
						ad = new adminPage();
					} catch (SQLException ex) {
						throw new RuntimeException(ex);
					}
					ad.setVisible(true);
					admin_doktorLogin.this.setVisible(false);

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
