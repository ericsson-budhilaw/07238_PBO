package Model;

import Entity.KelasEntity;
import java.util.Map;

/*
 * Relasi kedua, Realization
 * KelasModel dengan ModelInterface
 */

public class KelasModel implements ModelInterface {
    private KelasEntity kelasEntity;

    public KelasModel() {
        kelasEntity = new KelasEntity();
    }

    @Override
    public void view() {
        if(kelasEntity.dataKelas.size() > 0) {
            for(Map.Entry kelas : kelasEntity.dataKelas.entrySet()) {
                System.out.println("------------");
                System.out.println("Kode: " + kelas.getKey());
                System.out.println("Kelas: " + kelas.getValue());
                System.out.println("------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }
}
