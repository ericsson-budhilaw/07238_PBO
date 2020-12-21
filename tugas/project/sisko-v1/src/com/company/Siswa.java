package com.company;

public class Siswa extends Person {
    protected String nama;
    protected String alamt;
    protected int nis;
    protected Kelas kelas;

    public Siswa(int nis) {
        this.nama   = super.nama;
        this.alamt  = super.alamat;
        this.nis    = nis;
        kelas       = null;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNIS() {
        return this.nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }
}