package Entity;

import java.util.HashMap;

public class AslabEntity {
    public HashMap<String, String> dataAslab = new HashMap<>();

    public AslabEntity() {
        dataAslab.put("V", "Raka");
        dataAslab.put("W", "Doni");
        dataAslab.put("Q", "Yanuar");
    }

    public String getNama(String kode) {
        return dataAslab.getOrDefault(kode, "Data aslab tidak tersedia");
    }
}

