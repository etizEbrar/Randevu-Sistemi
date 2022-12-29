package View;

import Model.Hasta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signUp extends JFrame {

	private JPanel contentPane;
	private JTextField adTextField;
	private JTextField soyadTextField;
	private JTextField tcTextField;
	private JTextField telNoTextField;
	private JTextField sifreTextField;

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
		
		JLabel adLabel = new JLabel("Ad:");
		adLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		adLabel.setBounds(90, 105, 61, 16);
		contentPane.add(adLabel);
		
		adTextField = new JTextField();
		adTextField.setBounds(90, 123, 266, 37);
		contentPane.add(adTextField);
		adTextField.setColumns(10);
		
		soyadTextField = new JTextField();
		soyadTextField.setColumns(10);
		soyadTextField.setBounds(90, 198, 266, 37);
		contentPane.add(soyadTextField);
		
		JLabel SoyadLabel = new JLabel("Soyad:");
		SoyadLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		SoyadLabel.setBounds(90, 180, 61, 16);
		contentPane.add(SoyadLabel);
		
		tcTextField = new JTextField();
		tcTextField.setColumns(10);
		tcTextField.setBounds(90, 277, 266, 37);
		contentPane.add(tcTextField);
		
		JLabel TcKimlikNumarasLabel = new JLabel("T.C. Kimlik Numarası:");
		TcKimlikNumarasLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		TcKimlikNumarasLabel.setBounds(90, 259, 197, 16);
		contentPane.add(TcKimlikNumarasLabel);
		
		telNoTextField = new JTextField();
		telNoTextField.setColumns(10);
		telNoTextField.setBounds(90, 419, 266, 37);
		contentPane.add(telNoTextField);
		
		JLabel telNoLabel = new JLabel("Telefon Numarası:");
		telNoLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		telNoLabel.setBounds(90, 401, 197, 16);
		contentPane.add(telNoLabel);
		
		sifreTextField = new JPasswordField();
		sifreTextField.setColumns(10);
		sifreTextField.setBounds(90, 344, 266, 37);
		contentPane.add(sifreTextField);
		
		JLabel sifreLabel = new JLabel("Şifre:");
		sifreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		sifreLabel.setBounds(90, 326, 61, 16);
		contentPane.add(sifreLabel);
		
		JButton KayıtTamamlaButon = new JButton("Kaydı Tamamla");
		KayıtTamamlaButon.setFont(new Font("Arial Black", Font.PLAIN, 20));
		KayıtTamamlaButon.setBounds(488, 374, 236, 122);
		contentPane.add(KayıtTamamlaButon);

		KayıtTamamlaButon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Hasta h=new Hasta();
				boolean key;
				key=h.register(adTextField.getText(),soyadTextField .getText(),tcTextField.getText(),telNoTextField.getText(),sifreTextField.getText());
				if(key){
					hastaPage ad = null;
					try {
						ad = new hastaPage();
					} catch (SQLException ex) {
						throw new RuntimeException(ex);
					}
					ad.setVisible(true);
					signUp.this.setVisible(false);
			}
		}});

		
		
	}
}
