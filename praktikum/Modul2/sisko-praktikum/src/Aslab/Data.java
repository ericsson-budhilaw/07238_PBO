package Aslab;

import java.util.HashMap;

public class Data {
    public HashMap<String, String> dataAslab = new HashMap<>();

    public Data() {
        dataAslab.put("V", "Raka");
        dataAslab.put("W", "Doni");
        dataAslab.put("Q", "Yanuar");
    }

    public String cekAslab(String kelas) {
        return dataAslab.getOrDefault(kelas, "Data aslab tidak tersedia");
    }
}
