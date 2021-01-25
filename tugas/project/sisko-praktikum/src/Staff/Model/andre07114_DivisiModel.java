package Staff.Model;

import Staff.Entity.andre07114_DivisiEntity;

import java.util.ArrayList;

public class andre07114_DivisiModel {
    public ArrayList<andre07114_DivisiEntity> divisiEntity = new ArrayList<>();

    public andre07114_DivisiModel() {
        divisiEntity.add(new andre07114_DivisiEntity("CS", "Cleaning Service"));
        divisiEntity.add(new andre07114_DivisiEntity("SDM", "Sumber daya Manusia"));
        divisiEntity.add(new andre07114_DivisiEntity("KASIR", "KEUANGAN"));
        divisiEntity.add(new andre07114_DivisiEntity("TEKNISI", "Teknisi"));
    }

    public andre07114_DivisiEntity getDataByKode(String kode) {
        for(andre07114_DivisiEntity divisi : divisiEntity) {
            if(divisi.getCode().equals(kode)) {
                return divisi;
            }
        }
        return null;
    }

    public andre07114_DivisiEntity getDataByIndex(int index) {
        return divisiEntity.get(index);
    }

    public int getMax() {
        return divisiEntity.size();
    }
}
