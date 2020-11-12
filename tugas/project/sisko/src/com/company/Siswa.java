package com.company;

public class Siswa extends Kelas {
    protected String nama;
    protected int nis;
    protected String mKelas;

    Kelas kelas = new Kelas();

    public Siswa(String nama, String mKelas, int nis) {
        this.nama = nama;
        this.mKelas = mKelas;
        this.nis = nis;
    }

    String getNama() {
        return this.nama;
    }

    int getNIS() {
        return this.nis;
    }

    String getKelas() {
        return this.mKelas;
    }

    String getJadwalKelas() {
        return kelas.cekTipe(mKelas);
    }
}