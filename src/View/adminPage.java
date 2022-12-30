package View;

import Helper.Helper;
import Model.Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
	public adminPage() throws SQLException {
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



		String[] hastaneTurleri = {"hastane","diş hastanesi","sağlık ocağı"};

		JPanel panel = new JPanel();
		tabbedPane.addTab("Kurum ekle", null, panel, null);
		panel.setLayout(null);

		JButton kurumEkleBbuton = new JButton("Kurum ekle");
		kurumEkleBbuton.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		kurumEkleBbuton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin a=new Admin();
				String s;
				s="hastane";
				try {
					a.addSaglikKurumu(textFieldKurumadı.getText(),textFieldİl.getText(),textFieldİlçe.getText(),s);
					Helper.showMsg("success");

				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
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


		//KURUM SILL
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Ad");
		model.addColumn("Soyad");

		Admin r=new Admin();
		for (int i = 0; i < r.getList().size(); i++) {
			model.addRow(new String[]{r.getList().get(i).getIsim(),r.getList().get(i).getIl(),r.getList().get(i).getIlce()});
		}
		kurumSilTable = new JTable(model);
		kurumSilTable.setBounds(6, 6, 399, 412);
		panel_2.add(kurumSilTable);

		//SATIR SİL

		// JTable'a bir MouseListener ekleyelim
		kurumSilTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Fare tıklandığında, tıklanan satırı silelim
				int row = kurumSilTable.rowAtPoint(e.getPoint()); // Tıklanan satırı bulalım
				kurumSilButon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						model.removeRow(row); // Satırı silelim
						Helper.showMsg("success");

					}
				});

			}
		});





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
