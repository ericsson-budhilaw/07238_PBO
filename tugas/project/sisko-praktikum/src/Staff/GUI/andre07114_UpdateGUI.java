package Staff.GUI;

import Staff.Controller.andre07114_AdminController;
import Staff.Controller.andre07114_DivisiController;
import Staff.Entity.andre07114_Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_UpdateGUI {
    JFrame updateGUI = new JFrame();
    JLabel title, npkLabel, namaLabel, divisiLabel, adminLabel;
    JTextField npkText, namaText;
    JComboBox divisiCombo, adminCombo;
    JButton updateBtn;

    private andre07114_DivisiController divisiController = new andre07114_DivisiController();
    private andre07114_AdminController aslabController = new andre07114_AdminController();

    public andre07114_UpdateGUI(andre07114_Staff staffEntity) {
        int maxDivisi = andre07114_AllObjctrl.staff.maxData();

        updateGUI.setSize(400,400);
        updateGUI.setTitle("Edit Data");
        updateGUI.setLayout(null);
        updateGUI.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Edit Data");
        title.setBounds(140,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateGUI.add(title);

        npkLabel = new JLabel("NPK");
        npkLabel.setBounds(50, 80, 200, 50);
        npkLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(npkLabel);

        npkText = new JTextField();
        npkText.setBounds(150, 80, 200, 50);
        npkText.setText(String.valueOf(staffEntity.getNpk()));
        updateGUI.add(npkText);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(50, 160, 200, 50);
        namaLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(namaLabel);

        namaText = new JTextField();
        namaText.setBounds(150, 160, 200, 50);
        namaText.setText(staffEntity.getNama());
        updateGUI.add(namaText);

        divisiLabel = new JLabel("Divisi");
        divisiLabel.setBounds(50, 240, 200, 50);
        divisiLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateGUI.add(divisiLabel);

        divisiCombo = new JComboBox();
        for(int i = 0; i < maxDivisi; i++) {
            divisiCombo.addItem(andre07114_AllObjctrl.bagian.view(i).getNama());
        }
        divisiCombo.setBounds(150, 240, 200, 50);
        divisiCombo.setSelectedItem(divisiController.getDataByKode(staffEntity.getDivisi()).getNama());
        updateGUI.add(divisiCombo);

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
                andre07114_View view = new andre07114_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int npkLama = Integer.parseInt(npkText.getText());
                int bagianIndex = divisiCombo.getSelectedIndex();
                String divisi = andre07114_AllObjctrl.bagian.getDataByIndex(bagianIndex).getCode();
                String result = andre07114_AllObjctrl.staff.update(new andre07114_Staff(Integer.parseInt(npkText.getText()), namaText.getText(), divisi), npkLama);
                kosong();
                JOptionPane.showMessageDialog(updateGUI, result);

                updateGUI.dispose();
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
