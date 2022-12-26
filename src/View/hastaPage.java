package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class hastaPage extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hastaPage frame = new hastaPage();
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
	public hastaPage() {
		setTitle("Hasta İşlemleri");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 0, 800, 572);
		contentPane.add(contentPane_1);
		
		JLabel lblHastaIlemleri = new JLabel("Hasta İşlemleri");
		lblHastaIlemleri.setHorizontalAlignment(SwingConstants.CENTER);
		lblHastaIlemleri.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblHastaIlemleri.setBounds(225, 6, 349, 90);
		contentPane_1.add(lblHastaIlemleri);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(6, 96, 788, 470);
		contentPane_1.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Randevu al", null, panel, null);
		panel.setLayout(null);
		
		JLabel ilLabel = new JLabel("İl:");
		ilLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ilLabel.setBounds(85, 50, 93, 34);
		panel.add(ilLabel);
		
		JLabel ilçeLabel = new JLabel("İlçe:");
		ilçeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ilçeLabel.setBounds(85, 133, 93, 34);
		panel.add(ilçeLabel);
		
		JLabel klinikLabel = new JLabel("Klinik:");
		klinikLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		klinikLabel.setBounds(85, 216, 93, 34);
		panel.add(klinikLabel);
		
		JButton btnNewButton_1_1 = new JButton("ARA");
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(458, 280, 230, 89);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(388, 50, 318, 207);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		String[] saatler = {"10.00","10.30","11.00","11.30","13.00","13.30","14.00","15.30","16.00","16.30"};
		
		JComboBox comboBox = new JComboBox(saatler);
		comboBox.setBounds(24, 58, 288, 88);
		panel_3.add(comboBox);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(85, 69, 275, 52);
		panel.add(comboBox_2);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setBounds(85, 164, 275, 52);
		panel.add(comboBox_2_1);
		
		JComboBox comboBox_2_2 = new JComboBox();
		comboBox_2_2.setBounds(85, 248, 275, 52);
		panel.add(comboBox_2_2);
		
		JLabel hataneLabel = new JLabel("Hastane:");
		hataneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		hataneLabel.setBounds(85, 295, 93, 34);
		panel.add(hataneLabel);
		
		JComboBox comboBox_2_3 = new JComboBox();
		comboBox_2_3.setBounds(85, 326, 275, 52);
		panel.add(comboBox_2_3);
		 
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Randevularım", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1_1_1 = new JButton("Randevu sil");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		btnNewButton_1_1_1.setBounds(493, 285, 230, 89);
		panel_1.add(btnNewButton_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(18, 20, 419, 387);
		panel_1.add(panel_2);
		

		panel_2.setLayout(null);
		
		String[][] veri = {{"DOKTOR","SAAT"},{"---------------------","----------------------"},{"dr.mehmet","14.00"},{"dr.ayşe","12.00"}};
		String[] başlık = {"DOKTOR","SAAT"};
		
		table = new JTable(veri,başlık);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		table.setBounds(6, 6, 391, 376);
		panel_2.add(table);
		
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(459, 172, 288, 88);
		panel_1.add(comboBox_1);
		
		JButton güvenliCıkıs = new JButton("Güvenli Çıkış");
		güvenliCıkıs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1 f1= new frame1();
				f1.setVisible(true);
			}
		});
		güvenliCıkıs.setBounds(677, 6, 117, 29);
		contentPane_1.add(güvenliCıkıs);
		


	}
}
