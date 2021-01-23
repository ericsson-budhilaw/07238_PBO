package Guru.View;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Guru.Entity.Dimas07146_GuruEntity;


public class Dimas07146_AddGUI {
    Scanner input = new Scanner(System.in);
    JFrame AddGui = new JFrame();
    JLabel title, namalabel, niklabel, niplabel;
    JTextField namatext, niktext, niptext;
    JButton daftar, back;

    public String nama, NIK, NIP, IDNum;
    Dimas07146_AddGUI() {
        try {
            AddGui.setSize(600,600);
            AddGui.setLayout(null);
            AddGui.getContentPane().setBackground(Color.pink);

            title = new JLabel("Tambah Data Guru");
            title.setBounds(100,30,450,100);
            title.setFont(new Font("Times New Roman", Font.BOLD, 40));
            AddGui.add(title);

            namalabel = new JLabel("Nama");
            namalabel.setBounds(50,150,300,30);
            AddGui.add(namalabel);

            namatext = new JTextField();
            namatext.setBounds(50,190,300,30);
            AddGui.add(namatext);

            niklabel = new JLabel("NIK");
            niklabel.setBounds(50,230,300,30);
            AddGui.add(niklabel);

            niktext = new JTextField();
            niktext.setBounds(50,270,300,30);
            AddGui.add(niktext);

            niplabel = new JLabel("NIP");
            niplabel.setBounds(50,310,300,30);
            AddGui.add(niplabel);

            niptext = new JTextField();
            niptext.setBounds(50,350,300,30);
            AddGui.add(niptext);

            back = new JButton("Back");
            back.setBounds(50,400,150,40);
            back.setBackground(Color.red);
            AddGui.add(back);

            daftar = new JButton("Daftar");
            daftar.setBounds(250,400,150,40);
            daftar.setBackground(Color.GREEN);
            AddGui.add(daftar);

            //end
            AddGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            AddGui.setVisible(true);
            AddGui.setLocationRelativeTo(null);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    AddGui.dispose();
                    Dimas07146_GUI men = new Dimas07146_GUI();
                }
            });

            daftar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String result = Dimas07146_allobjctrl.guru.insert(new Dimas07146_GuruEntity(namatext.getText(), niptext.getText(), niktext.getText(), null));
                        kosong();
                        JOptionPane.showMessageDialog(AddGui, result);
                    }catch (Exception exception){
                        JOptionPane.showMessageDialog(null,"Registrasi Gagal, Salah Input!","information",JOptionPane.INFORMATION_MESSAGE);
                        kosong();
                    }
                }
            });

        }catch (Exception exception){
            JOptionPane.showMessageDialog(null, "Salah Memasukkan Data !","information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void kosong(){
        namatext.setText(null);
        niptext.setText(null);
        niktext.setText(null);
    }

}
