package Project;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import Murid.GUI.Eric07238_GUI;
import Guru.View.Dimas07146_GUI;

public class Main {

    private Scanner input;

    public static void main(String[] args) {
        Main main = new Main();
        main.menuGUI();
    }

    private void menuGUI() {
        JFrame gui = new JFrame();
        JLabel title;
        JButton murid, guru, staff;

        gui.setSize(600,484);
        gui.setLayout(null);
        Color back = new Color(0,128,255);
        gui.getContentPane().setBackground(back);

        title = new JLabel("Sistem Informasi Sekolah");
        title.setBounds(60,30,500,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 43));
        gui.add(title);

        guru = new JButton("Guru");
        guru.setBounds(50,143,180,76);
        guru.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        Color label = new Color(169,255,226);
        guru.setHorizontalAlignment(SwingConstants.LEFT);
        guru.setBackground(label);
        gui.add(guru);

        murid = new JButton("Murid");
        murid.setBounds(50,242,260,76);
        murid.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        murid.setHorizontalAlignment(SwingConstants.LEFT);
        murid.setBackground(label);
        gui.add(murid);

        staff = new JButton("Staff & Karyawan");
        staff.setBounds(50,347,400,76);
        staff.setFont(new Font("Times New Roman", Font.PLAIN, 44));
        staff.setHorizontalAlignment(SwingConstants.LEFT);
        staff.setBackground(label);
        gui.add(staff);

        //end
        gui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(gui,"Apakah Anda Yakin Ingin Keluar?") == JOptionPane.OK_OPTION){
                    gui.setVisible(false);
                    gui.dispose();
                }
            }
        });

        murid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eric07238_GUI muridGUI = new Eric07238_GUI();
                gui.dispose();
            }
        });

        guru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimas07146_GUI guruGUI = new Dimas07146_GUI();
                gui.dispose();
            }
        });
    }

}
