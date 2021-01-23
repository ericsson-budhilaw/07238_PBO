package Project;

import Guru.Controller.Dimas07146_GuruController;
import Guru.Entity.Dimas07146_GuruEntity;
import Guru.Model.Dimas07146_GuruModel;


import java.util.Scanner;

public class Dimas07146_MainCLI {

    private Dimas07146_GuruController guruController = new Dimas07146_GuruController();
    private Dimas07146_GuruModel guruModel = new Dimas07146_GuruModel();
    private Scanner input;

    public static void main(String[] args) {
        Dimas07146_MainCLI main = new Dimas07146_MainCLI();
        main.menu();
    }

    private void menu() {
        input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("PROGRAM SISTEM INFORMASI SEKOLAH");
            System.out.println("Menu: ");
            System.out.println("1. Tambah Guru");
            System.out.println("2. Edit Guru");
            System.out.println("3. Hapus Guru");
            System.out.println("4. Lihat Data Guru");
            System.out.print("Masukkan Pilihan: ");
            pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    add();
                    break;
                case 2:
                    System.out.print("Masukkan NIP: ");
                    String IDNum = input.next();
                    update(IDNum);
                    break;
                case 3:
                    System.out.print("Masukkan NIP: ");
                    IDNum = input.next();
                    delete(IDNum);
                    break;
                case 4:
                    view();
                    break;
            }

        }while (pilihan != 5);
    }


    public void add(){
        try {
            System.out.print("Masukkan Nama: ");
            String nama = input.next();
            System.out.print("Masukkan NIK: ");
            String NIK = input.next();
            System.out.print("Masukkan NIP: ");
            String NIP = input.next();
            String msg = guruController.insert(new Dimas07146_GuruEntity(nama, NIP, NIK, null));

            System.out.println("=============");
            System.out.println(msg);
            System.out.println("=============");
        }
        catch (Exception e){
            System.out.println("=============");
            System.out.println("Silahkan Coba Lagi");
            System.out.println("=============");
        }
    }

    public void update(String IDNum){
        int result = guruController.cekData(IDNum);

        if (result == -1){
            System.out.println("Data Masih Kosong / IDNum Salah !!!");
        }
        else if (result == -2){
            System.out.println("Data Tidak Ditemukan");
        }
        else {
            Dimas07146_GuruEntity guru = guruController.view(result);

            //menampilkan data yang ditemukan
            System.out.println("============");
            System.out.println("Nama = " + guru.getNama());
            System.out.println("NIK = " + guru.getNIK());
            System.out.println("NIP = " + guru.getNIP());
            System.out.println("IDNumber = " + guru.getIDNum());

            //mengimputkan data baru
            System.out.print("Masukkan Nama: ");
            String nama = input.next();
            System.out.print("Masukkan NIK: ");
            String NIKbaru = input.next();
            System.out.print("Masukkan NIP: ");
            String NIP = input.next();

            String msg = guruController.update(new Dimas07146_GuruEntity(nama, NIP, NIKbaru, null), guru.getIDNum());

            System.out.println("===============");
            System.out.println(msg);
            System.out.println("===============");
        }
    }

    public void view(){
        int max = guruController.maxData();
        if (max > 0){
            System.out.println("============");
            System.out.println("Daftar Data Guru :");
            System.out.println("============");
            for (int i=0; i<max; i++){
                System.out.println("Nama: " + guruController.view(i).getNama());
                System.out.println("NIP: " + guruController.view(i).getNIP());
                System.out.println("NIK: " + guruController.view(i).getNIK());
                System.out.println("IDNum: " + guruController.view(i).getIDNum());
                System.out.println("------------------------------");
            }
        }
        else {
            System.out.println("==============");
            System.out.println("Data Kosong !");
            System.out.println("==============");
        }
    }

    public void delete(String NIP) {
        int result = guruController.hapusData(NIP);
        if (result == -1){
            System.out.println("Data Kosong !");
        }
        else if (result == -2){
            System.out.println("Data Gagal Dihapus, NIK Tidak Ditemukan !!!");
        }
        else {
            System.out.println("Data Berhasil Dihapus");
        }
    }

}
