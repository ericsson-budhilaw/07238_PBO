package Murid.GUI;

import Murid.Entity.Eric07238_SiswaEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eric07238_Add {
    JFrame add = new JFrame();
    JLabel title, nisLabel, namaLabel, kelasLabel;
    JTextField nisText, namaText;
    JComboBox kelasCombo;
    JButton createBtn;

    public Eric07238_Add() {
        int maxKelas = Eric07238_AllObjectControl.kelas.maxData();

        add.setSize(400,400);
        add.setTitle("Sisko - Tambah Data");
        add.setLayout(null);
        add.getContentPane().setBackground(Color.GREEN);

        title = new JLabel("Tambah Data Baru");
        title.setBounds(70,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add.add(title);

        nisLabel = new JLabel("NIS");
        nisLabel.setBounds(50, 80, 200, 50);
        nisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(nisLabel);

        nisText = new JTextField();
        nisText.setBounds(150, 80, 200, 50);
        add.add(nisText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        add.add(namaText);

        kelasLabel = new JLabel("Kelas");
        kelasLabel.setBounds(50, 240, 200, 50);
        kelasLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add.add(kelasLabel);

        kelasCombo = new JComboBox();
        for(int i = 0; i < maxKelas; i++) {
            kelasCombo.addItem(Eric07238_AllObjectControl.kelas.view(i).getNama());
        }
        kelasCombo.setBounds(150, 240, 200, 50);
        add.add(kelasCombo);

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
                Eric07238_GUI gui = new Eric07238_GUI();
            }
        });

        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kelasIndex = kelasCombo.getSelectedIndex();
                String kelas = Eric07238_AllObjectControl.kelas.getDataByIndex(kelasIndex).getKode();
                String result = Eric07238_AllObjectControl.siswa.insert(new Eric07238_SiswaEntity(Integer.parseInt(nisText.getText()), namaText.getText(), kelas));
                kosong();
                JOptionPane.showMessageDialog(add, result);

                add.dispose();
                Eric07238_View view = new Eric07238_View();
            }
        });
    }

    public void kosong() {
        nisText.setText("");
        namaText.setText("");
        kelasCombo.setSelectedIndex(0);
    }
}
