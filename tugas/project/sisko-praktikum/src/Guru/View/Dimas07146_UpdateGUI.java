package Guru.View;

import Guru.Entity.Dimas07146_GuruEntity;
import Guru.Controller.Dimas07146_GuruController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class Dimas07146_UpdateGUI {
    Scanner input = new Scanner(System.in);
    JFrame UpdateGUI = new JFrame();
    JLabel title, namalabel, niklabel, niplabel;
    JTextField namatext, niktext, niptext;
    JButton update, back;

    private Dimas07146_GuruController guruController = new Dimas07146_GuruController();

    public String NIP, IDNum;
    public Dimas07146_UpdateGUI(Dimas07146_GuruEntity guruEntity) {
        try {
            UpdateGUI.setSize(600,600);
            UpdateGUI.setLayout(null);
            UpdateGUI.getContentPane().setBackground(Color.pink);

            title = new JLabel("Update Data Guru");
            title.setBounds(100,30,450,100);
            title.setFont(new Font("Times New Roman", Font.BOLD, 40));
            UpdateGUI.add(title);

            namalabel = new JLabel("Nama");
            namalabel.setBounds(50,150,300,30);
            UpdateGUI.add(namalabel);

            namatext = new JTextField();
            namatext.setBounds(50,190,300,30);
            namatext.setText(guruEntity.getNama());
            UpdateGUI.add(namatext);

            niklabel = new JLabel("NIK");
            niklabel.setBounds(50,230,300,30);
            UpdateGUI.add(niklabel);

            niktext = new JTextField();
            niktext.setBounds(50,270,300,30);
            niktext.setText(guruEntity.getNIK());
            UpdateGUI.add(niktext);

            niplabel = new JLabel("NIP");
            niplabel.setBounds(50,310,300,30);
            UpdateGUI.add(niplabel);

            niptext = new JTextField();
            niptext.setBounds(50,350,300,30);
            niptext.setText(guruEntity.getNIP());
            UpdateGUI.add(niptext);

            back = new JButton("Back");
            back.setBounds(50,400,150,40);
            back.setBackground(Color.red);
            UpdateGUI.add(back);

            update = new JButton("Update");
            update.setBounds(250,400,150,40);
            update.setBackground(Color.GREEN);
            UpdateGUI.add(update);

            //end
            UpdateGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            UpdateGUI.setVisible(true);
            UpdateGUI.setLocationRelativeTo(null);

            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UpdateGUI.dispose();
                    Dimas07146_GUI men = new Dimas07146_GUI();
                }
            });

            update.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String result = Dimas07146_allobjctrl.guru.update(new Dimas07146_GuruEntity(namatext.getText(), niptext.getText(), niktext.getText(), null), guruEntity.getIDNum());
                    kosong();
                    JOptionPane.showMessageDialog(UpdateGUI, result);

                    UpdateGUI.dispose();
                    Dimas07146_ViewGUI viewGUI = new Dimas07146_ViewGUI();
                }
            });
        }catch (Exception exception){
            JOptionPane.showMessageDialog(UpdateGUI, "Wrong");
            System.out.println("Guru:");
            System.out.println("Nama: "+guruEntity.getNama());
            System.out.println("NIK: "+guruEntity.getNIK());
        }

    }

    void kosong(){
        namatext.setText(null);
        niptext.setText(null);
        niktext.setText(null);
    }

}
