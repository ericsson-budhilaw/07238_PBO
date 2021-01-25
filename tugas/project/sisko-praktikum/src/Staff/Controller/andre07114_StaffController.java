package Staff.Controller;

import Staff.Entity.andre07114_Staff;
import Staff.Model.andre07114_StaffModel;

public class andre07114_StaffController {

    private andre07114_StaffModel staffModel = new andre07114_StaffModel();

    public int maxData() {
        return staffModel.getMax();
    }
    public andre07114_Staff getDataByNis(int npk) {
        return staffModel.getDataByNpk(npk); }

    public andre07114_Staff view(int index) {
        return staffModel.getData(index);
    }

    public String insert(andre07114_Staff staffEntity) {
        boolean result = staffModel.insert(staffEntity);
        if(result) {
            return "data berhasil dimasukkan !";
        }
        return "data gagal dimasukkan";
    }

    public String update(andre07114_Staff staffEntity, int npkLama) {
        boolean result = staffModel.update(staffEntity, npkLama);
        if(result) {
            return "data berhasil diedit !";
        }

        return "data gagal diedit";
    }

    public int delete(int npk) {
        return staffModel.delete(npk); }

    public int cekData(int npk) {
        return staffModel.cekData(npk);
    }
}