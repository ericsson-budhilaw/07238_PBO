package Guru.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Guru.Controller.Dimas07146_GuruController;
import javax.swing.table.DefaultTableModel;

public class Dimas07146_ViewGUI {
    private static Dimas07146_GuruController guru = new Dimas07146_GuruController();
    JFrame ViewGuru = new JFrame();
    JTable tabelguru = new JTable();
    JScrollPane scrollguru = new JScrollPane(tabelguru);
    JButton back;
    JLabel title;

    public Dimas07146_ViewGUI(){
        ViewGuru.setSize(600,600);
        ViewGuru.setLayout(null);
        ViewGuru.getContentPane().setBackground(Color.PINK);

        title = new JLabel("Guru.View Data Guru");
        title.setFont(new Font("Times New Roman", Font.BOLD, 40));
        title.setBounds(50,50,450,50);
        ViewGuru.add(title);

        scrollguru.setBounds(50,150,500,300);
        tabelguru.setModel(dataTable());
        ViewGuru.add(scrollguru);

        back = new JButton("Back");
        back.setBounds(50,500,100,40);
        back.setBackground(Color.red);
        ViewGuru.add(back);

        //end
        ViewGuru.setLocationRelativeTo(null);
        ViewGuru.setVisible(true);
        ViewGuru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewGuru.dispose();
                Dimas07146_GUI gui = new Dimas07146_GUI();
            }
        });
    }

    private DefaultTableModel dataTable() {
        DefaultTableModel daftarGuru = new DefaultTableModel();
        Object[] kolom = {"Nama","NIK","NIP","IDNum"};
        daftarGuru.setColumnIdentifiers(kolom);
        int maxGuru = Dimas07146_allobjctrl.guru.maxData();

        for (int i=0; i<maxGuru; i++){
            Object[] data = new Object[4];
            data[0] = Dimas07146_allobjctrl.guru.view(i).getNama();
            data[1] = Dimas07146_allobjctrl.guru.view(i).getNIK();
            data[2] = Dimas07146_allobjctrl.guru.view(i).getNIP();
            data[3] = Dimas07146_allobjctrl.guru.view(i).getIDNum();
            daftarGuru.addRow(data);
        }
        return daftarGuru;
    }


}
