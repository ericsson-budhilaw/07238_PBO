package Staff.Entity;

public class andre07114_Staff extends andre07114_Abstract {
    private String staff;
    private int npk;

    public andre07114_Staff(int npk, String nama, String staff) {
        super(nama);
        this.staff = staff;
        this.npk = npk;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public String getDivisi() {
        return staff;
    }

    public void setDivisi(String staff) {
        this.staff = staff;
    }

    public int getNpk() {
        return npk;
    }

    public void setNpk(int npk) {
        this.npk = npk;
    }
}
