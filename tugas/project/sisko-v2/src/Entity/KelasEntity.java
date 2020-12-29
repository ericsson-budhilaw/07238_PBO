package Entity;

import java.util.HashMap;

public class KelasEntity {
    public HashMap<String, String> dataKelas = new HashMap<>();

    public KelasEntity() {
        dataKelas.put("V", "Matematika");
        dataKelas.put("Q", "Fisika");
        dataKelas.put("R", "Biologi");
    }

    public String getNama(String kode) {
        return dataKelas.getOrDefault(kode, "Data kelas tidak tersedia");
    }
}
