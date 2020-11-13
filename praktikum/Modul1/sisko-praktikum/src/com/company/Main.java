package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Siswa> Eric07238_dataSiswa = new ArrayList();
    public Scanner Eric07238_input;

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        Eric07238_input = new Scanner(System.in);
        int Eric07238_selectedMenu, Eric07238_nis;

        do {
            System.out.println("==== Manajemen Data Siswa ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Keluar");
            System.out.println("--------------------");
            System.out.print("Pilih menu> ");

            Eric07238_selectedMenu = Eric07238_input.nextInt();

            switch (Eric07238_selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukan NIS: ");
                    Eric07238_nis = Eric07238_input.nextInt();

                    update(Eric07238_nis);
                    break;
                case 4:
                    System.out.println("Masukkan NIS: (Jika hapus semua data masukkan 0) ");
                    Eric07238_nis = Eric07238_input.nextInt();

                    delete(Eric07238_nis);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }
        } while(Eric07238_selectedMenu != 5);
    }

    public void add() {
        System.out.println("Masukan nama: ");
        String Eric07238_nama = Eric07238_input.next();
        System.out.println("Masukan Kelas: ");
        String Eric07238_kelas = Eric07238_input.next();
        System.out.println("Masukan NIS: ");
        int Eric07238_nis = Eric07238_input.nextInt();

        Siswa Eric07238_siswa = new Siswa(Eric07238_nama, Eric07238_kelas, Eric07238_nis);
        Eric07238_dataSiswa.add(Eric07238_siswa);
    }

    public void update(int nis) {
        for(int i = 0; i < Eric07238_dataSiswa.size(); i++) {
            if(Eric07238_dataSiswa.get(i).getNIS() == nis) {
                System.out.println("--------------------");
                System.out.println("Nama: " + Eric07238_dataSiswa.get(i).getNama());
                System.out.println("NIS: " + Eric07238_dataSiswa.get(i).getNIS());
                System.out.println("Kelas: " + Eric07238_dataSiswa.get(i).getKelas());
                System.out.println("--------------------");

                System.out.println("Masukan nama: ");
                String Eric07238_nama = Eric07238_input.next();
                System.out.println("Masukan Kelas: ");
                String Eric07238_kelas = Eric07238_input.next();
                System.out.println("Masukan NIS: ");
                int Eric07238_nisBaru = Eric07238_input.nextInt();

                // Menggunakan add karena user harus menginputkan kembali semua data
                Eric07238_dataSiswa.set(i, new Siswa(Eric07238_nama, Eric07238_kelas, Eric07238_nisBaru));

            }
        }
    }

    public void read() {
        if(Eric07238_dataSiswa.size() > 0) {
            for (int i = 0; i < Eric07238_dataSiswa.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Nama: " + Eric07238_dataSiswa.get(i).getNama());
                System.out.println("NIS: " + Eric07238_dataSiswa.get(i).getNIS());
                System.out.println("Kelas: " + Eric07238_dataSiswa.get(i).getKelas());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }

    public void delete(int nis) {
        if(nis == 0) {
            Eric07238_dataSiswa.clear();
            System.out.println("Data berhasil dihapus");
        } else {
            for(int i = 0; i < Eric07238_dataSiswa.size(); i++) {
                if(Eric07238_dataSiswa.get(i).getNIS() == nis) {
                    System.out.println("Data siswa milik: " + Eric07238_dataSiswa.get(i).getNama() + " berhasil terhapus");
                    Eric07238_dataSiswa.remove(i);
                }
            }
        }
    }
}