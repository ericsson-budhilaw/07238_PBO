package Entity;

public abstract class Eric07238_UserAbstractEntity {
    protected String nama;

    public Eric07238_UserAbstractEntity(String nama) {
        this.nama = nama;
    }

    public abstract String getNama();

    public void setNama(String nama) {
        this.nama = nama;
    }
}
