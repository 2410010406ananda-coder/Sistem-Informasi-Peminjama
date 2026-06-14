package Model;

/**
 *
 * @author Nanda
 */
public class ModelBarang {

    private int id_barang;
    private String nama_barang;
    private int stok;

    public int getId_barang() {
        return id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public int getStok() {
        return stok;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}