package Murid.Entity;

public class Eric07238_SiswaEntity extends Eric07238_UserAbstractEntity {
    private String kelas;
    private int nis;

    public Eric07238_SiswaEntity(int nis, String nama, String kelas) {
        super(nama);
        this.kelas  = kelas;
        this.nis    = nis;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getNis() {
        return nis;
    }

    public void setNis(int nis) {
        this.nis = nis;
    }
}
