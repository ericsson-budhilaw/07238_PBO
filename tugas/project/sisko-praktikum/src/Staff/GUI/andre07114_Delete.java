package Staff.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class andre07114_Delete {
    JFrame deleteFrame = new JFrame();
    JLabel title, npkLabel;
    JTextField npkText;
    JButton deleteBtn;

    public andre07114_Delete() {
        deleteFrame.setSize(400,250);
        deleteFrame.setTitle("Hapus Data");
        deleteFrame.setLayout(null);
        deleteFrame.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Hapus Data");
        title.setBounds(120,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        deleteFrame.add(title);

        npkLabel = new JLabel("NPK");
        npkLabel.setBounds(50, 80, 200, 50);
        npkLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteFrame.add(npkLabel);

        npkText = new JTextField();
        npkText.setBounds(150, 80, 200, 50);
        deleteFrame.add(npkText);

        deleteBtn = new JButton("Hapus");
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteBtn.setBounds(50, 140,300, 40);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBackground(Color.LIGHT_GRAY);
        deleteFrame.add(deleteBtn);

        deleteFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        deleteFrame.setVisible(true);
        deleteFrame.setLocationRelativeTo(null);

        deleteFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                deleteFrame.dispose();
                andre07114_View view = new andre07114_View();
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = andre07114_AllObjctrl.staff.delete(Integer.parseInt(npkText.getText()));
                if(result != 0) {
                    JOptionPane.showMessageDialog(deleteFrame, "Gagal menghapus data / Data masih kosong");
                } else {
                    JOptionPane.showMessageDialog(deleteFrame, "Data berhasil terhapus");
                    deleteFrame.dispose();
                    andre07114_View view = new andre07114_View();
                }
            }
        });
    }
}
