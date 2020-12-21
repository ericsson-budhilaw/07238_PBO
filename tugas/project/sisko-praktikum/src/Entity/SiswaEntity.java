package Entity;

/*
 * Menerapkkan Inheritance
 */
public class SiswaEntity extends UserAbstractEntity {
    private String kelas;
    private int nis;

    public SiswaEntity(int nis, String nama, String kelas) {
        super(nama);
        this.kelas  = kelas;
        this.nis    = nis;
    }

    /*
     * Menerapkan Polymorphism
     */
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
