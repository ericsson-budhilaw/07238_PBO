package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Kelas {
    public String kelas;
    public HashMap<String, String> jadwal = new HashMap<String, String>();

    public Kelas() {
        jadwal.put("V", "Malam");
        jadwal.put("W", "Malam");
        jadwal.put("Q", "Pagi");
    }

    /*
     * Cek tipe kelas (Pagi atau Malam)
     */
    public String cekTipe(String kelas) {
        return jadwal.getOrDefault(kelas, "Jadwal Salah");
    }
}
