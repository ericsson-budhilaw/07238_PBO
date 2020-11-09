package com.company;

import java.util.Scanner;

public class Ericsson07238_SiswaEntity {
    protected String Ericsson07238_nama;
    protected int Ericsson07238_nis;
    protected String Ericsson07238_kelas;

    static Scanner input;

    public Ericsson07238_SiswaEntity(String nama, String kelas, int nis) {
        input = new Scanner(System.in);
        this.Ericsson07238_nama = nama;
        this.Ericsson07238_kelas = kelas;
        this.Ericsson07238_nis = nis;
    }

    String getNama() {
        return this.Ericsson07238_nama;
    }

    int getNIS() {
        return this.Ericsson07238_nis;
    }

    String getKelas() {
        return this.Ericsson07238_kelas;
    }
}
