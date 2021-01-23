package Guru.Entity;

public class Dimas07146_GuruEntity extends Dimas07146_PersonEntity{
    private String NIP;
    private String NIK;

    public Dimas07146_GuruEntity(String nama, String NIP, String NIK, String IDNum){
        super(nama, IDNum = 1+NIK);
        this.NIK = NIK;
        this.NIP = NIP;
    }

    @Override
    public String getNama() {
        return nama;
    }
    @Override
    public String getIDNum() {
        return IDNum;
    }

    public String getNIP() {
        return NIP;
    }
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNIK() {
        return NIK;
    }
    public void setNIK(String NIK) {
        this.NIK = NIK;
    }
}
