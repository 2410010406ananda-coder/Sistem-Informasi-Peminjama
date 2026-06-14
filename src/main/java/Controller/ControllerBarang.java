package Controller;

import Koneksi.koneksi;
import Model.ModelBarang;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControllerBarang {

    Connection cn = koneksi.getConnection();

    public void tambah(ModelBarang barang) {

        try {
            String sql = "INSERT INTO tb_barang (nama_barang, stok) VALUES('"
                    + barang.getNama_barang() + "','"
                    + barang.getStok() + "')";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data barang berhasil ditambahkan");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void edit(ModelBarang barang) {

        try {
            String sql = "UPDATE tb_barang SET "
                    + "nama_barang='" + barang.getNama_barang() + "', "
                    + "stok='" + barang.getStok() + "' "
                    + "WHERE id_barang='" + barang.getId_barang() + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data barang berhasil diubah");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void hapus(String id_barang) {

        try {
            String sql = "DELETE FROM tb_barang "
                    + "WHERE id_barang='" + id_barang + "'";

            cn.createStatement().executeUpdate(sql);

            JOptionPane.showMessageDialog(null,
                    "Data barang berhasil dihapus");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public void tampil(DefaultTableModel model) {

        model.setRowCount(0);

        try {

            String sql = "SELECT * FROM tb_barang";

            ResultSet rs = cn.createStatement().executeQuery(sql);

            while (rs.next()) {

                Object[] data = {
                    rs.getString("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("stok")
                };

                model.addRow(data);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }

    public ResultSet cariBerdasarkanId(String id_barang) {

        try {

            String sql = "SELECT * FROM tb_barang "
                    + "WHERE id_barang='" + id_barang + "'";

            return cn.createStatement().executeQuery(sql);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

            return null;
        }
    }
}