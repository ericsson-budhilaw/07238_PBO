package GUI;

import Entity.Eric07238_SiswaEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Eric07238_Update {
    JFrame updateFrame = new JFrame();
    JLabel title, nisLabel;
    JTextField nisText;
    JButton updateBtn;

    public Eric07238_Update() {
        updateFrame.setSize(400,250);
        updateFrame.setTitle("Sisko - Edit Data");
        updateFrame.setLayout(null);
        updateFrame.getContentPane().setBackground(Color.GREEN);

        title = new JLabel("Edit Data");
        title.setBounds(120,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateFrame.add(title);

        nisLabel = new JLabel("NIS");
        nisLabel.setBounds(50, 80, 200, 50);
        nisLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateFrame.add(nisLabel);

        nisText = new JTextField();
        nisText.setBounds(150, 80, 200, 50);
        updateFrame.add(nisText);

        updateBtn = new JButton("Edit");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(50, 140,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);
        updateFrame.add(updateBtn);

        updateFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        updateFrame.setVisible(true);
        updateFrame.setLocationRelativeTo(null);

        updateFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                updateFrame.dispose();
                Eric07238_View view = new Eric07238_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nis = Integer.parseInt(nisText.getText());
                int result = Eric07238_AllObjectControl.siswa.cekData(nis);

                if(result == -1) {
                    JOptionPane.showMessageDialog(updateFrame, "Data siswa masih kosong");
                } else if(result == -2) {
                    JOptionPane.showMessageDialog(updateFrame, "Data siswa tidak ditemukan / NIS salah.");
                } else {
                    Eric07238_SiswaEntity siswaEntity = Eric07238_AllObjectControl.siswa.getDataByNis(nis);
                    Eric07238_UpdateGUI update = new Eric07238_UpdateGUI(siswaEntity);
                }
            }
        });
    }
}
