package Guru.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Guru.Entity.Dimas07146_GuruEntity;

public class Dimas07146_Update {
    JFrame upFrame = new JFrame();
    JLabel title, niplabel;
    JTextField niptext;
    JButton upbtn, back;

    public Dimas07146_Update(){
        upFrame.setSize(500,350);
        upFrame.setTitle("Update Data Guru");
        upFrame.setLayout(null);
        upFrame.getContentPane().setBackground(Color.GREEN);

        title = new JLabel("Update Data Guru");
        title.setBounds(30,30,400,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        upFrame.add(title);

        niplabel = new JLabel("Masukkan NIP");
        niplabel.setBounds(30,100,300,40);
        niplabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        upFrame.add(niplabel);

        niptext = new JTextField();
        niptext.setBounds(30,150,150,40);
        upFrame.add(niptext);

        back = new JButton("Back");
        back.setBounds(30,200,100,40);
        back.setBackground(Color.lightGray);
        upFrame.add(back);

        upbtn = new JButton("Update");
        upbtn.setBounds(150,200,100,40);
        upbtn.setBackground(Color.lightGray);
        upFrame.add(upbtn);

        //end
        upFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        upFrame.setVisible(true);
        upFrame.setLocationRelativeTo(null);

        upbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = Dimas07146_allobjctrl.guru.cekData(niptext.getText());

                if (result == -1){
                    JOptionPane.showMessageDialog(upFrame, "Data Kosong / Tidak Ditemukan");
                }else if (result == -2){
                    JOptionPane.showMessageDialog(upFrame, "Data Tidak Ditemukan");
                }else {
                    Dimas07146_GuruEntity guruEntity = Dimas07146_allobjctrl.guru.getDataByNIP(niptext.getText());
                    Dimas07146_UpdateGUI updateGUI = new Dimas07146_UpdateGUI(guruEntity);
                    upFrame.dispose();
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upFrame.dispose();
                Dimas07146_GUI men = new Dimas07146_GUI();
            }
        });

    }

}
