package Controller;

import Entity.Eric07238_AslabEntity;
import Model.Eric07238_AslabModel;

public class Eric07238_AslabController {

    private Eric07238_AslabModel aslabModel = new Eric07238_AslabModel();

    public int maxData() {
        return aslabModel.getMax();
    }

    public Eric07238_AslabEntity getDataByKode(String kode) {
        return aslabModel.getDataByKode(kode);
    }

    public Eric07238_AslabEntity view(int index) {
        return aslabModel.getDataByIndex(index);
    }
}
