package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminPage extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKurumadı;
	private JTextField textFieldİl;
	private JTextField textFieldİlçe;
	private JTable kurumSilTable;
	private JTable kurumGüncelleTable;
	private JTextField adTextfield;
	private JTextField ilTextfield;
	private JTextField ilçeTextfield;
	private JTextField adresTextfield;
	private JTextField textFieldAdres;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminPage frame = new adminPage();
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
	public adminPage() {
		setResizable(false);
		setTitle("admin İşlemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("admin İşlemleri");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(225, 6, 349, 90);
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(6, 96, 788, 470);
		contentPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Kurum Güncelle", null, panel_1, null);
		panel_1.setLayout(null);

		JButton kurumGüncelleButon = new JButton("Kurum güncelle");
		kurumGüncelleButon.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		kurumGüncelleButon.setBounds(456, 306, 230, 89);
		panel_1.add(kurumGüncelleButon);

		kurumGüncelleTable = new JTable();
		kurumGüncelleTable.setBounds(6, 6, 338, 412);
		panel_1.add(kurumGüncelleTable);

		JLabel kurumGüncelleAd = new JLabel("Adı:");
		kurumGüncelleAd.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kurumGüncelleAd.setBounds(384, 16, 61, 16);
		panel_1.add(kurumGüncelleAd);

		adTextfield = new JTextField();
		adTextfield.setBounds(384, 33, 198, 26);
		panel_1.add(adTextfield);
		adTextfield.setColumns(10);

		JLabel kurumGüncelleİl = new JLabel("İl:");
		kurumGüncelleİl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kurumGüncelleİl.setBounds(384, 71, 61, 16);
		panel_1.add(kurumGüncelleİl);

		ilTextfield = new JTextField();
		ilTextfield.setColumns(10);
		ilTextfield.setBounds(384, 88, 198, 26);
		panel_1.add(ilTextfield);

		JLabel kurumGüncelleİlçe = new JLabel("İlçe:");
		kurumGüncelleİlçe.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kurumGüncelleİlçe.setBounds(384, 128, 61, 16);
		panel_1.add(kurumGüncelleİlçe);

		ilçeTextfield = new JTextField();
		ilçeTextfield.setColumns(10);
		ilçeTextfield.setBounds(384, 145, 198, 26);
		panel_1.add(ilçeTextfield);

		JLabel kurumGüncelleAdres = new JLabel("Adres:");
		kurumGüncelleAdres.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kurumGüncelleAdres.setBounds(384, 185, 61, 16);
		panel_1.add(kurumGüncelleAdres);

		adresTextfield = new JTextField();
		adresTextfield.setColumns(10);
		adresTextfield.setBounds(384, 202, 198, 26);
		panel_1.add(adresTextfield);

		JLabel kurumGüncelleKategori = new JLabel("Kategori:");
		kurumGüncelleKategori.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kurumGüncelleKategori.setBounds(384, 238, 88, 27);
		panel_1.add(kurumGüncelleKategori);

		JComboBox kategoriComboBox = new JComboBox();
		kategoriComboBox.setBounds(384, 266, 198, 27);
		panel_1.add(kategoriComboBox);

		String[] hastaneTurleri = {"hastane","diş hastanesi","sağlık ocağı"};

		JPanel panel = new JPanel();
		tabbedPane.addTab("Kurum ekle", null, panel, null);
		panel.setLayout(null);

		JButton kurumEkleBbuton = new JButton("Kurum ekle");
		kurumEkleBbuton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		kurumEkleBbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		kurumEkleBbuton.setBounds(458, 279, 230, 89);
		panel.add(kurumEkleBbuton);

		JLabel kurumadıLabel = new JLabel("Kurum Adı:");
		kurumadıLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		kurumadıLabel.setBounds(78, 25, 93, 34);
		panel.add(kurumadıLabel);

		textFieldKurumadı = new JTextField();
		textFieldKurumadı.setColumns(10);
		textFieldKurumadı.setBounds(78, 58, 262, 34);
		panel.add(textFieldKurumadı);

		JLabel ilLabel = new JLabel("İl:");
		ilLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ilLabel.setBounds(78, 93, 93, 34);
		panel.add(ilLabel);

		textFieldİl = new JTextField();
		textFieldİl.setColumns(10);
		textFieldİl.setBounds(78, 126, 262, 34);
		panel.add(textFieldİl);

		JLabel ilçeLabel = new JLabel("İlçe:");
		ilçeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ilçeLabel.setBounds(78, 172, 93, 34);
		panel.add(ilçeLabel);

		JLabel hastaneLabel = new JLabel("Hastane türü:");
		hastaneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		hastaneLabel.setBounds(78, 321, 183, 34);
		panel.add(hastaneLabel);

		textFieldİlçe = new JTextField();
		textFieldİlçe.setColumns(10);
		textFieldİlçe.setBounds(78, 205, 262, 34);
		panel.add(textFieldİlçe);

		JComboBox comboboxHastane = new JComboBox(hastaneTurleri);
		comboboxHastane.setBounds(78, 354, 262, 27);
		panel.add(comboboxHastane);

		JLabel adresLabel = new JLabel("Adres:");
		adresLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		adresLabel.setBounds(78, 251, 93, 34);
		panel.add(adresLabel);

		textFieldAdres = new JTextField();
		textFieldAdres.setColumns(10);
		textFieldAdres.setBounds(78, 284, 262, 34);
		panel.add(textFieldAdres);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Kurum Sil", null, panel_2, null);
		panel_2.setLayout(null);

		JButton kurumSilButon = new JButton("Kurum sil");
		kurumSilButon.setBounds(460, 280, 230, 89);
		kurumSilButon.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		panel_2.add(kurumSilButon);

		kurumSilTable = new JTable();
		kurumSilTable.setBounds(6, 6, 399, 412);
		panel_2.add(kurumSilTable);

		JButton güvenliCıkıs = new JButton("Güvenli Çıkış");
		güvenliCıkıs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1 = new frame1();
				f1.setVisible(true);
			}
		});
		güvenliCıkıs.setBounds(677, 6, 117, 29);
		contentPane.add(güvenliCıkıs);
	}
}
