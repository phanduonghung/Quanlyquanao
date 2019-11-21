/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {
    public String manv;
    public String matkhau;
    public String tennv;
    public Date ngaysinh;
    public float luong;
    public boolean gioitinh;
    public String sdt;

    public NhanVien() {
    }

    public NhanVien(String manv, String matkhau, String tennv, Date ngaysinh, float luong, boolean gioitinh, String sdt) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.tennv = tennv;
        this.ngaysinh = ngaysinh;
        this.luong = luong;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
 
}
