package Staff.GUI;

import Staff.Entity.andre07114_Staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_Update {
    JFrame updateFrame = new JFrame();
    JLabel title, npkLabel;
    JTextField npkText;
    JButton updateBtn;

    public andre07114_Update() {
        updateFrame.setSize(400,250);
        updateFrame.setTitle("Edit Data");
        updateFrame.setLayout(null);
        updateFrame.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Edit Data");
        title.setBounds(120,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        updateFrame.add(title);

        npkLabel = new JLabel("NPK");
        npkLabel.setBounds(50, 80, 200, 50);
        npkLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateFrame.add(npkLabel);

        npkText = new JTextField();
        npkText.setBounds(150, 80, 200, 50);
        updateFrame.add(npkText);

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
                andre07114_View view = new andre07114_View();
            }
        });

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int npk = Integer.parseInt(npkText.getText());
                int result = andre07114_AllObjctrl.staff.cekData(npk);

                if(result == -1) {
                    JOptionPane.showMessageDialog(updateFrame, "Data masih kosong");
                } else if(result == -2) {
                    JOptionPane.showMessageDialog(updateFrame, "Data tidak ditemukan / NPK anda salah.");
                } else {
                    andre07114_Staff staffEntity = andre07114_AllObjctrl.staff.getDataByNis(npk);
                    andre07114_UpdateGUI update = new andre07114_UpdateGUI(staffEntity);
                }
            }
        });
    }
}
