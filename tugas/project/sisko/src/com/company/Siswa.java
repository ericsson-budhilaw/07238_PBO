package com.company;

import java.util.Scanner;

public class Siswa extends Auth {
    protected String nama;
    protected int nis;
    protected String kelas;

    public Siswa(String nama, String kelas, int nis, String username, String password) {
        super(username, password);
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