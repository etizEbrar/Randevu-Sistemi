package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class doktorPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doktorPage frame = new doktorPage();
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
	public doktorPage() {
		setTitle("Doktor İşlemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(16, 142, 767, 424);
		contentPane.add(panel);
		
		String[][] veri = {{"DOKTOR","SAAT"},{"---------------------","----------------------"},{"ali","14.00"},{"ayşe","12.00"},{"fatma","12.00"},{"mustafa","12.00"},{"mehmet","12.00"},{"aslan","12.00"},{"çağatay","12.00"},{"bora","12.00"},{"eşşek","12.00"}};
		String[] başlık = {"DOKTOR","SAAT"};
		
		table = new JTable(veri,başlık);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		table.setBounds(6, 6, 454, 412);
		panel.add(table);
		
		JButton btnNewButton_1_1 = new JButton("Randevu Sil");
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(504, 311, 230, 89);
		panel.add(btnNewButton_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(504, 48, 230, 27);
		panel.add(comboBox);
		
		
		
	
		
		JLabel lblDoktorIlemleri = new JLabel("Doktor İşlemleri");
		lblDoktorIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoktorIlemleri.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblDoktorIlemleri.setBounds(225, 24, 349, 90);
		contentPane.add(lblDoktorIlemleri);
		
		JButton güvenliCıkıs = new JButton("Güvenli Çıkış");
		güvenliCıkıs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1 = new frame1();
				f1.setVisible(true);
			}
		});
		güvenliCıkıs.setBounds(666, 6, 117, 29);
		contentPane.add(güvenliCıkıs);
	}
}
