package com.company;

import java.util.Scanner;


public class Guru extends Kelas{
    protected String Nama, NIK, mKelas;
    protected int NIP, NUPTK;    
    Kelas kelas = new Kelas();
    
    public Guru(String Nama, String NIK, int NIP, int NUPTK, String mKelas){
        this.Nama = Nama;
        this.NIK = NIK;
        this.NIP = NIP;
        this.NUPTK = NUPTK;
        this.mKelas = mKelas;
    }
    
    public String getNama() {
        return Nama;
    }
    public String getNIK(){
        return NIK;
    }
    public int getNIP(){
        return NIP;
    }
    public int getNUPTK(){
        return NUPTK;
    }
    public String getKelas(){
        return mKelas;
    }
    String getJadwalKelas() {
    return kelas.cekTipe(mKelas);
    }
}
