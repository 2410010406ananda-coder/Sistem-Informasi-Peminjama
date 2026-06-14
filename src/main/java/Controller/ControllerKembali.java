package Controller;

import Koneksi.koneksi;
import Model.ModelKembali;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerKembali {

    Connection cn = koneksi.getConnection();

    public void tambah(ModelKembali kembali) {

        try {
            String sql = "INSERT INTO tb_kembali "
                    + "(tanggal, id_pinjam) VALUES('"
                    + kembali.getTanggal() + "','"
                    + kembali.getId_pinjam() + "')";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data pengembalian berhasil ditambahkan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void edit(ModelKembali kembali) {

        try {
            String sql = "UPDATE tb_kembali SET "
                    + "tanggal='" + kembali.getTanggal() + "', "
                    + "id_pinjam='" + kembali.getId_pinjam() + "' "
                    + "WHERE id_kembali='" + kembali.getId_kembali() + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data pengembalian berhasil diubah");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void hapus(String id_kembali) {

        try {
            String sql = "DELETE FROM tb_kembali "
                    + "WHERE id_kembali='" + id_kembali + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data pengembalian berhasil dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void tampil(DefaultTableModel model) {

        model.setRowCount(0);

        try {

            String sql = "SELECT k.id_kembali, "
                    + "p.peminjam, "
                    + "b.nama_barang, "
                    + "k.tanggal "
                    + "FROM tb_kembali k "
                    + "JOIN tb_pinjam p "
                    + "ON k.id_pinjam=p.id_pinjam "
                    + "JOIN tb_barang b "
                    + "ON p.id_barang=b.id_barang";

            ResultSet rs = cn.createStatement().executeQuery(sql);

            while (rs.next()) {

                Object[] data = {
                    rs.getString("id_kembali"),
                    rs.getString("peminjam"),
                    rs.getString("nama_barang"),
                    rs.getString("tanggal")
                };

                model.addRow(data);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public ResultSet cariBerdasarkanId(String id_kembali) {

        try {

            String sql = "SELECT * FROM tb_kembali "
                    + "WHERE id_kembali='" + id_kembali + "'";

            return cn.createStatement().executeQuery(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

            return null;
        }
    }
    
 
}