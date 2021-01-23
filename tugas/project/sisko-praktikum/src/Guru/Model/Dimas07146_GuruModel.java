package Guru.Model;
import Guru.Entity.Dimas07146_GuruEntity;


import java.util.ArrayList;

public class Dimas07146_GuruModel {
    private ArrayList<Dimas07146_GuruEntity> GuruArrayList;

    public Dimas07146_GuruModel(){
        GuruArrayList = new ArrayList<Dimas07146_GuruEntity>();
    }

    public Dimas07146_GuruEntity getData(int index){
        return GuruArrayList.get(index);
    }

    public int getSize(){
        return GuruArrayList.size();
    }

    public boolean insert(Dimas07146_GuruEntity guruEntity){
        GuruArrayList.add(guruEntity);
        if(GuruArrayList.contains(guruEntity)){
            return true;
        }
        return false;
    }

    public boolean update(Dimas07146_GuruEntity newGuruEntity, String IDNum){
        for (int i=0; i<GuruArrayList.size(); i++){
            if(GuruArrayList.get(i).getIDNum() == IDNum){
                GuruArrayList.set(i, newGuruEntity);
                return true;
            }
        }
        return false;
    }

    public Dimas07146_GuruEntity getDataByNIP(String nip){
        for (Dimas07146_GuruEntity guru : GuruArrayList){
            if (guru.getNIP().equals(nip)){
                return guru;
            }
        }
        return null;
    }

    public int delete(String NIP){
        System.out.println("Array: " + GuruArrayList.size());
        int index=0;
        if(GuruArrayList.size() == 0){
            index = -1;
        }
        else {
            for (int i=0; i<GuruArrayList.size(); i++){
                if (NIP.equals(GuruArrayList.get(i).getNIP())){
                    System.out.println("Data Guru : "+ GuruArrayList.get(i).getNama() + "Telah Dihapus");
                    index = i;
                    GuruArrayList.remove(i);
                    break;
                }
            }
        }
        return index;
    }


    public int cekData(String NIP){
        int index = 0;
        //System.out.println("NIP = " + NIP);
        if(GuruArrayList.size() == 0) {
            index = -1;
        } else {
            for(int i = 0; i < GuruArrayList.size(); i++) {
                if(NIP.equals(GuruArrayList.get(i).getNIP())) {
                    System.out.println(GuruArrayList.get(i).getNama());
                    index = i;
                    break;
                } else {
                    index = -2;
                }
            }
        }
        return index;
    }

    public ArrayList<Dimas07146_GuruEntity>
    alldataguru(){return GuruArrayList; }

}
