package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Update git
    public ArrayList<Siswa> dataSiswa   = new ArrayList();
    public ArrayList<Guru> dataGuru   = new ArrayList();
    public Scanner input;

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int pilMain;

        do {
            System.out.println("Selamat Datang Di Sistem Informasi Sekolah");
            System.out.println("Pilihan: ");
            System.out.println("1. Siswa");
            System.out.println("2. Guru");
            System.out.print("Masukkan Pilihan : ");
            pilMain = input.nextInt();
            switch(pilMain){
                case 1:
                    siswa();
                    break;
                case 2:
                    guru();
                    break;
                default:
                    System.out.println("Pilihan Anda Salah!!!");
                    break;
            }
            
            
        } while(pilMain != 3);
    }
    
    //Section Siswa
    public void siswa(){
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
    
    //Section Guru
    public void guru(){
        int selectMenu, nip;
        do{
            System.out.println("===Manajemen Guru===");
            System.out.println("[1] Lihat Guru");
            System.out.println("[2] Edit Guru");
            System.out.println("[3] Tambah Guru");
            System.out.println("[4] Hapus Guru");
            System.out.println("[0] Kembali");
            System.out.println("======================");
            System.out.print("Pilihan: ");

            selectMenu = input.nextInt();
            input.nextLine();

            switch(selectMenu){
                case 1:
                    readGuru();
                    break;

                case 2:
                    System.out.println("Masukan NIP: ");
                    nip = input.nextInt();
                    updateGuru(nip);
                    break;

                case 3:
                    addGuru();
                    break;

                case 4:
                    System.out.println("Masukkan NIP: (Jika hapus semua data masukkan 0) ");
                    nip = input.nextInt();
                    deleteGuru(nip);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Salah Menu!!!");
                   // backToMenu();
                    break;
            }
        }while(selectMenu!=5);
    }
    public void addGuru() {
        System.out.print("Masukkan Nama: ");
        String nama = input.next();
        System.out.print("Masukkan NIK: ");
        String nik = input.next();
        System.out.print("Masukkan NIP: ");
        int nip = input.nextInt();
        System.out.print("Masukkan NUPTK: ");
        int  nuptk = input.nextInt();
        System.out.print("Jenis Kelamin: ");
        String JK = input.next();
        System.out.print("Masukkan Kelas: ");
        String kelas = input.next();
        
        dataGuru.add(new Guru(nama, nik, nip, nuptk, kelas));
    }

    public void updateGuru(int nip) {
        for(int i = 0; i < dataGuru.size(); i++) {
            if(dataGuru.get(i).getNIP() == nip) {
                System.out.println("============");
                System.out.println("Nama: " + dataGuru.get(i).getNama());
                System.out.println("NIK: "+ dataGuru.get(i).getNIK());
                System.out.println("NIP: " + dataGuru.get(i).getNIP());
                System.out.println("NUPTK: " + dataGuru.get(i).getNUPTK());
                System.out.println("============");
                
                System.out.print("Masukkan Nama: ");
                String nama = input.next();
                System.out.print("Masukkan NIK: ");
                String nik = input.next();
                System.out.print("Masukkan NIP: ");
                int nipNEW = input.nextInt();
                System.out.print("Masukkan NUPTK: ");
                int  nuptk = input.nextInt();
                System.out.print("Masukkan kelas: ");
                String kelas = input.next();

                // Menggunakan add karena user harus menginputkan kembali semua data
                dataGuru.set(i, new Guru(nama, nik, nipNEW, nuptk, kelas));
            }
        }
        
    }

    public void readGuru() {
        for(int i = 0; i < dataGuru.size(); i++) {
            System.out.println("============");
            System.out.println("Nama: " + dataGuru.get(i).getNama());
            System.out.println("NIK: "+ dataGuru.get(i).getNIK());
            System.out.println("NIP: " + dataGuru.get(i).getNIP());
            System.out.println("NUPTK: " + dataGuru.get(i).getNUPTK());
            System.out.println("Kelas: "+ dataGuru.get(i).getKelas()+ " [ " + dataGuru.get(i).getJadwalKelas() + " ]");
            System.out.println("============");
        }
    }

    public void deleteGuru(int nip) {
        if(nip == 0) {
            dataGuru.clear();
            System.out.println("Data berhasil dihapus");
        } else {
            for(int i = 0; i < dataGuru.size(); i++) {
                if(dataGuru.get(i).getNIP() == nip) {
                    System.out.println("Data Guru milik: " + dataGuru.get(i).getNama() + " berhasil terhapus");
                    dataGuru.remove(i);
                }
            }
        }
    }
}
