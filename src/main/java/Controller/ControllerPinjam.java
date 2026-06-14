package Controller;

import Koneksi.koneksi;
import Model.ModelPinjam;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerPinjam {

    public Connection cn = koneksi.getConnection();

    public void tambah(ModelPinjam pinjam) {

        try {
            String sql = "INSERT INTO tb_pinjam "
                    + "(peminjam, tanggal, id_barang) VALUES('"
                    + pinjam.getPeminjam() + "','"
                    + pinjam.getTanggal() + "','"
                    + pinjam.getId_barang() + "')";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data peminjaman berhasil ditambahkan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void edit(ModelPinjam pinjam) {

        try {
            String sql = "UPDATE tb_pinjam SET "
                    + "peminjam='" + pinjam.getPeminjam() + "', "
                    + "tanggal='" + pinjam.getTanggal() + "', "
                    + "id_barang='" + pinjam.getId_barang() + "' "
                    + "WHERE id_pinjam='" + pinjam.getId_pinjam() + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data peminjaman berhasil diubah");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void hapus(String id_pinjam) {

        try {
            String sql = "DELETE FROM tb_pinjam "
                    + "WHERE id_pinjam='" + id_pinjam + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data peminjaman berhasil dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void tampil(DefaultTableModel model) {

        model.setRowCount(0);

        try {

            String sql = "SELECT p.id_pinjam, p.peminjam, "
                    + "p.tanggal, b.nama_barang "
                    + "FROM tb_pinjam p "
                    + "JOIN tb_barang b "
                    + "ON p.id_barang=b.id_barang";

            ResultSet rs = cn.createStatement().executeQuery(sql);

            while (rs.next()) {

                Object[] data = {
                    rs.getString("id_pinjam"),
                    rs.getString("peminjam"),
                    rs.getString("tanggal"),
                    rs.getString("nama_barang")
                };

                model.addRow(data);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public ResultSet cariBerdasarkanId(String id_pinjam) {

        try {

            String sql = "SELECT * FROM tb_pinjam "
                    + "WHERE id_pinjam='" + id_pinjam + "'";

            return cn.createStatement().executeQuery(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

            return null;
        }
    }
    
    public ResultSet tampilBarang() {

    try {

        String sql = "SELECT * FROM tb_barang";

        return cn.createStatement().executeQuery(sql);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                e.getMessage()
        );

        return null;
    }
}
}