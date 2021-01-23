package Guru.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dimas07146_DeleteGUI {
    JFrame del = new JFrame();
    JLabel title, niplabel;
    JButton delBtn;
    JTextField niptext;

    public Dimas07146_DeleteGUI(){
        del.setSize(300,400);
        del.setTitle("Hapus Guru");
        del.setLayout(null);
        del.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Hapus Data Guru");
        title.setBounds(30,30,250,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        del.add(title);

        niplabel = new JLabel("Masukkan NIP");
        niplabel.setBounds(30,100,150,30);
        niplabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        del.add(niplabel);

        niptext = new JTextField();
        niptext.setBounds(30,150,200,30);
        del.add(niptext);

        delBtn = new JButton("Delete");
        delBtn.setFont(new Font("Times New Roman", Font.BOLD, 20));
        delBtn.setBounds(30,200,150,30);
        delBtn.setBackground(Color.red);
        del.add(delBtn);

        //end
        del.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        del.setVisible(true);
        del.setLocationRelativeTo(null);

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = Dimas07146_allobjctrl.guru.hapusData(niptext.getText());
                if (result == -1){
                    JOptionPane.showMessageDialog(del, "Data Masih Kosong!");
                }else {
                    JOptionPane.showMessageDialog(del,"Data Telah Dihapus");
                    del.dispose();
                    Dimas07146_ViewGUI viewGUI = new Dimas07146_ViewGUI();
                }
            }
        });



    }


}
