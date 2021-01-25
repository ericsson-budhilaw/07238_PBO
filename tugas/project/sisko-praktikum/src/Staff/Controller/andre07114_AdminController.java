package Staff.Controller;

import Staff.Entity.andre07114_AdminEntity;
import Staff.Model.andre07114_AdminModel;

public class andre07114_AdminController {

    private andre07114_AdminModel adminModel = new andre07114_AdminModel();

    public int maxData() {
        return adminModel.getMax();
    }

    public andre07114_AdminEntity getDataByNpk(String npk) {
        return adminModel.getDataByNpk(npk);
    }

    public andre07114_AdminEntity view(int index) {
        return adminModel.getDataByIndex(index);
    }
}