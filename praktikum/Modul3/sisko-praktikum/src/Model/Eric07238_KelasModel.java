package Model;

import Entity.Eric07238_KelasEntity;

import java.util.ArrayList;

public class Eric07238_KelasModel {
    public ArrayList<Eric07238_KelasEntity> kelasEntity = new ArrayList<>();

    public Eric07238_KelasModel() {
        kelasEntity.add(new Eric07238_KelasEntity("Biologi", "Q"));
        kelasEntity.add(new Eric07238_KelasEntity("Fisika", "V"));
        kelasEntity.add(new Eric07238_KelasEntity("Kimia", "W"));
    }

    public Eric07238_KelasEntity getDataByKode(String kode) {
        for(Eric07238_KelasEntity kelas : kelasEntity) {
            if(kelas.getKode().equals(kode)) {
                return kelas;
            }
        }
        return null;
    }

    public Eric07238_KelasEntity getDataByIndex(int index) {
        return kelasEntity.get(index);
    }

    public int getMax() {
        return kelasEntity.size();
    }
}
