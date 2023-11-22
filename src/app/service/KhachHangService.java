/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.dao.KhachHangDao;
import java.util.List;
import app.model.KhachHang;

/**
 *
 * @author Dell
 */
public class KhachHangService {
     private KhachHangDao dao;

    public KhachHangService() {
    dao = new KhachHangDao();
    }
    
    public List<KhachHang> getAll() {
        return dao.getAll();
    }
     public void them(KhachHang s) throws Exception {
        dao.addNV(s);
    }

     public void sua(KhachHang s) throws Exception {
        dao.updateNV(s);
    }
       public void xoa(String index) throws Exception {
        dao.deleteNV(index);
    }

}
