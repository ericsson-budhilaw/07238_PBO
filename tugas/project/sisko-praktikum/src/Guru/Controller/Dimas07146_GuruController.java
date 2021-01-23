package Guru.Controller;
import Guru.Entity.Dimas07146_GuruEntity;
import Guru.Model.Dimas07146_GuruModel;

import javax.swing.table.DefaultTableModel;

public class Dimas07146_GuruController {
    private Dimas07146_GuruModel guruModel = new Dimas07146_GuruModel();

    public Dimas07146_GuruController(){
    }

    public int maxData(){
        return guruModel.getSize();
    }

    public Dimas07146_GuruEntity view(int index){
        return guruModel.getData(index);
    }

    public String insert(Dimas07146_GuruEntity guruEntity){
        boolean result = guruModel.insert(guruEntity);
        if (result){
            return "Data Berhasil Ditambahkan";
        }
        return "Data Gagal Ditambahkan";
    }

    public Dimas07146_GuruEntity getDataByNIP(String nip){
        return guruModel.getDataByNIP(nip);
    }

    public String update(Dimas07146_GuruEntity guruEntity, String IDNum){
        boolean result = guruModel.update(guruEntity, IDNum);
        if (result){
            return "Data Berhasil Diedit !";
        }
        return "Data Tidak Berhasil Diedit !";
    }

    public int cekData(String NIP){
        return guruModel.cekData(NIP);
    }
    public int hapusData(String NIP){
        return guruModel.delete(NIP);
    }

    public DefaultTableModel daftarguru(){
        DefaultTableModel dtmdaftarguru = new DefaultTableModel();
        Object[] kolom = {"Nama", "NIK", "NIP", "IDNum"};
        dtmdaftarguru.setColumnIdentifiers(kolom);
        //Dimas07146_GuruModel daftargurumodel = new Dimas07146_GuruModel();
        int size = Dimas07146_AllObjectModel.guruModel.alldataguru().size();

        for (int i=0; i<size; i++){
            Object[] data = new Object[4];
            data[0] = Dimas07146_AllObjectModel.guruModel.alldataguru().get(i).getNama();
            data[1] = Dimas07146_AllObjectModel.guruModel.alldataguru().get(i).getNIK();
            data[2] = Dimas07146_AllObjectModel.guruModel.alldataguru().get(i).getNIP();
            data[3] = Dimas07146_AllObjectModel.guruModel.alldataguru().get(i).getIDNum();
            dtmdaftarguru.addRow(data);
        }
        return dtmdaftarguru;
    }

}
