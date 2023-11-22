/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class KhachHang {

    private String maKH;
    private String ten;
    private String sdt;
    private String diaChi;
    private boolean gioiTinh;
    
    
      private String MaHD;
      private String tenNN;
    private Date NgayGiaoDich;
    private Double TongTien;
    private int TrangThai1;

    public KhachHang() {
    }

    public KhachHang(String maKH, String ten, String sdt, String diaChi, String MaHD, Date NgayGiaoDich, Double TongTien, int TrangThai1) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.MaHD = MaHD;
        this.NgayGiaoDich = NgayGiaoDich;
        this.TongTien = TongTien;
        this.TrangThai1 = TrangThai1;
    }
    
    
    public KhachHang(String MaHD, String tenNN, Date NgayGiaoDich, Double TongTien, int TrangThai1) {
        this.MaHD = MaHD;
        this.tenNN = tenNN;
        this.NgayGiaoDich = NgayGiaoDich;
        this.TongTien = TongTien;
        this.TrangThai1 = TrangThai1;
    }

//    public KhachHang(String maKH, String MaHD, String tenNN, Date NgayGiaoDich, Double TongTien, int TrangThai1) {
//        this.maKH = maKH;
//        this.MaHD = MaHD;
//        this.tenNN = tenNN;
//        this.NgayGiaoDich = NgayGiaoDich;
//        this.TongTien = TongTien;
//        this.TrangThai1 = TrangThai1;
//    }
//    
    


    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getTenNN() {
        return tenNN;
    }

    public void setTenNN(String tenNN) {
        this.tenNN = tenNN;
    }

    public Date getNgayGiaoDich() {
        return NgayGiaoDich;
    }

    public void setNgayGiaoDich(Date NgayGiaoDich) {
        this.NgayGiaoDich = NgayGiaoDich;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangThai1() {
        return TrangThai1;
    }

    public void setTrangThai1(int TrangThai1) {
        this.TrangThai1 = TrangThai1;
    }
    
    

    public KhachHang(String maKH, String ten, String sdt, String diaChi, boolean gioiTinh) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public KhachHang(String maKH, String ten, String sdt) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 8;

    public Object[] toInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String generateCode() {
        Random random = new SecureRandom();
        int CODE_LENGTH = 0;
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());

            code.append(CHARACTERS.charAt(randomIndex));
        }

        return code.toString();
    }

}
