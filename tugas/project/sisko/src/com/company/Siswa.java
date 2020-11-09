package com.company;

import java.util.Scanner;

public class Siswa extends Auth {
    protected String nama;
    protected int nis;
    protected String kelas;
    protected String username;
    protected String password;
    protected String email;

    public Siswa(String nama, String kelas, int nis, String username, String password) {
        super(username, password);
        this.nama = nama;
        this.kelas = kelas;
        this.nis = nis;
    }

//    void addUser() {
//        Auth auth = new Auth(username, password);
//        auth.save();
//    }
//
//    void doLogin() {
//        Auth auth = new Auth(username, password);
//        auth.login();
//    }

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
