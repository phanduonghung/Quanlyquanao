/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author Admin
 */
public class NhanVienDAO {
                 public void insert(NhanVien model){   
           String sql="INSERT INTO NhanVien (manv, matkhau, tennv, ngaysinh, luong, gioitinh, sdt) VALUES (?, ?, ?, ?, ?, ?, ?)";      
           JdbcHelper.executeUpdate(sql,             
                   model.getManv(),               
                   model.getMatkhau(),               
                   model.getTennv(), 
                   model.getNgaysinh(),
                   model.getLuong(),                  
                   model.isGioitinh(),  
                   model.getSdt());
       }      
       public void update(NhanVien model){   
           String sql="UPDATE NhanVien SET matkhau=?, tennv=?, ngaysinh=? luong=? gioitinh=? sdt=? WHERE manv=?";  
           JdbcHelper.executeUpdate(sql,                          
                   model.getMatkhau(),           
                   model.getTennv(), 
                   model.getNgaysinh(),
                   model.getLuong(),                  
                   model.isGioitinh(),  
                   model.getSdt(),
                   model.getManv());
               }               
        public void delete(String manv){ 
             String sql="DELETE FROM NhanVien WHERE manv=?"; 
             JdbcHelper.executeUpdate(sql, manv);   
        }        
             public List<NhanVien> select(){      
             String sql="SELECT * FROM NhanVien";   
            return select(sql);  
             }   
              
        public NhanVien findById(String manv){    
              String sql="SELECT * FROM NhanVien WHERE manv=?"; 
              List<NhanVien> list = select(sql, manv);    
            return list.size() > 0 ? list.get(0) : null;  
        } 
    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();

        ResultSet rs ;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                NhanVien model = readFromResultSet(rs);
                list.add(model);
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
     private NhanVien readFromResultSet(ResultSet rs)
        throws SQLException{    
              NhanVien model=new NhanVien();      
              model.setManv(rs.getString("manv"));   
              model.setMatkhau(rs.getString("matkhau")); 
              model.setTennv(rs.getString("tennv"));   
              model.setNgaysinh(rs.getDate("ngaysinh")); 
              model.setLuong(rs.getFloat("luong"));
              model.setGioitinh(rs.getBoolean("gioitinh"));
              model.setSdt(rs.getString("sdt"));
        return model;  
} 
       }
