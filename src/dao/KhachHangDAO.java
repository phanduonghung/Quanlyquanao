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
import model.KhachHang;

/**
 *
 * @author Admin
 */

    public class KhachHangDAO{
                 public void insert(KhachHang model){   
           String sql="INSERT INTO KhachHang (makh, tenkh, gioitinh, ngaydk, diachi, sdt, ghichu) VALUES (?, ?, ?, ?, ?, ?, ?)";      
                     JdbcHelper.executeUpdate(sql,             
                   model.getMakh(),               
                   model.getTenkh(),               
                   model.isGioitinh(), 
                   model.getNgaydk(),
                   model.getDiachi(),                  
                   model.getSdt(),  
                   model.getGhichu());
       }      
       public void update(KhachHang model){   
           String sql="UPDATE KhachHang SET tenkh=?, gioitinh=?, ngaydk=? diachi=? sdt=? ghichu=? WHERE makh=?";  
           JdbcHelper.executeUpdate(sql,                          
                                 
                   model.getTenkh(),               
                   model.isGioitinh(), 
                   model.getNgaydk(),
                   model.getDiachi(),                  
                   model.getSdt(),  
                   model.getGhichu(),
                    model.getMakh());
               }               
        public void delete(String makh){ 
             String sql="DELETE FROM KhachHang WHERE makh=?"; 
             JdbcHelper.executeUpdate(sql, makh);   
        }        
             public List<KhachHang> select(){      
             String sql="SELECT * FROM KhachHang";   
            return select(sql);  
             }   
              
        public KhachHang findById(String makh){    
              String sql="SELECT * FROM KhachHang WHERE makh=?"; 
              List<KhachHang> list = select(sql, makh);    
            return list.size() > 0 ? list.get(0) : null;  
        } 
    private List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();

        ResultSet rs ;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhachHang model = readFromResultSet(rs);
                list.add(model);
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
     private KhachHang readFromResultSet(ResultSet rs)
        throws SQLException{    
              KhachHang model=new KhachHang();      
              model.setMakh(rs.getString("makh"));   
              model.setTenkh(rs.getString("tenkh")); 
             model.setGioitinh(rs.getBoolean("gioitinh"));   
              model.setNgaydk(rs.getDate("ngaydk")); 
              model.setSdt(rs.getString("sdt"));
              model.setDiachi(rs.getString("diachi"));
              model.setGhichu(rs.getString("ghichu"));
        return model;  
} 
}
