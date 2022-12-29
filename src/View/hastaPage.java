package View;

import Helper.Item;
import Model.Admin;
import Model.Randevu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
	public hastaPage() throws SQLException {
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
		ilLabel.setBounds(85, 40, 93, 34);
		panel.add(ilLabel);

		JLabel ilçeLabel = new JLabel("İlçe:");
		ilçeLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		ilçeLabel.setBounds(85, 133, 93, 34);
		panel.add(ilçeLabel);

		JLabel klinikLabel = new JLabel("Klinik:");
		klinikLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		klinikLabel.setBounds(85, 295, 93, 34);
		panel.add(klinikLabel);

		JLabel hataneLabel = new JLabel("Hastane:");
		hataneLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		hataneLabel.setBounds(85, 216, 93, 34);
		panel.add(hataneLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(388, 50, 318, 207);
		panel.add(panel_3);
		panel_3.setLayout(null);



		String[] saatler = {"10.00", "10.30", "11.00", "11.30", "13.00", "13.30", "14.00", "15.30", "16.00", "16.30"};
        //SAAT SECME
		JComboBox select_saat = new JComboBox(saatler);
		select_saat.setBounds(24, 150, 288, 52);
		panel_3.add(select_saat);
		select_saat.addItem("Tarih sec");
		//	İL SEÇME
		JComboBox<String> select_il = new JComboBox<>();
		select_il.setBounds(85, 69, 275, 52);
		panel.add(select_il);
		select_il.addItem("Il Sec");
		Admin a = new Admin();
		for (int i = 0; i < a.getList().size(); i++) {
			select_il.addItem(new Item(a.getList().get(i).getId(), a.getList().get(i).getIl()).toString());}
		//ILCE SECME
		JComboBox<String> select_ilce = new JComboBox<>();
		select_ilce.setBounds(85, 164, 275, 52);
		panel.add(select_ilce);
		select_ilce.addItem("ilce");
		Randevu r=new Randevu();
		//HASTANE SECME
		JComboBox<String> select_hastane = new JComboBox<>();
		select_hastane.setBounds(85, 248, 275, 52);
		panel.add(select_hastane);
		select_hastane .addItem("Hastane seç");
		//String selectedItem = (String) select_il.getSelectedItem();
		final boolean[] gelis = {false};
		//ILE GORE ILCE SIRALAMA
		select_il.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selectedItem = select_il.getSelectedItem();

				if (selectedItem != null) {
						try {
							if(gelis[0]) select_ilce.removeAllItems();
						for (int i = 0; i < r.getList(selectedItem.toString()).size(); i++){
							select_ilce.addItem(new Item(r.getList(selectedItem.toString()).get(i).getId(), r.getList(selectedItem.toString()).get(i).getIlce()).toString()); }

						} catch (SQLException ex) {
							throw new RuntimeException(ex);
						}

				}
			}
		});
		gelis[0] =true;

        //İLCEYE GORE HASTANE SECME
		final boolean[] gelis2 = {false};
		select_hastane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selectedItem = select_ilce.getSelectedItem();

				if (selectedItem != null) {
					try {
						if(gelis2[0]) select_hastane.removeAllItems();
						for (int i = 0; i < r.getList2(selectedItem.toString()).size(); i++){
							select_hastane.addItem(new Item(r.getList2(selectedItem.toString()).get(i).getId(), r.getList2(selectedItem.toString()).get(i).getIsim()).toString()); }

					} catch (SQLException ex) {
						throw new RuntimeException(ex);
					}

				}
			}
		});
		gelis2[0] =true;
        //KLINIK SECME
		String []  klinik={"Klinik seç","Dahiliye","Pediatri","Cildiye"};

		JComboBox select_klinik = new JComboBox(klinik);
		select_klinik .setBounds(85, 326, 275, 52);
		panel.add(select_klinik );

		//DOKTOR SECME
		JComboBox select_doktor= new JComboBox();
		select_doktor.setBounds(24, 69, 288, 52);
		panel_3.add(select_doktor);
		select_doktor.addItem("Doktor Sec");

		//KLINIGE GORE DOKTOR SECME
		final boolean[] gelis3 = {false};
		select_klinik.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedItem = select_klinik.getSelectedIndex();
				try {
					if(gelis2[0]) select_doktor.removeAllItems();
					if (selectedItem==1){
						for (int i = 0; i < r.getDoctorsByCategoryID(selectedItem).size(); i++){
							select_doktor.addItem(new Item(r.getDoctorsByCategoryID(selectedItem).get(i).getId(), r.getDoctorsByCategoryID(selectedItem).get(i).getAd()).toString()); }

					}
					else if (selectedItem==2) {
						for (int i = 0; i < r.getDoctorsByCategoryID(selectedItem).size(); i++){
							select_doktor.addItem(new Item(r.getDoctorsByCategoryID(selectedItem).get(i).getId(), r.getDoctorsByCategoryID(selectedItem).get(i).getAd()).toString()); }
					}
					else if(selectedItem==3) {
						for (int i = 0; i < r.getDoctorsByCategoryID(selectedItem).size(); i++){
							select_doktor.addItem(new Item(r.getDoctorsByCategoryID(selectedItem).get(i).getId(), r.getDoctorsByCategoryID(selectedItem).get(i).getAd()).toString()); }

					}
				} catch (SQLException ex) {
					throw new RuntimeException(ex);
				}
			}});
		gelis3[0] =true;

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

			String[][] veri = {{"DOKTOR", "SAAT"}, {"dr.mehmet", "14.00"}, {"dr.ayşe", "12.00"}};
			String[] başlık = {"DOKTOR", "SAAT"};

			table = new JTable(veri, başlık);
			table.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			table.setBounds(6, 6, 391, 376);
			panel_2.add(table);


		//	JComboBox comboBox_1 = new JComboBox();
		//	comboBox_1.setBounds(459, 172, 288, 88);
		//	panel_1.add(comboBox_1);

		//BUTON
		JButton button_randevu = new JButton("Randevu Oluştur");
		button_randevu.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		button_randevu.setBounds(458, 280, 230, 89);
		panel.add(button_randevu);
		//
		button_randevu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "Basarıyla randevu olusturuldu", "Randevu", JOptionPane.INFORMATION_MESSAGE);
					select_ilce.removeAllItems();
					select_hastane.removeAllItems();
					select_doktor.removeAllItems();


				} catch (HeadlessException ex) {
					throw new RuntimeException(ex);

				}
			}
		});



			JButton güvenliCıkıs = new JButton("Güvenli Çıkış");
			güvenliCıkıs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame1 f1 = new frame1();
					f1.setVisible(true);
					hastaPage.this.setVisible(false);
				}
			});
			güvenliCıkıs.setBounds(677, 6, 117, 29);
			contentPane_1.add(güvenliCıkıs);


		}
	}

