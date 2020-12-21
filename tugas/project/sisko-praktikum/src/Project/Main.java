package Project;

import Entity.SiswaEntity;
import Model.AslabModel;
import Model.KelasModel;
import Model.SiswaModel;

import java.util.Scanner;

public class Main {

    private SiswaModel siswaModel   = new SiswaModel();
    private KelasModel kelasModel   = new KelasModel();
    private AslabModel aslabModel   = new AslabModel();
    private Scanner input;

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
            System.out.println("==== Manajemen Data Kelas ====");
            System.out.println("[5] Lihat data");
            System.out.println("==== Manajemen Data Asisten Lab ====");
            System.out.println("[6] Lihat data");
            System.out.println("[7] Exit Program");
            System.out.println("--------------------");
            System.out.print("Pilih menu> ");

            selectedMenu = input.nextInt();

            switch (selectedMenu) {
                case 1:
                    siswaModel.view();
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
                    System.out.println("Masukkan NIS: ");
                    nis = input.nextInt();

                    delete(nis);
                    break;
                case 5:
                    System.out.println("------------------------------------");
                    System.out.println("Daftar Kelas yang tersedia: ");
                    kelasModel.view();
                    System.out.println("------------------------------------");
                    break;
                case 6:
                    System.out.println("------------------------------------");
                    System.out.println("Daftar Asisten Lab yang tersedia: ");
                    aslabModel.view();
                    System.out.println("------------------------------------");
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Anda salah memilih menu!");
            }
        } while(selectedMenu != 7);
    }

    public void add() {
        System.out.println("Masukan nama: ");
        String nama = input.next();
        System.out.println("Masukan Kelas: ");
        String kelas = input.next();
        System.out.println("Masukan NIS: ");
        int nis = input.nextInt();

        siswaModel.insert(new SiswaEntity(nis, nama, kelas));
    }

    public void update(int nis) {
        int result = siswaModel.cekData(nis);

        if(result == -1) {
            System.out.println("Data siswa masih kosong");
        } else if(result == -2) {
            System.out.println("Data siswa tidak ditemukan / NIS salah.");
        } else {
            SiswaEntity siswa = siswaModel.showDataSiswa(result);

            System.out.println("--------------------");
            System.out.println("Nama: " + siswa.getNama());
            System.out.println("NIS: " + siswa.getNis());
            System.out.println("Kelas: " + siswa.getKelas());
            System.out.println("--------------------");

            System.out.println("Masukan nama: ");
            String nama = input.next();
            System.out.println("Masukan Kelas: ");
            String kelas = input.next();
            System.out.println("Masukan NIS: ");
            int nisBaru = input.nextInt();

            siswaModel.update(new SiswaEntity(nisBaru, nama, kelas), siswa.getNis());
        }
    }

    public void delete(int nis) {
        int result = siswaModel.delete(nis);
        if(result != 0) {
            System.out.println("Gagal menghapus data, NIS salah.");
        } else {
            System.out.println("Data berhasil terhapus");
        }
    }
}