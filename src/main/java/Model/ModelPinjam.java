package Model;

/**
 *
 * @author Nanda
 */
public class ModelPinjam {

    private int id_pinjam;
    private String peminjam;
    private String tanggal;
    private int id_barang;

    public int getId_pinjam() {
        return id_pinjam;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public String getTanggal() {
        return tanggal;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }
}