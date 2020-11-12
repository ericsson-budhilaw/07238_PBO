package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public ArrayList<Siswa> dataSiswa   = new ArrayList();
    public Scanner input;

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int selectedMenu, nis;

        do {
            System.out.println("==== Manajemen Data Siswa ====");
            System.out.println("[1] Lihat data");
            System.out.println("[2] Tambah data");
            System.out.println("[3] Edit data");
            System.out.println("[4] Hapus data");
            System.out.println("[5] Keluar");
            System.out.println("--------------------");
            System.out.print("Pilih menu> ");

            selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    read();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    System.out.println("Masukan NIS: ");
                    nis = input.nextInt();

                    update(nis);
                    break;
                case 4:
                    System.out.println("Masukkan NIS: (Jika hapus semua data masukkan 0) ");
                    nis = input.nextInt();

                    delete(nis);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }
        } while(selectedMenu != 5);
    }

    public void add() {
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        Siswa siswa = new Siswa(nama, kelas, nis);
        dataSiswa.add(siswa);
    }

    public void update(int nis) {
        for(int i = 0; i < dataSiswa.size(); i++) {
            if(dataSiswa.get(i).getNIS() == nis) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataSiswa.get(i).getNama());
                System.out.println("NIS: " + dataSiswa.get(i).getNIS());
                System.out.println("Kelas: " + dataSiswa.get(i).getKelas());
                System.out.println("--------------------");

                System.out.println("Masukan nama: ");
                String nama = input.next();
                System.out.println("Masukan Kelas: ");
                String kelas = input.next();
                System.out.println("Masukan NIS: ");
                int nisBaru = input.nextInt();

                // Menggunakan add karena user harus menginputkan kembali semua data
                dataSiswa.set(i, new Siswa(nama, kelas, nisBaru));
            }
        }
    }

    public void read() {
        if(dataSiswa.size() > 0) {
            for (int i = 0; i < dataSiswa.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataSiswa.get(i).getNama());
                System.out.println("NIS: " + dataSiswa.get(i).getNIS());
                System.out.println("Kelas: " + dataSiswa.get(i).getKelas() + " [ " + dataSiswa.get(i).getJadwalKelas() + " ]");
                System.out.println("--------------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }

    public void delete(int nis) {
        if(nis == 0) {
            dataSiswa.clear();
            System.out.println("Data berhasil dihapus");
        } else {
            for(int i = 0; i < dataSiswa.size(); i++) {
                if(dataSiswa.get(i).getNIS() == nis) {
                    System.out.println("Data siswa milik: " + dataSiswa.get(i).getNama() + " berhasil terhapus");
                    dataSiswa.remove(i);
                }
            }
        }
    }
}