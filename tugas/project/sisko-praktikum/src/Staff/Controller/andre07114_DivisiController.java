package Staff.Controller;

import Staff.Entity.andre07114_DivisiEntity;
import Staff.Model.andre07114_DivisiModel;

public class andre07114_DivisiController {

    private andre07114_DivisiModel divisiModel = new andre07114_DivisiModel();

    public int maxData() {
        return divisiModel.getMax();
    }

    public andre07114_DivisiEntity getDataByKode(String kode) {
        return divisiModel.getDataByKode(kode);
    }

    public andre07114_DivisiEntity getDataByIndex(int index) {
        return divisiModel.getDataByIndex(index); }

    public andre07114_DivisiEntity view(int index) {
        return divisiModel.getDataByIndex(index);
    }
}