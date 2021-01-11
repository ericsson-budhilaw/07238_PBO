package GUI;

import Controller.Eric07238_AslabController;
import Controller.Eric07238_KelasController;
import Entity.Eric07238_SiswaEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eric07238_UpdateGUI {
    JFrame updateGUI = new JFrame();
    JLabel title, nisLabel, namaLabel, kelasLabel, aslabLabel;
    JTextField nisText, namaText;
    JComboBox kelasCombo, aslabCombo;
    JButton updateBtn;

    private Eric07238_KelasController kelasController = new Eric07238_KelasController();
    private Eric07238_AslabController aslabController = new Eric07238_AslabController();

    public Eric07238_UpdateGUI(Eric07238_SiswaEntity siswaEntity) {
        int maxKelas = Eric07238_AllObjectControl.kelas.maxData();

        updateGUI.setSize(400,400);
        updateGUI.setTitle("Sisko - Edit Data");
        updateGUI.setLayout(null);
        updateGUI.getContentPane().setBackground(Color.GREEN);

        title = new JLabel("Edit Data");
        title.setBounds(140,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateGUI.add(title);

        nisLabel = new JLabel("NIS");
        nisLabel.setBounds(50, 80, 200, 50);
        nisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(nisLabel);

        nisText = new JTextField();
        nisText.setBounds(150, 80, 200, 50);
        nisText.setText(String.valueOf(siswaEntity.getNis()));
        updateGUI.add(nisText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        namaText.setText(siswaEntity.getNama());
        updateGUI.add(namaText);

        kelasLabel = new JLabel("Kelas");
        kelasLabel.setBounds(50, 240, 200, 50);
        kelasLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(kelasLabel);

        kelasCombo = new JComboBox();
        for(int i = 0; i < maxKelas; i++) {
            kelasCombo.addItem(Eric07238_AllObjectControl.kelas.view(i).getNama());
        }
        kelasCombo.setBounds(150, 240, 200, 50);
        kelasCombo.setSelectedItem(kelasController.getDataByKode(siswaEntity.getKelas()).getNama());
        updateGUI.add(kelasCombo);

        updateBtn = new JButton("Submit");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(50, 300,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateGUI.add(updateBtn);

        updateGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        updateGUI.setVisible(true);
        updateGUI.setLocationRelativeTo(null);

        updateGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateGUI.dispose();
                Eric07238_View view = new Eric07238_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nisLama = Integer.parseInt(nisText.getText());
                int kelasIndex = kelasCombo.getSelectedIndex();
                String kelas = Eric07238_AllObjectControl.kelas.getDataByIndex(kelasIndex).getKode();
                String result = Eric07238_AllObjectControl.siswa.update(new Eric07238_SiswaEntity(Integer.parseInt(nisText.getText()), namaText.getText(), kelas), nisLama);
                kosong();
                JOptionPane.showMessageDialog(updateGUI, result);

                updateGUI.dispose();
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
