package Project;

import Controller.Eric07238_AslabController;
import Controller.Eric07238_KelasController;
import Controller.Eric07238_SiswaController;
import Entity.Eric07238_SiswaEntity;
import GUI.Eric07238_GUI;
import Model.Eric07238_SiswaModel;

import java.util.Scanner;

/*
 * MainCLI
 * Run the program in CLI (Command Line Interface)
 *
 * @author: Ericsson Budhilaw
 */

public class Eric07238_MainCLI {
    /* Menerapkan Controller pada main */
    private Eric07238_SiswaController siswaController = new Eric07238_SiswaController();
    private Eric07238_AslabController aslabController = new Eric07238_AslabController();
    private Eric07238_KelasController kelasController = new Eric07238_KelasController();

    private Eric07238_SiswaModel siswaModel   = new Eric07238_SiswaModel();
    private Scanner input;

    public static void main(String[] args) {
        Eric07238_MainCLI m = new Eric07238_MainCLI();
        m.menu();
    }

    public void menu() {
        input = new Scanner(System.in);
        int selectedMenu, nis, max;

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
                    System.out.println("Masukkan NIS: ");
                    nis = input.nextInt();

                    delete(nis);
                    break;
                case 5:
                    max = kelasController.maxData();
                    if(max > 0) {
                        System.out.println("------------------------------------");
                        System.out.println("Daftar Kelas yang tersedia: ");
                        System.out.println("------------------------------------");
                        for(int i = 0; i < max; i++) {
                            System.out.println("Pelajaran: " + kelasController.view(i).getNama());
                            System.out.println("Kode: " + kelasController.view(i).getKode());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Data masih kosong");
                    }
                    break;
                case 6:
                    max = aslabController.maxData();
                    if(max > 0) {
                        System.out.println("------------------------------------");
                        System.out.println("Daftar Asisten Lab yang tersedia: ");
                        System.out.println("------------------------------------");
                        for(int i = 0; i < max; i++) {
                            System.out.println("Nama: " + aslabController.view(i).getNama());
                            System.out.println("Kode: " + aslabController.view(i).getKode());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Data masih kosong");
                    }
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Anda salah memilih menu!");
            }
        } while(selectedMenu != 7);
    }

    public void add() {
        try {
            System.out.println("Masukan nama: ");
            String nama = input.next();
            System.out.println("Masukan Kelas: ");
            String kelas = input.next();
            System.out.println("Masukan NIS: ");
            int nis = input.nextInt();
            String msg = siswaController.insert(new Eric07238_SiswaEntity(nis, nama, kelas));

            System.out.println("------------------------------------");
            System.out.println(msg);
            System.out.println("------------------------------------");
        } catch(Exception e) {
            System.out.println("------------------------------------");
            System.out.println("Silahkan coba lagi.");
            System.out.println("------------------------------------");
        }
    }

    public void read() {
        int max = siswaController.maxData();
        if(max > 0) {
            System.out.println("------------------------------------");
            System.out.println("Daftar Data Siswa:");
            System.out.println("------------------------------------");
            for(int i = 0; i < max; i++) {
                System.out.println("Nama: " + siswaController.view(i).getNama());
                System.out.println("NIS: " + siswaController.view(i).getNis());
                System.out.println("Kelas: " + siswaController.view(i).getKelas());
                System.out.println("Asisten: " + aslabController.getDataByKode(siswaController.view(i).getKelas()).getNama());
                System.out.println("Pelajaran: " + kelasController.getDataByKode(siswaController.view(i).getKelas()).getNama());
                System.out.println("------------------------------------");
            }
        } else {
            System.out.println("------------------------------------");
            System.out.println("Data masih kosong");
            System.out.println("------------------------------------");
        }
    }

    public void update(int nis) {
        int result = siswaController.cekData(nis);

        if(result == -1) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa masih kosong");
            System.out.println("------------------------------------");
        } else if(result == -2) {
            System.out.println("------------------------------------");
            System.out.println("Data siswa tidak ditemukan / NIS salah.");
            System.out.println("------------------------------------");
        } else {
            Eric07238_SiswaEntity siswa = siswaController.view(result);

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

            String msg = siswaController.update(new Eric07238_SiswaEntity(nisBaru, nama, kelas), siswa.getNis());

            System.out.println("------------------------------------");
            System.out.println(msg);
            System.out.println("------------------------------------");
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