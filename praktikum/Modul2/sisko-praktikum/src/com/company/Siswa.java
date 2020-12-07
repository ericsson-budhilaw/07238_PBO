package com.company;

public class Siswa extends Kelas {
    protected String nama;
    protected int nis;
    protected String kelas;

    public Siswa(String nama, String kelas, int nis) {
        super(null, nama);
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

    @Override
    public String cekTipe(String kelas) {
        return jadwal.getOrDefault(kelas, "Jadwal belum tersedia.");
    }
}