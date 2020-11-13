package com.company;

public class Siswa {
    protected String nama;
    protected int nis;
    protected String kelas;

    public Siswa(String nama, String kelas, int nis) {
        this.nama = nama;
        this.kelas = kelas;
        this.nis = nis;
    }

    String getNama() {
        return this.nama;
    }

    int getNIS() {
        return this.nis;
    }

    String getKelas() {
        return this.kelas;
    }
}