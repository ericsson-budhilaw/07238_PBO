package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Siswa> dataSiswa = new ArrayList();
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
            System.out.println("[5] Login");
            System.out.println("[6] Keluar");
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
                    login();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Kamu salah pilih menu!");
            }
        } while(selectedMenu != 6);
    }

    static void add() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        Siswa siswa = new Siswa(nama, kelas, nis, username, password);
        dataSiswa.add(siswa);
        siswa.save(username, password);

    }

    static void update() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        // Menggunakan add karena user harus menginputkan kembali semua data
        Siswa siswa = new Siswa(nama, kelas, nis, username, password);
        dataSiswa.add(siswa);
        siswa.save(username, password);
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

    static void login() {
        System.out.println("Masukan Username: ");
        String username = input.next();
        System.out.println("Masukan Password: ");
        String password = input.next();

        Siswa siswa = new Siswa("", "", 0, username, password);
        boolean result = siswa.login(username, password);

        if(result) {
            System.out.println("Login Berhasil !");
        } else {
            System.out.println("Login gagal !");
        }
    }
}