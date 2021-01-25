package Staff.Model;

import Staff.Entity.andre07114_AdminEntity;
import java.util.ArrayList;

public class andre07114_AdminModel {
    public ArrayList<andre07114_AdminEntity> adminEntity = new ArrayList<>();

    public andre07114_AdminModel() {
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian1"));
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian2"));
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian3"));
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian4"));
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian5"));
        adminEntity.add(new andre07114_AdminEntity("staff", "bagian6"));
    }

    public andre07114_AdminEntity getNPK(String npk) {
        for(andre07114_AdminEntity adm : adminEntity) {
            if(adm.getNpk().equals(npk)) {
                return adm;
            }
        }
        return null;
    }

    public andre07114_AdminEntity getDataByIndex(int index) {
        return adminEntity.get(index);
    }

    public int getMax() {
        return adminEntity.size();
    }

    public andre07114_AdminEntity getDataByNpk(String npk) {
        for (andre07114_AdminEntity admin : adminEntity){
            if (admin.getNpk().equals(npk)){
                return admin;
            }
        }
        return null;
    }
}
