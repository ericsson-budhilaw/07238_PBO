package Model;

import Entity.AslabEntity;
import Entity.KelasEntity;
import Entity.SiswaEntity;

import java.util.ArrayList;

/*
 * Relasi ketiga, Realization
 * SiswaModel dengan ModelInterface
 */

public class SiswaModel implements ModelInterface {
    private ArrayList<SiswaEntity> SiswaArrayList;
    private AslabEntity aslabEntity;
    private KelasEntity kelasEntity;

    public SiswaModel() {
        SiswaArrayList  = new ArrayList<SiswaEntity>();
        aslabEntity     = new AslabEntity();
        kelasEntity     = new KelasEntity();
    }

    public void insert(SiswaEntity siswaEntity) {
        SiswaArrayList.add(siswaEntity);
    }

    public void update(SiswaEntity newSiswaEntity, int nisLama) {
        for(int i = 0; i < SiswaArrayList.size(); i++) {
            if(SiswaArrayList.get(i).getNis() == nisLama) {
                SiswaArrayList.set(i, newSiswaEntity);
                break;
            }
        }
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

    public SiswaEntity showDataSiswa(int index) {
        return SiswaArrayList.get(index);
    }

    @Override
    public void view() {
        if(SiswaArrayList.size() > 0) {
            for(SiswaEntity siswaEntity : SiswaArrayList) {
                System.out.println("------------");
                System.out.println("Nama: " + siswaEntity.getNama());
                System.out.println("NIS: " + siswaEntity.getNis());
                System.out.println("Kelas: " + siswaEntity.getKelas() + " [ " + kelasEntity.getNama(siswaEntity.getKelas()) + " ]");
                System.out.println("Aslab: " + aslabEntity.getNama(siswaEntity.getKelas()));
                System.out.println("------------");
            }
        } else {
            System.out.println("Belum ada data.");
        }
    }
}
