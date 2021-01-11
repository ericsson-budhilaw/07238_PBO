package Controller;

import Entity.Eric07238_KelasEntity;
import Model.Eric07238_KelasModel;

public class Eric07238_KelasController {

    private Eric07238_KelasModel kelasModel = new Eric07238_KelasModel();

    public int maxData() {
        return kelasModel.getMax();
    }

    public Eric07238_KelasEntity getDataByKode(String kode) {
        return kelasModel.getDataByKode(kode);
    }

    public Eric07238_KelasEntity getDataByIndex(int index) { return kelasModel.getDataByIndex(index); }

    public Eric07238_KelasEntity view(int index) {
        return kelasModel.getDataByIndex(index);
    }
}
