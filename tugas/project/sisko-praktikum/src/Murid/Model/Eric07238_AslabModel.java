package Murid.Model;

import Murid.Entity.Eric07238_AslabEntity;

import java.util.ArrayList;

public class Eric07238_AslabModel {
    public ArrayList<Eric07238_AslabEntity> aslabEntity = new ArrayList<>();

    public Eric07238_AslabModel() {
        aslabEntity.add(new Eric07238_AslabEntity("Rusman", "Q"));
        aslabEntity.add(new Eric07238_AslabEntity("Yudi", "V"));
        aslabEntity.add(new Eric07238_AslabEntity("Rudi", "W"));
    }

    public Eric07238_AslabEntity getDataByKode(String kode) {
        for(Eric07238_AslabEntity aslab : aslabEntity) {
            if(aslab.getKode().equals(kode)) {
                return aslab;
            }
        }
        return null;
    }

    public Eric07238_AslabEntity getDataByIndex(int index) {
        return aslabEntity.get(index);
    }

    public int getMax() {
        return aslabEntity.size();
    }
}
