/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.service;

import java.util.List;
import app.model.KhachHang;


/**
 *
 * @author Dell
 */
public interface KhachHangInterface {
     public List<KhachHang> getAll();

    public String addNV(KhachHang kh) throws Exception;

    public String deleteNV(String ma) throws Exception;

    public String updateNV(KhachHang kh ) throws Exception;
}
