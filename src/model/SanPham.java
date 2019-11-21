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
public class SanPham {
    public String masp;
    public String tensp;
    public String size;
    public String dongia;
    public Date ngaynhapkho;
    public String hinh;

    public SanPham() {
    }

    public SanPham(String masp, String tensp, String size, String dongia, Date ngaynhapkho, String hinh) {
        this.masp = masp;
        this.tensp = tensp;
        this.size = size;
        this.dongia = dongia;
        this.ngaynhapkho = ngaynhapkho;
        this.hinh = hinh;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public Date getNgaynhapkho() {
        return ngaynhapkho;
    }

    public void setNgaynhapkho(Date ngaynhapkho) {
        this.ngaynhapkho = ngaynhapkho;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    
    
}
