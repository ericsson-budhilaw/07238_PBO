package com.company;

import java.util.HashMap;

abstract class Kelas {
    public HashMap<String, String> jadwal = new HashMap<>();
    public String nama, kode;

    public Kelas(String kode, String nama) {
        jadwal.put("V", "Matematika");
        jadwal.put("Q", "Fisika");
        jadwal.put("R", "Biologi");
    }

    public void addKelas(String kode, String nama) {
        //jadwal.put(kode, nama);
        Siswa siswa = new Siswa(null, null, 0);
        siswa.addKelas(kode, nama);
    }

    public abstract String cekTipe(String kelas);
}
