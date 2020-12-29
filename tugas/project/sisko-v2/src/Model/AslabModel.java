package Model;

import Entity.AslabEntity;
import java.util.Map;

/*
 * Relasi pertama, Realization
 * AslabModel dengan ModelInterface
 */

public class AslabModel implements ModelInterface {
    private AslabEntity aslabEntity;

    public AslabModel() {
        aslabEntity = new AslabEntity();
    }

    @Override
    public void view() {
        if(aslabEntity.dataAslab.size() > 0) {
            for(Map.Entry kelas : aslabEntity.dataAslab.entrySet()) {
                System.out.println("------------");
                System.out.println("Kode: " + kelas.getKey());
                System.out.println("Nama Aslab: " + kelas.getValue());
                System.out.println("------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }
}
