package Staff.GUI;

import Staff.Entity.andre07114_Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_AddData {
    JFrame add = new JFrame();
    JLabel title, npkLabel, namaLabel, divisiLabel, adminLabel;
    JTextField npkText, namaText;
    JComboBox divisiCombo, adminCombo;
    JButton createBtn;

    public andre07114_AddData() {
        int maxDivisi = andre07114_AllObjctrl.bagian.maxData();

        add.setSize(400,400);
        add.setTitle("Tambah Data");
        add.setLayout(null);
        add.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Tambah Data Baru");
        title.setBounds(70,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add.add(title);

        npkLabel = new JLabel("NPK");
        npkLabel.setBounds(50, 80, 200, 50);
        npkLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(npkLabel);

        npkText = new JTextField();
        npkText.setBounds(150, 80, 200, 50);
        add.add(npkText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        add.add(namaText);

        divisiLabel = new JLabel("Divisi");
        divisiLabel.setBounds(50, 240, 200, 50);
        divisiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(divisiLabel);

        divisiCombo = new JComboBox();
        for(int i = 0; i < maxDivisi; i++) {
            divisiCombo.addItem(andre07114_AllObjctrl.bagian.view(i).getNama());
        }
        divisiCombo.setBounds(150, 240, 200, 50);
        add.add(divisiCombo);

        createBtn = new JButton("Submit");
        createBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        createBtn.setBounds(50, 300,300, 40);
        createBtn.setFocusPainted(false);
        createBtn.setBackground(Color.LIGHT_GRAY);
        add.add(createBtn);

        add.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        add.setVisible(true);
        add.setLocationRelativeTo(null);

        add.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                add.setVisible(false);
                andre07114_GUI gui = new andre07114_GUI();
            }
        });

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kelasIndex = divisiCombo.getSelectedIndex();
                String divisi = andre07114_AllObjctrl.bagian.getDataByIndex(kelasIndex).getCode();
                String result = andre07114_AllObjctrl.staff.insert(new andre07114_Staff(Integer.parseInt(npkText.getText()), namaText.getText(), divisi));
                kosong();
                JOptionPane.showMessageDialog(add, result);

                add.dispose();
                andre07114_View view = new andre07114_View();
            }
        });
    }

    public void kosong() {
        npkText.setText("");
        namaText.setText("");
        divisiCombo.setSelectedIndex(0);
    }
}
