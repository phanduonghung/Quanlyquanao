/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.Date;
import javax.print.DocFlavor;

/**
 *
 * @author Admin
 */
public class KhachHang {
    public String makh;
    public String tenkh;
    public boolean gioitinh;
    public Date ngaydk;
    public String sdt;
    public String diachi;
    public String ghichu;

    public KhachHang() {
    }

    public KhachHang(String makh, String tenkh, boolean gioitinh, Date ngaydk, String sdt, String diachi, String ghichu) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.gioitinh = gioitinh;
        this.ngaydk = ngaydk;
        this.sdt = sdt;
        this.diachi = diachi;
        this.ghichu = ghichu;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaydk() {
        return ngaydk;
    }

    public void setNgaydk(Date ngaydk) {
        this.ngaydk = ngaydk;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
    
}

