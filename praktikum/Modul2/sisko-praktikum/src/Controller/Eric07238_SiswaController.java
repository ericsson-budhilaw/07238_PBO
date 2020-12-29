package Controller;

import Entity.Eric07238_SiswaEntity;
import Model.Eric07238_SiswaModel;

public class Eric07238_SiswaController {

    private Eric07238_SiswaModel siswaModel = new Eric07238_SiswaModel();

    public int maxData() {
        return siswaModel.getMax();
    }

    public Eric07238_SiswaEntity view(int index) {
        return siswaModel.getData(index);
    }

    public String insert(Eric07238_SiswaEntity siswaEntity) {
        boolean result = siswaModel.insert(siswaEntity);
        if(result) {
            return "Data berhasil dimasukkan !";
        }

        return "Data gagal dimasukkan";
    }

    public String update(Eric07238_SiswaEntity siswaEntity, int nisLama) {
        boolean result = siswaModel.update(siswaEntity, nisLama);
        if(result) {
            return "Data berhasil diedit !";
        }

        return "Data gagal diedit";
    }

    public int cekData(int nis) {
        return siswaModel.cekData(nis);
    }
}

