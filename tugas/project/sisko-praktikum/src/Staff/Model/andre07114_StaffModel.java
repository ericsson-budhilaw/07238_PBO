package Staff.Model;

import Staff.Entity.andre07114_Staff;
import java.util.ArrayList;

public class andre07114_StaffModel {
    private ArrayList<andre07114_Staff> SiswaArrayList = new ArrayList<>();

    public andre07114_StaffModel() {
        SiswaArrayList  = new ArrayList<andre07114_Staff>();
    }

    public andre07114_Staff getData(int index) {
        return SiswaArrayList.get(index);
    }

    public andre07114_Staff getDataByNpk(int npk) {
        for(andre07114_Staff siswa : SiswaArrayList) {
            if(siswa.getNpk() == npk) {
                return siswa;
            }
        }
        return null;
    }

    public int getMax() {
        return SiswaArrayList.size();
    }

    public boolean insert(andre07114_Staff siswaEntity) {
        SiswaArrayList.add(siswaEntity);
        if(SiswaArrayList.contains(siswaEntity)) {
            return true;
        }
        return false;
    }

    public boolean update(andre07114_Staff newEric07238SiswaEntity, int npkLama) {
        for(int i = 0; i < SiswaArrayList.size(); i++) {
            if(SiswaArrayList.get(i).getNpk() == npkLama) {
                SiswaArrayList.set(i, newEric07238SiswaEntity);
                return true;
            }
        }
        return false;
    }

    public int delete(int npk) {
        int index = cekData(npk);
        if(index != -1 && index != -2) {
            SiswaArrayList.remove(index);
            return 0;
        }

        return index;
    }

    public int cekData(int npk) {
        int index = 0;
        if(SiswaArrayList.size() == 0) {
            index = -1;
        } else {
            for(int i = 0; i < SiswaArrayList.size(); i++) {
                if(SiswaArrayList.get(i).getNpk() == npk) {
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
