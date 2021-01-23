package Murid.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;

public class Eric07238_View {
    JFrame view = new JFrame();
    JLabel title;
    JTable daftarSiswa = new JTable();
    JScrollPane scrollSiswa = new JScrollPane(daftarSiswa);
    JButton deleteBtn, updateBtn;

    public Eric07238_View() {
        view.setSize(600,500);
        view.setTitle("Sisko - Lihat Data");
        view.setLayout(null);
        view.getContentPane().setBackground(Color.GREEN);

        title = new JLabel("Tambah Data Baru");
        title.setBounds(180,10, 600,50);
        title.setFont(new Font("Times New Roman", Font.BOLD, 30));
        view.add(title);

        scrollSiswa.setBounds(40, 100, 500, 200);
        daftarSiswa.setModel(dataTable());
        view.add(scrollSiswa);

        delete();

        update();

        view.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        view.setVisible(true);
        view.setLocationRelativeTo(null);

        view.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                view.dispose();
                Eric07238_GUI gui = new Eric07238_GUI();
            }
        });
    }

    public DefaultTableModel dataTable() {
        DefaultTableModel daftarSiswa = new DefaultTableModel();
        Object[] kolomTabel = {"NIS", "Nama", "Kelas", "Asisten"};
        daftarSiswa.setColumnIdentifiers(kolomTabel);
        int maxSiswa = Eric07238_AllObjectControl.siswa.maxData();

        for(int i = 0; i < maxSiswa; i++) {
            Object[] data = new Object[4];
            data[0] = Eric07238_AllObjectControl.siswa.view(i).getNis();
            data[1] = Eric07238_AllObjectControl.siswa.view(i).getNama();
            data[2] = Eric07238_AllObjectControl.kelas.getDataByKode(Eric07238_AllObjectControl.siswa.view(i).getKelas()).getNama();
            data[3] = Eric07238_AllObjectControl.aslab.getDataByKode(Eric07238_AllObjectControl.siswa.view(i).getKelas()).getNama();
            daftarSiswa.addRow(data);
        }
        return daftarSiswa;
    }

    public void delete() {
        /*
         * Update Button
         *
         * @author: Ericsson Budhilaw
         */

        deleteBtn = new JButton("Hapus Data");
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        deleteBtn.setBounds(140, 320,300, 40);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBackground(Color.LIGHT_GRAY);

        try {
            Image updateIcon = ImageIO.read(new FileInputStream("res/delete.png"));
            Image newAddIcon = updateIcon.getScaledInstance(30, 30, 30);
            deleteBtn.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        view.add(deleteBtn);

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                Eric07238_Delete delete = new Eric07238_Delete();
            }
        });
    }

    public void update() {
        /*
         * Update Button
         *
         * @author: Ericsson Budhilaw
         */

        updateBtn = new JButton("Edit Data");
        updateBtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        updateBtn.setBounds(140, 380,300, 40);
        updateBtn.setFocusPainted(false);
        updateBtn.setBackground(Color.LIGHT_GRAY);

        try {
            Image updateIcon = ImageIO.read(new FileInputStream("res/edit.png"));
            Image newAddIcon = updateIcon.getScaledInstance(30, 30, 30);
            updateBtn.setIcon(new ImageIcon(newAddIcon));
        } catch (Exception e) {
            System.out.println(e);
        }
        view.add(updateBtn);

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
                Eric07238_Update update = new Eric07238_Update();
            }
        });
    }

    public void refresh() {
        daftarSiswa.revalidate();
    }

}
