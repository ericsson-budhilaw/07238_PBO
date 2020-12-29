package Entity;

public abstract class UserAbstractEntity {
    protected String nama;

    public UserAbstractEntity(String nama) {
        this.nama = nama;
    }

    public abstract String getNama();

    public void setNama(String nama) {
        this.nama = nama;
    }
}
