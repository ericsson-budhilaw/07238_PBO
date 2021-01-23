package Guru.Entity;

public abstract class Dimas07146_PersonEntity {
    protected String nama;
    protected String IDNum;

    public Dimas07146_PersonEntity(String nama, String IDNum){
        this.nama = nama;
        this.IDNum = IDNum;
    }

    public abstract String getNama();
    public void setNama(String nama) {
        this.nama = nama;
    }

    public abstract String getIDNum();
    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }
}
