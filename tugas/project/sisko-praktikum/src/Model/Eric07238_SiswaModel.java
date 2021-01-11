package Model;

import Entity.Eric07238_KelasEntity;
import Entity.Eric07238_SiswaEntity;

import java.util.ArrayList;

public class Eric07238_SiswaModel {
    private ArrayList<Eric07238_SiswaEntity> SiswaArrayList = new ArrayList<>();

    public Eric07238_SiswaModel() {
        SiswaArrayList  = new ArrayList<Eric07238_SiswaEntity>();
    }

    public Eric07238_SiswaEntity getData(int index) {
        return SiswaArrayList.get(index);
    }

    public Eric07238_SiswaEntity getDataByNis(int nis) {
        for(Eric07238_SiswaEntity siswa : SiswaArrayList) {
            if(siswa.getNis() == nis) {
                return siswa;
            }
        }
        return null;
    }

    public int getMax() {
        return SiswaArrayList.size();
    }

    public boolean insert(Eric07238_SiswaEntity siswaEntity) {
        SiswaArrayList.add(siswaEntity);
        if(SiswaArrayList.contains(siswaEntity)) {
            return true;
        }

        return false;
    }

    public boolean update(Eric07238_SiswaEntity newEric07238SiswaEntity, int nisLama) {
        for(int i = 0; i < SiswaArrayList.size(); i++) {
            if(SiswaArrayList.get(i).getNis() == nisLama) {
                SiswaArrayList.set(i, newEric07238SiswaEntity);
                return true;
            }
        }
        return false;
    }

    public int delete(int nis) {
        int index = cekData(nis);
        if(index != -1 && index != -2) {
            SiswaArrayList.remove(index);
            return 0;
        }

        return index;
    }

    public int cekData(int nis) {
        int index = 0;
        if(SiswaArrayList.size() == 0) {
            index = -1;
        } else {
            for(int i = 0; i < SiswaArrayList.size(); i++) {
                if(SiswaArrayList.get(i).getNis() == nis) {
                    index = i;
                    break;
                } else {
                    index = -2;
                }
            }
        }
        return index;
    }
}
