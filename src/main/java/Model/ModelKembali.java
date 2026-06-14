package Model;

/**
 *
 * @author Nanda
 */
public class ModelKembali {

    private int id_kembali;
    private String tanggal;
    private int id_pinjam;

    public int getId_kembali() {
        return id_kembali;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getId_pinjam() {
        return id_pinjam;
    }

    public void setId_kembali(int id_kembali) {
        this.id_kembali = id_kembali;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
    }
}