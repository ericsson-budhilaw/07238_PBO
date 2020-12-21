package com.company;

public class Kelas {
    public String kode;
    public String kelas;
    public Siswa siswa;

    public Kelas(String kode, String kelas) {
        this.kode = kode;
        this.kelas = kelas;
        siswa = null;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }
}
