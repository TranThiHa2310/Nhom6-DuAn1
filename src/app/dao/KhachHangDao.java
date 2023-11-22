/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.dbconnect.DBConnector;
import app.model.KhachHang;
import app.service.KhachHangInterface;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class KhachHangDao implements KhachHangInterface {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public KhachHangDao() {
        try {
            con = DBConnector.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<KhachHang> getAll() {

        List<KhachHang> listKhach = new ArrayList<>();
        try {
            String query = "SELECT ma_kh,ten,sdt,dia_chi,gioi_tinh FROM KhachHang6";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma_kh");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String diaChi = rs.getString("dia_chi");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");

                KhachHang s = new KhachHang(ma, ten, sdt, diaChi, gioiTinh);
                listKhach.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhach;

    }

    public List<KhachHang> timKiem(String maKH, String tenKH, String sdtKH) {

        List<KhachHang> list = new ArrayList<>();
        try {
            String query = "  SELECT ma_kh,ten,sdt,dia_chi,gioi_tinh from  KhachHang6 WHERE ma_kh like '%" + maKH + "%' or ten like '%" + tenKH + "%' or  sdt like '%" + sdtKH + "%'";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString("ma_kh");
                String tenKHH = rs.getString("ten");
                String sdtKHH = rs.getString("sdt");
                String diaChiKHH = rs.getString("dia_chi");
                boolean gioiTinhKH = rs.getBoolean("gioi_tinh");
                KhachHang s = new KhachHang(ma, tenKHH, sdtKHH, diaChiKHH, gioiTinhKH);
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;

    }

    public List<KhachHang> lichSu(String maKH) {

        List<KhachHang> list = new ArrayList<>();
        try {
            String query = "SELECT HoaDon6.ma_hoa_don,KhachHang6.ma_kh, KhachHang6.ten,KhachHang6.sdt,KhachHang6.dia_chi, HoaDon6.ngay_hoan_thanh,HoaDon6.tong_tien, HoaDon6.trang_thai FROM KhachHang6 INNER JOIN  HoaDon6 ON KhachHang6.ma_kh = HoaDon6.ma_kh where HoaDon6.ma_kh like '%" + maKH + "%'";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maHD = rs.getString("ma_hoa_don");
                String maKHH = rs.getString("ma_kh");
                String tenKH = rs.getString("ten");
                String sdtKH = rs.getString("sdt");
                String diaChiKH = rs.getString("dia_chi");
                Date ngay = rs.getDate("ngay_hoan_thanh");
                Double tien = rs.getDouble("tong_tien");
                int trangThai = rs.getInt("trang_thai");

                KhachHang  s = new KhachHang(maKHH, tenKH, sdtKH, diaChiKH, maHD, ngay, tien, trangThai);
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;

    }



    @Override
    public String addNV(KhachHang kh) throws Exception {

        try {
            String query = "INSERT INTO KhachHang6 (ma_kh, ten, sdt, dia_chi,gioi_tinh ) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, kh.getMaKH());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getSdt());
            ps.setString(4, kh.getDiaChi());
            ps.setBoolean(5, kh.isGioiTinh());
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    @Override
    public String deleteNV(String ma) throws SQLServerException, Exception {
        try {
            String query = "DELETE FROM KhachHang6 WHERE ma_kh = ? ";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ma);
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    @Override
    public String updateNV(KhachHang kh) throws SQLServerException, Exception {
        try {
            String query = "UPDATE KhachHang6 SET ten = ? , sdt = ? , dia_chi = ? , gioi_tinh = ? WHERE ma_kh = ?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, kh.getTen());
            ps.setString(2, kh.getSdt());
            ps.setString(3, kh.getDiaChi());
            ps.setBoolean(4, kh.isGioiTinh());
            ps.setString(5, kh.getMaKH());
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

}
