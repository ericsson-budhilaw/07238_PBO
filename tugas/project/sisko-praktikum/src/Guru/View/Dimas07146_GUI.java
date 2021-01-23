package Guru.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dimas07146_GUI {
    JFrame mv = new JFrame();
    JLabel title, menu;
    JButton view, add, delete, update;

    public Dimas07146_GUI(){
        mv.setSize(700,630);
        mv.setLayout(null);
        mv.getContentPane().setBackground(Color.CYAN);

        title = new JLabel("Sistem Informasi Sekolah");
        title.setBounds(100,10,600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        mv.add(title);

        menu = new JLabel("Menu : ");
        menu.setBounds(50,80,300,50);
        menu.setFont(new Font("Times New Roman", Font.BOLD, 40));
        mv.add(menu);

        view = new JButton("1. View Data Guru");
        view.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        view.setBounds(50,180,300,40);
        view.setBackground(Color.GREEN);
        mv.add(view);

        add = new JButton("2. Tambah Data Guru");
        add.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        add.setBounds(50,250,300,40);
        add.setBackground(Color.GREEN);
        mv.add(add);

        delete = new JButton("3. Delete Data Guru");
        delete.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        delete.setBounds(50,340,300,40);
        delete.setBackground(Color.GREEN);
        mv.add(delete);

        update = new JButton("4. Update Data Guru");
        update.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
        update.setBounds(50,430,300,40);
        update.setBackground(Color.GREEN);
        mv.add(update);

        //end
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setVisible(true);
        mv.setLocationRelativeTo(null);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Guru.View.Dimas07146_AddGUI addGUI = new Dimas07146_AddGUI();
                    mv.dispose();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Salah Data !","information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Guru.View.Dimas07146_ViewGUI viewGUI = new Dimas07146_ViewGUI();
                    mv.dispose();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Salah Data!","information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Guru.View.Dimas07146_DeleteGUI deleteGUI = new Dimas07146_DeleteGUI();
                    mv.dispose();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Salah Data","information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dimas07146_Update updateGUI = new Dimas07146_Update();
                    mv.dispose();
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Salah Data","information",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

    }

}
