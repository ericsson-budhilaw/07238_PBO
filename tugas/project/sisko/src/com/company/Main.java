package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Ericsson07238_SiswaEntity> dataSiswa = new ArrayList();
    static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        int selectedMenu;

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
                    update();
                    break;
                case 4:
                    System.out.println("Masukkan NIS: (Jika hapus semua data masukkan 0) ");
                    int nis = input.nextInt();
                    delete(nis);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }
        } while(selectedMenu != 5);
    }

    static void add() {
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        dataSiswa.add(new Ericsson07238_SiswaEntity(nama, kelas, nis));
    }

    static void update() {
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        // Menggunakan add karena user harus menginputkan kembali semua data
        dataSiswa.add(new Ericsson07238_SiswaEntity(nama, kelas, nis));
    }

    static void read() {
        for(int i = 0; i < dataSiswa.size(); i++) {
            System.out.println("--------------------");
            System.out.println("Nama: " + dataSiswa.get(i).getNama());
            System.out.println("NIS: " + dataSiswa.get(i).getNIS());
            System.out.println("Kelas: " + dataSiswa.get(i).getKelas());
            System.out.println("--------------------");
        }
    }

    static void delete(int nis) {
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
