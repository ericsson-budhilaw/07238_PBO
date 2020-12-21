package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Update git
    public ArrayList<Siswa> dataSiswa   = new ArrayList();
    public ArrayList<Kelas> dataKelas   = new ArrayList();
    public Scanner input;

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        init();

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
        String selectedKelas;

        System.out.println("Masukan Nama: ");
        String nama = input.next();

        System.out.println("Masukan Alamat: ");
        String alamat = input.next();

        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        System.out.println("Pilih Kelas yang diikuti: ");
        for(int i = 0; i < dataKelas.size(); i++) {
            System.out.print("[" + dataKelas.get(i).kode + "] ");
            System.out.print(dataKelas.get(i).kelas + "\n");
        }
        System.out.print("Masukkan kode kelas yang dipilih: ");
        selectedKelas = input.next();

        Siswa siswa = new Siswa(nis);

        for(int i = 0; i < dataKelas.size(); i++) {
            if(dataKelas.get(i).kode.equals(selectedKelas)) {
                Kelas kelas = new Kelas(dataKelas.get(i).kode, dataKelas.get(i).kelas);

                dataKelas.get(i).setSiswa(siswa);
                siswa.setKelas(kelas);
            }
        }

        siswa.setNama(nama);
        siswa.setAlamat(alamat);
        dataSiswa.add(siswa);
    }

    public void update(int nis) {
        for(int i = 0; i < dataSiswa.size(); i++) {
            if(dataSiswa.get(i).getNIS() == nis) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataSiswa.get(i).getNama());
                System.out.println("NIS: " + dataSiswa.get(i).getNIS());
                System.out.println("--------------------");

                System.out.println("Masukan nama: ");
                String nama = input.next();
                System.out.println("Masukan Alamat: ");
                String alamat = input.next();
                System.out.println("Masukan NIS: ");
                int nisBaru = input.nextInt();

                dataSiswa.get(i).setNama(nama);
                dataSiswa.get(i).setAlamat(alamat);
                dataSiswa.get(i).setNis(nisBaru);
            }
        }
    }

    public void read() {
        if(dataSiswa.size() > 0) {
            for (int i = 0; i < dataSiswa.size(); i++) {
                System.out.println("--------------------");
                System.out.println("Nama: " + dataSiswa.get(i).getNama());
                System.out.println("Alamat: " + dataSiswa.get(i).getAlamat());
                System.out.println("NIS: " + dataSiswa.get(i).getNIS());

                if(dataSiswa.get(i).kelas == null) {
                    System.out.println("Kelas: -");
                } else {
                    System.out.println("Kelas: " + dataSiswa.get(i).kelas.kelas + " [ " + dataSiswa.get(i).kelas.kode + " ]");
                }

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

    public void init() {
        dataKelas.add(new Kelas("MTK", "Matematika"));
        dataKelas.add(new Kelas("FIS", "Fisika"));
        dataKelas.add(new Kelas("BIO", "Biologi"));
    }
}